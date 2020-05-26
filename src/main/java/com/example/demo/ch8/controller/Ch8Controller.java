package com.example.demo.ch8.controller;

import com.example.demo.ch8.service.Ch8Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ch8")
@RequiredArgsConstructor
public class Ch8Controller {

    private final Ch8Service ch8Service;

    @GetMapping(value = "/proxy-test")
    public void proxyTest(){
        ch8Service.proxyTest();
    }

}
