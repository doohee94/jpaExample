package com.example.demo.ch6.entity;

import com.example.demo.ch2.entity.Member;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    String productId;
    String name;

//    @ManyToMany(mappedBy = "products")
//    private List<Member> members;




}
