package com.example.demo.ch2.controller;

import com.example.demo.ch2.service.Ch2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ch2")
@RequiredArgsConstructor
public class Ch2Controller {

    private final Ch2Service ch2Service;

    @GetMapping(value = "/test")
    public void test(){
        ch2Service.test();
    }

}
