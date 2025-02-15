package com.example.springboot.mongodb.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String province;
    private String country;

//Generate manual getter setter as lombok issue with IDE
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
