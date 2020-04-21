package com.gyh.service;

import com.gyh.entity.User;
import com.gyh.mapper.FreemakerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreemakerServiceImpl implements FreemakerService{
    @Autowired
    private FreemakerMapper freemakerMapper;

    @Override
    public List<User> findList(String name) {

        return freemakerMapper.findList(name);
    }
}
