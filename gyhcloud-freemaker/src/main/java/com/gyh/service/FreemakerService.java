package com.gyh.service;

import com.gyh.entity.User;

import java.util.List;

public interface FreemakerService {
    List<User> findList(String name);
}
