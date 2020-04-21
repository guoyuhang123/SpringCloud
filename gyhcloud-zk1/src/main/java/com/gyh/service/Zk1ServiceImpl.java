package com.gyh.service;


import com.gyh.mapper.Zk1Mapper;
import com.gyh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Zk1ServiceImpl implements Zk1Service {

    @Autowired
    private Zk1Mapper k1Mapper;

    @Override
    public List<User> list() {

        return k1Mapper.list();
    }
}
