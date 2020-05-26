package com.example.demo.ch7.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@IdClass(ParentId.class) // IdClass  사용 -> DB에 맞춘 방법
@Data
public class Parent {

    @Id
    @Column(name = "PARENT_ID1")
    private String id1;

    @Id
    @Column(name = "PARENT_ID2")
    private String id2;

    private String name;



}
