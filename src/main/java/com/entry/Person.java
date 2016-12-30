package com.entry;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 创建时间： 2016/12/30</p>
 * <p> 描述： </p>
 *
 * @author : mawl
 * @version 1.0
 */
//设置Person类在xml中的别名
@XStreamAlias("person")
public class Person {
    // 将name设置为xml person 元素的attribute
    @XStreamAsAttribute
    private String name;
    private int phoneNumber;

    //将此字段名在XML中去掉
    @XStreamImplicit
    private List<Address> addresses = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
