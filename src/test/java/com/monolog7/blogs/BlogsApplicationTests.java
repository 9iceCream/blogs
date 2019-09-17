package com.monolog7.blogs;

import com.monolog7.blogs.dao.BlogsDao;
import com.monolog7.blogs.entity.Blog;
import com.monolog7.blogs.service.BlogsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogsApplicationTests {

    @Autowired
    BlogsService blogsService;

    @Test
    public void contextLoads() {
        Blog blog = new Blog();
        blog.setBlogId((System.currentTimeMillis() / 1000));
        blog.setOwnerId(1);
        blog.setTitle("123");
        String result = blogsService.addBlog(blog);
        System.out.println(result);
    }

}
