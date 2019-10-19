package com.monolog7.blogs.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.monolog7.blogs.dao.BlogsOwnerDao;
import com.monolog7.blogs.entity.BlogsOwner;
import com.monolog7.blogs.entity.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String USER_INFO = "每个不曾起舞的日子，都是对生命的辜负";

    @Autowired
    private BlogsOwnerDao blogsOwnerDao;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public String addUser(BlogsOwner blogsOwner){
        if(isNull(blogsOwner.getCreate_time()) || blogsOwner.getCreate_time() == 0){
            blogsOwner.setCreate_time(System.currentTimeMillis()/1000);
        }
        if(isNull(blogsOwner.getUpdate_time()) || blogsOwner.getUpdate_time() == 0){
            blogsOwner.setUpdate_time(System.currentTimeMillis()/1000);
        }

        if(isNull(blogsOwner.getInfo()) || "".equals(blogsOwner.getInfo().trim())){
            blogsOwner.setInfo(USER_INFO);
        }

        if(isNull(blogsOwner.getRole()) ||blogsOwner.getRole() == 0){
            blogsOwner.setRole(1);
        }

        String result = "";
        try {
            int addResult = blogsOwnerDao.addUser(blogsOwner);

            if(addResult == 1){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",ErrorInfo.CODE_0.getCode());
                jsonObject.put("message",ErrorInfo.CODE_0.getMessage());
                result = jsonObject.toJSONString();
            }else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",ErrorInfo.CODE_1000.getCode());
                jsonObject.put("message",ErrorInfo.CODE_1000.getMessage());
                result = jsonObject.toJSONString();
            }
        }catch (DuplicateKeyException e){
            logger.error("addUser#入参：{},DuplicateKeyException：{}",JSON.toJSONString(blogsOwner),e.getMessage(),e);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",ErrorInfo.CODE_1001.getCode());
            jsonObject.put("message",ErrorInfo.CODE_1001.getMessage());
            result = jsonObject.toJSONString();
        }


        return result;
    }

    public String checkUserLogin(BlogsOwner blogsOwner){
        BlogsOwner srcBlogsOwner= blogsOwnerDao.queryUserByName(blogsOwner.getName());
        String result = "";
        if(isNull(srcBlogsOwner)){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",ErrorInfo.CODE_1002.getCode());
            jsonObject.put("message",ErrorInfo.CODE_1002.getMessage());
            result = jsonObject.toJSONString();
        }else if(!srcBlogsOwner.getPasswd().equals(blogsOwner.getPasswd())){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",ErrorInfo.CODE_1003.getCode());
            jsonObject.put("message",ErrorInfo.CODE_1003.getMessage());
            result = jsonObject.toJSONString();
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",ErrorInfo.CODE_0.getCode());
            jsonObject.put("message",ErrorInfo.CODE_0.getMessage());
            result = jsonObject.toJSONString();
        }
        return result;
    }

    private boolean isNull(Object obj){
        if(obj==null){
            return true;
        }
        return false;
    }

}
