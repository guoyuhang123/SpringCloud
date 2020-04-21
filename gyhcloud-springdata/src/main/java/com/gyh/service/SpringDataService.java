package com.gyh.service;

import com.gyh.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SpringDataService {

    List<User> list();

    User addUser(User user);

    void deleteUser(int id);

    User update(User user);

    Optional<User> findById(int id);

    Page<User> pageList(User user,int pagenum, int pagesize);

    List<User> findByUsernameLike(String username);
}
