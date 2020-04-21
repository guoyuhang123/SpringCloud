package com.gyh.controller;

import com.gyh.model.User;
import com.gyh.service.Zk1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeighController {

    @Autowired
    private Zk1Service zk1Service;

    @RequestMapping("userlist")
    public List<User> userlist(){

        return zk1Service.list();
    }

}
