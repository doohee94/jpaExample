package com.example.demo.ch7.controller;

import com.example.demo.ch7.service.Ch7Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ch7")
@RequiredArgsConstructor
public class Ch7Controller {

    private final Ch7Service ch7Service;

    @GetMapping(value = "/IdClass/composite-key-save")
    public void compositeKeySave(){
        ch7Service.compositeKeySave();
    }

}
