package com.monolog7.blogs.dao;

import com.monolog7.blogs.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogsDao {
    List<Blog> queryBlogsByOwner(@Param("owner_id") int ownerId);
    Blog queryBlogsById(int id);
    Blog queryBlogsByBlogId(int ownerId,long blogId);
    int insertOrUpdateBlog(Blog blog);
}
