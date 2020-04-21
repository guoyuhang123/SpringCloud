package com.gyh.controller;

import com.gyh.model.User;
import com.gyh.service.Zk1Service;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("user")
public class Zk1Controller {
    @Autowired
    private Zk1Service zk1Service;

    @RequestMapping("list")
    public List<User> list(HttpServletRequest request){

        List<User> list = zk1Service.list();
        System.out.println(request.getRequestURI());
        return list;
    }



}
