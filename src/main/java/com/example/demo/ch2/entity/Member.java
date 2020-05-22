package com.example.demo.ch2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="MEMBER")
@Data
public class Member {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String username;

    private Integer age;

}
