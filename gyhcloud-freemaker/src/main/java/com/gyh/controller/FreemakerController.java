package com.gyh.controller;

import com.gyh.entity.User;
import com.gyh.service.FreemakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FreemakerController{
    @Autowired
    private FreemakerService freemakerService;

    @RequestMapping("list")
    public List<User> findList(String name){

        return freemakerService.findList(name);
    }


}
