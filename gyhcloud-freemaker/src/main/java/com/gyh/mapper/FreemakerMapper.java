package com.gyh.mapper;

import com.gyh.entity.User;

import java.util.List;

public interface FreemakerMapper {
    List<User> findList(String name);
}
