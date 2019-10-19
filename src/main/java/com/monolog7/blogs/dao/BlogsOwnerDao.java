package com.monolog7.blogs.dao;

import com.monolog7.blogs.entity.BlogsOwner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogsOwnerDao {
    BlogsOwner queryBlogsOwnerById(int id);
    int addUser(BlogsOwner blogsOwner);
    BlogsOwner queryUserByName(String name);
}
