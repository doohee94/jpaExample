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
    public void test() {
        ch2Service.test();
    }

    @GetMapping(value = "/saveTeamAndMember")
    public void saveTeamAndMember() {
        ch2Service.saveTeamAndMember();
    }

    @GetMapping(value = "/findentity")
    public void find() {
        ch2Service.find();
    }

    @GetMapping(value = "/update-entity")
    public void update() {
        ch2Service.update();
    }

    @GetMapping(value = "/delete-relation")
    public void deleteRelation() {
        ch2Service.deleteRelation();
    }

    @GetMapping(value = "/delete-entity")
    public void deleteEntity() {
        ch2Service.deleteEntity();
    }

    @GetMapping(value = "/onetomany-find")
    public void oneToManyFind(){
        ch2Service.oneToManyFind();
    }

    @GetMapping(value = "/ontomany-save")
    public void oneToManySave(){
        ch2Service.oneToManySave();
    }

}
