package com.monolog7.blogs.dao;

import com.monolog7.blogs.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogsDao {

    /**
     * 查询博主博客
     * @param ownerId
     * @param delete_flag
     * @return
     */
    List<Blog> queryBlogsByOwner(@Param("owner_id") int ownerId, @Param("delete_flag") int delete_flag);
    Blog queryBlogsById(int id);
    Blog queryBlogsByBlogId(@Param("ownerId") int ownerId,@Param("blogId") long blogId);

    /**
     * 插入重复更新博客
     * @param blog
     * @return
     */
    int insertOrUpdateBlog(Blog blog);

    /**
     * copy blog into dustbin
     * @param owner_id
     * @param blog_id
     * @return
     */
    int insertIntoBlogDustbin(@Param("owner_id") int owner_id, @Param("blog_id") long blog_id);

    /**
     * 删除博客
     * @param owner_id
     * @param blog_id
     * @return
     */
    int updateBlogToDelete(@Param("owner_id") int owner_id, @Param("blog_id") long blog_id);

    /**
     * 恢复博客
     * @param owner_id
     * @param blog_id
     * @return
     */
    int updateBlogToNormal(@Param("owner_id") int owner_id, @Param("blog_id") long blog_id);
}
