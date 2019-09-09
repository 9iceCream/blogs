package com.monolog7.blogs.service;

import com.alibaba.fastjson.JSON;
import com.monolog7.blogs.dao.BlogsDao;
import com.monolog7.blogs.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService {
    @Autowired
    private BlogsDao blogsDao;

    public String queryBlogsByOwner(int ownerId){
        List<Blog> blogs = blogsDao.queryBlogsByOwner(ownerId);
        return JSON.toJSONString(blogs);
    }

}
