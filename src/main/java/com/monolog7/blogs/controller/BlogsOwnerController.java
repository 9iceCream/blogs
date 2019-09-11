package com.monolog7.blogs.controller;

import com.monolog7.blogs.dao.BlogsOwnerDao;
import com.monolog7.blogs.dao.RolePermissionDao;
import com.monolog7.blogs.service.BlogsOwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
