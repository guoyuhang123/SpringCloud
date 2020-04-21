package com.gyh.service;

import com.gyh.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Zk1ServiceImpl implements Zk1Service{

    @Override
    public List<User> list() {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setName("五");
        list.add(user);
        return list;
    }
}
