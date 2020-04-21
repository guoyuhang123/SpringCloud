package com.gyh.dao;

import com.gyh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {


    void deleteById(Integer id);

    Optional<User> findById(int id);

    List<User> findByUsernameLike(String username);

    @Query("select u from User u where u.username like %?1%")
    List<User> getlist(String username);

    @Query(value = "select * from user where username like %?1%",nativeQuery = true)
    List<User> getlist2(String username);


}
