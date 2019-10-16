package com.monolog7.blogs.controller;

import com.monolog7.blogs.dao.BlogsOwnerDao;
import com.monolog7.blogs.dao.RolePermissionDao;
import com.monolog7.blogs.service.BlogsOwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "博主信息")
@RestController
public class BlogsOwnerController {

    @Autowired
    private BlogsOwnerService blogsOwnerService;

    @ApiOperation(value = "查询博主信息")
    @CrossOrigin
    @RequestMapping(value = "/blogs/owner",method = RequestMethod.GET)
    public String getBlogsOwner(){
        String response = blogsOwnerService.queryBlogsOwner(0);
        return response;
    }

    @ApiOperation(value = "查询账户信息")
    @CrossOrigin
    @RequestMapping(value = "/blogs/myInfo",method = RequestMethod.POST)
    public String getMyInfo(String username,String password){
        String response = blogsOwnerService.getMyInfo(username,password);
        return response;
    }
}
