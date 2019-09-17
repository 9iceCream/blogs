package com.monolog7.blogs.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.monolog7.blogs.dao.BlogsDao;
import com.monolog7.blogs.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogsService {
    @Autowired
    private BlogsDao blogsDao;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String queryBlogsByOwner(int ownerId){
        List<Blog> result = new ArrayList<>();
        List<Blog> blogs = blogsDao.queryBlogsByOwner(ownerId);
        for(Blog blog : blogs){
            result.add(execTimeAndTag(blog));
        }
        return JSON.toJSONString(result);
    }

    public String queryBlogsContentById(int id){
        Blog blog = execTimeAndTag(blogsDao.queryBlogsById(id));
        return JSON.toJSONString(blog);
    }

    public String addBlog(Blog blog){
        int result = blogsDao.insertOrUpdateBlog(blog);
        if(result>0){
            Blog blogResp = execTimeAndTag(blogsDao.queryBlogsByBlogId(blog.getOwnerId(),blog.getBlogId()));
            return JSON.toJSONString(blogResp);
        }else {
            JSONObject resp = new JSONObject();
            resp.put("error","添加或者更新失败");
            return resp.toJSONString();
        }
    }

    private Blog execTimeAndTag(Blog blog){
        long createTime = blog.getCreateTime();
        String timeStr = simpleDateFormat.format(new Date(createTime*1000));
        if(timeStr!=null){
            blog.setTimeStr(timeStr);
        }
        String tags = blog.getTags();
        if(tags!=null && !"".equals(tags)){
            String[] tagArr = tags.split(",");
            blog.setTagArr(tagArr);
        }
        return blog;
    }
}
