package com.monolog7.blogs.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.monolog7.blogs.dao.BlogsOwnerDao;
import com.monolog7.blogs.dao.RolePermissionDao;
import com.monolog7.blogs.entity.BlogsOwner;
import com.monolog7.blogs.entity.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogsOwnerService {
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private BlogsOwnerDao blogsOwnerDao;

    public String queryBlogsOwner(int id){
        BlogsOwner blogsOwner = blogsOwnerDao.queryBlogsOwnerById(id);
        RolePermission rolePermission = rolePermissionDao.getRole(blogsOwner.getRole());
//        JSONObject result = JSON.parseObject(JSON.toJSONString(blogsOwner));
        JSONObject result = new JSONObject();
        result.put("id",0);
        result.put("name","iceCream");
        result.put("info","每一个不曾起舞的日子，都是对生命的辜负");
        JSONArray jsonArray = new JSONArray();
        JSONObject menuObject = new JSONObject();
        menuObject.put("id","menu1");
        menuObject.put("menuName","H O M E");
        menuObject.put("menuLink","/homeMain");
        jsonArray.add(menuObject);
        result.put("menu",jsonArray);
        return result.toJSONString();
    }
}
