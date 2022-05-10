package com.jian.pojo;

import java.util.List;
import java.util.Map;

public class Users {
    private String username;
    private List<String> userlike;
    private Address address;
    private List<Address> addressList;
    private Map<String,Address> addressMap;

    public Map<String, Address> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<String, Address> addressMap) {
        this.addressMap = addressMap;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", userlike=" + userlike +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getUserlike() {
        return userlike;
    }

    public void setUserlike(List<String> userlike) {
        this.userlike = userlike;
    }
}
