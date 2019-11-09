package com.monolog7.blogs.dao;

import com.monolog7.blogs.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogsDao {
    List<Blog> queryBlogsByOwner(@Param("owner_id") int ownerId);
    Blog queryBlogsById(int id);
    Blog queryBlogsByBlogId(@Param("ownerId") int ownerId,@Param("blogId") long blogId);
    int insertOrUpdateBlog(Blog blog);
}
