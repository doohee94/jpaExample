package com.example.demo.ch9.controller;

import com.example.demo.ch9.service.Ch9Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ch9")
@RequiredArgsConstructor
public class Ch9Controller {

    private final Ch9Service ch9Service;

    @GetMapping(value = "/set-null")
    public void nullInEmbedded(){
        ch9Service.nullInEmbedded();
    }

    @GetMapping(value = "/copyObj")
    public void copyObj() throws CloneNotSupportedException {
        ch9Service.copyObj();
    }

    @GetMapping(value = "elementCollection")
    public void elementCollection(){
        ch9Service.elementCollection();
    }

    @GetMapping(value = "deleteEle")
    public void deleteElement(){
        ch9Service.deleteElement();
    }


}
