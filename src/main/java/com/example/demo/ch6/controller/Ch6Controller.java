package com.example.demo.ch6.controller;

import com.example.demo.ch6.service.Ch6Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ch6")
@RequiredArgsConstructor
public class Ch6Controller {

    private final Ch6Service ch6Service;

    @GetMapping(value = "/onetoone")
    public void oneToOneRelation(){
        ch6Service.oneToOneRelation();
    }

//    @GetMapping(value = "/manytomany-save")
//    public void manyToManySave(){
//        ch6Service.manyToManySave();
//    }
//
//    @GetMapping(value = "/manytomany-find")
//    public void manyToManyFind(){
//        ch6Service.manyToManyFind();
//    }

//    @GetMapping(value = "/manytomany-find-inverse")
//    public void manyToManyFindInverse(){
//        ch6Service.manyToManyFindInverse();
//    }

    @GetMapping(value = "/manytomay-save-other")
    public void manyToManySaveOther(){
        ch6Service.manyTomanySaveOther();
    }

    @GetMapping(value = "/manytomay-find-other")
    public void manyTomanyFindOther(){
        ch6Service.manyTomanyFindOther();
    }

    @GetMapping(value = "/order-save")
    public void orderSave(){
        ch6Service.orderSave();
    }

    @GetMapping(value = "/order-find")
    public void orderFind(){
        ch6Service.orderFind();
    }

}
