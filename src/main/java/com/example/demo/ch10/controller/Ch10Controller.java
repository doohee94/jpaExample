package com.example.demo.ch10.controller;

import com.example.demo.ch10.service.Ch10Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ch10")
@RequiredArgsConstructor
public class Ch10Controller {

    private final Ch10Service ch10Service;

    @GetMapping(value = "/jpql-find-simple")
    public void jpqlFindSimple(){
        ch10Service.jpqlFindSimple();
    }

    @GetMapping(value = "criteria-find-simple")
    public void criteriaFindSimple(){
        ch10Service.critreiaFindSimple();
    }
}
