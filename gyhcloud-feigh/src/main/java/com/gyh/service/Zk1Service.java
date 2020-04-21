package com.gyh.service;

import com.gyh.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "gyhcloud-zk1",fallback = Zk1ServiceImpl.class)
public interface Zk1Service {

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    List<User> list();
}
