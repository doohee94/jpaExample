package com.example.demo.ch8.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
public class Address implements Cloneable {

    @Column(name = "city")
    private String city;
    private String street;
    private String zipcode;


    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
