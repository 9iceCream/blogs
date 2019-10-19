package com.monolog7.blogs.controller;

import com.alibaba.fastjson.JSON;
import com.monolog7.blogs.entity.BlogsOwner;
import com.monolog7.blogs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "用户信息")
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户")
    @CrossOrigin
    @RequestMapping(value = "/blogs/user",method = RequestMethod.POST)
    public String register(@RequestBody BlogsOwner blogsOwner){
        logger.info("register#入参：{}", JSON.toJSONString(blogsOwner));
        String response = userService.addUser(blogsOwner);
        logger.info("register#出参：{}", response);
        return response;
    }

    @ApiOperation(value = "校验用户")
    @CrossOrigin
    @RequestMapping(value = "/blogs/login",method = RequestMethod.POST)
    public String login(@RequestBody BlogsOwner blogsOwner){
        logger.info("login#入参：{}",JSON.toJSONString(blogsOwner));
        String response = userService.checkUserLogin(blogsOwner);
        logger.info("login#出参：{}",response);
        return response;
    }

}
