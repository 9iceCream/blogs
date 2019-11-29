package com.monolog7.blogs.controller;

import com.alibaba.fastjson.JSON;
import com.monolog7.blogs.entity.BlogsOwner;
import com.monolog7.blogs.entity.DictionaryConst;
import com.monolog7.blogs.service.BlogsOwnerService;
import com.monolog7.blogs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(description = "用户信息")
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private BlogsOwnerService blogsOwnerService;

    @ApiOperation(value = "添加用户")
    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "/blogs/user",method = RequestMethod.POST)
    public String register(@RequestBody BlogsOwner blogsOwner){
        logger.info("register#入参：{}", JSON.toJSONString(blogsOwner));
        String response = userService.addUser(blogsOwner);
        logger.info("register#出参：{}", response);
        return response;
    }

    @ApiOperation(value = "校验用户")
    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "/blogs/login",method = RequestMethod.POST)
    public String login(@RequestBody BlogsOwner blogsOwner, HttpSession session){
        logger.info("login#入参：{}",JSON.toJSONString(blogsOwner));
        String response = userService.userLogin(blogsOwner,session);
        logger.info("login#出参：{}",response);
        return response;
    }

    @ApiOperation(value = "校验是否登录")
    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "/blogs/checkLogin",method = RequestMethod.GET)
    public String checkLogin(HttpSession session){
        logger.info("checkLogin#session:{}",JSON.toJSONString(session));
        String response = blogsOwnerService.getMyInfo(session,DictionaryConst.USER_OPER_2);
        return response;
    }

}
