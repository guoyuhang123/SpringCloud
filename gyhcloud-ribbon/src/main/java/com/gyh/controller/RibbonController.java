package com.gyh.controller;

import com.gyh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("list")
    public List<User> list(){
      List<User> list =  restTemplate.getForObject("http://gyhcloud-zk1/user/list",List.class);

      return list;
    }

}
