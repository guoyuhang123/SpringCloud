package com.gyh.service;

import com.gyh.dao.SpringDataDao;
import com.gyh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SpringDataServiceImpl implements SpringDataService{
    @Autowired
    private SpringDataDao springDataDao;


    @Override
    public List<User> list() {

        return springDataDao.findAll();
    }

    @Override
    public User addUser(User user) {

        return springDataDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        springDataDao.deleteById(id);

    }

    @Override
    public User update(User user) {

        return null;
    }

    @Override
    public Optional<User> findById(int id) {

        return springDataDao.findById(id);
    }

    @Override
    public Page<User> pageList(User user,int pagenum, int pagesize) {


        //Example<User> ex = Example.of(user);
        PageRequest page = PageRequest.of(pagenum-1,pagesize);
        Page<User> all = springDataDao.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate conjunction = criteriaBuilder.conjunction();
                List<Expression<Boolean>> expressions = conjunction.getExpressions();
                if(user!=null){
                    if(user.getUsername()!=null){
                        expressions.add(criteriaBuilder.like(root.get("username"),'%'+user.getUsername()+'%'));
                    }
                    if(user.getPassword()!=null){
                        expressions.add(criteriaBuilder.equal(root.get("password"),user.getPassword()));
                    }
                }

                return conjunction;
            }
        }, page);

        return all;
    }

    @Override
    public List<User> findByUsernameLike(String username) {

        return springDataDao.getlist(username);
    }


}
