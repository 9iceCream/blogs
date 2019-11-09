package com.monolog7.blogs.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.monolog7.blogs.dao.BlogsOwnerDao;
import com.monolog7.blogs.dao.RolePermissionDao;
import com.monolog7.blogs.entity.BlogsOwner;
import com.monolog7.blogs.entity.DictionaryConst;
import com.monolog7.blogs.entity.ErrorInfo;
import com.monolog7.blogs.entity.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class BlogsOwnerService {
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private BlogsOwnerDao blogsOwnerDao;

    public String queryBlogsOwner(int id){
        BlogsOwner blogsOwner = blogsOwnerDao.queryBlogsOwnerById(id);
        RolePermission rolePermission = rolePermissionDao.getRole(blogsOwner.getRole());
        JSONObject result = JSON.parseObject(JSON.toJSONString(blogsOwner));
        /*JSONObject result = new JSONObject();
        result.put("id",0);
        result.put("name","iceCream");
        result.put("info","每一个不曾起舞的日子，都是对生命的辜负");*/
        /*JSONArray jsonArray = new JSONArray();
        JSONObject menuObject = new JSONObject();
        menuObject.put("id","menu1");
        menuObject.put("menuName","H O M E");
        menuObject.put("menuLink","/homeMain");
        jsonArray.add(menuObject);*/
        result.put("menu",JSONArray.parseArray(rolePermission.getMenu()));
        return result.toJSONString();
    }

    public String getMyInfo(HttpSession session, DictionaryConst user_oper){
        String result = "";

        String username = String.valueOf(session.getAttribute("username"));

        JSONObject jsonObject = new JSONObject();
        if("null".equals(username)){//未登录状态
            jsonObject.put("code",ErrorInfo.CODE_1004.getCode());
            jsonObject.put("message",ErrorInfo.CODE_1004.getMessage());
        } else{
            jsonObject.put("code",ErrorInfo.CODE_0.getCode());
            jsonObject.put("message",ErrorInfo.CODE_0.getMessage());
            if(DictionaryConst.USER_OPER_1.getCode() == user_oper.getCode()){
                BlogsOwner blogsOwner = blogsOwnerDao.queryUserByName(username);
                RolePermission rolePermission = rolePermissionDao.getRole(blogsOwner.getRole());
                JSONObject owner = JSON.parseObject(JSON.toJSONString(blogsOwner));
                owner.put("menu", JSONArray.parseArray(rolePermission.getMenu()));
                jsonObject.put("data",owner);
            }
        }
        result = jsonObject.toJSONString();
        return result;
    }

}
