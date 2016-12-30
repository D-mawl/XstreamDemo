package com.entry.test;

import com.entry.Address;
import com.entry.Person;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.io.*;

/**
 * <p> 创建时间： 2016/12/30</p>
 * <p> 描述： </p>
 *
 * @author : mawl
 * @version 1.0
 */
public class StreamTest {

    private final static String cfline = "--------------------------------------------";

    @Test
    public void testResource() {

        System.out.println(StreamTest.class.getResource("/com/entry/xml").getPath());
    }


    @Test
    public void testXmlToEntry() throws IOException {
        System.out.println(cfline);
        File file = new File(StreamTest.class.getResource("/com/entry/xml/xmltoentry.xml").getPath());
        FileInputStream inputStream = new FileInputStream(file);
        StringBuffer inputXML = new StringBuffer();

        int size = 3;
        byte b[] = new byte[size];
        while (inputStream.read(b) > 0) {
            inputXML.append(new String(b, 0, b.length));
        }


        System.out.println("-- orgin xml --");
        System.out.println(inputXML);
        System.out.println("----------------");


        XStream xs = new XStream();
//        这句和@XStreamAlias("person")等效
//        xs.alias("person",Person.class);
//        xs.alias("address",Address.class);
        xs.setMode(XStream.NO_REFERENCES);
//      这句和@XStreamImplicit()等效
//        xs.addImplicitCollection(Person.class,"addresses");
//        这句和@XStreamAsAttribute()
//        xs.useAttributeFor(Person.class, "name");
        //注册使用了注解的VO
        xs.processAnnotations(new Class[]{Person.class, Address.class});
        Person person = (Person) xs.fromXML(inputXML.toString());
        System.out.println(person.getAddresses().get(0).getHouseNo() + person.getName());
        System.out.println(cfline);

    }

    @Test
    public void testEntryToXml() {
        System.out.println(cfline);
        System.out.println("entry to xml");

        XStream xStream = new XStream();
        Person person = new Person();
        person.setName("rojer");
        person.setPhoneNumber(999);
        Address address1 = new Address();
        address1.setHouseNo(888);
        address1.setStreet("newyork");
        Address address2 = new Address();
        address2.setHouseNo(76767);
        address2.setStreet("toyo");
        person.getAddresses().add(address1);
        person.getAddresses().add(address2);
//        xStream.alias("person", Person.class);
//        xStream.alias("address",Address.class);
        xStream.setMode(XStream.NO_REFERENCES);
//        xStream.addImplicitCollection(Person.class, "addresses");
//        xStream.useAttributeFor(Person.class,"name");
        //注册使用了注解的VO
        xStream.processAnnotations(new Class[]{Person.class, Address.class});
        String xml = xStream.toXML(person);

        System.out.println(xml);
        System.out.println(cfline);

    }
}
