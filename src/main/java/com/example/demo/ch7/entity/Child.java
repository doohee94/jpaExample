package com.example.demo.ch7.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Child {

    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "CHILD_ID1", referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "CHILD_ID2", referencedColumnName = "PARENT_ID2")
    })
    private Parent parent;
}
