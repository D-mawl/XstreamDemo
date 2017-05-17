package com.entry;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p> 创建时间： 2016/12/30</p>
 * <p> 描述： </p>
 *
 * @author : mawl
 * @version 1.0
 */
@XStreamAlias("address")
public class Address {
    private String street;
    private Integer houseNo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }
}
