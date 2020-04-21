package com.gyh.controller;

import com.gyh.model.Result;
import com.gyh.model.User;
import com.gyh.service.SpringDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api("api实例")
@RestController
@RequestMapping("data")
public class SpringDataController {
    @Autowired
    private SpringDataService springDataService;

    @ApiOperation(value = "查询列表")
    @RequestMapping("list")
    public Result list(User user, @RequestParam(defaultValue = "1")int pagenum,@RequestParam(defaultValue="2")int pagesize){

        Page<User> page = springDataService.pageList(user,pagenum,pagesize);


        return new Result(page.getTotalElements(),page.getContent());
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping("save")
    public int save(User user){
        user.setUsername("lallaaa");
        user.setPassword("456");
        User user1 = springDataService.addUser(user);
        if(user1!=null){
            return 1;
        }else{
            return 2;
        }

    }

    @ApiOperation(value = "删除用户")
    @RequestMapping("delete")
    public int delete(int id){
        springDataService.deleteUser(id);

        return 1;
    }

    @ApiOperation(value = "查询用户")
    @RequestMapping("findById")
    public Optional<User> findById(int id){

        return springDataService.findById(id);
    }

    @ApiOperation(value = "模糊查询名称")
    @RequestMapping("likename")
    public List<User> list2(String username){


        return springDataService.findByUsernameLike(username);
    }

}
