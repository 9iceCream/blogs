package com.monolog7.blogs;

import com.monolog7.blogs.dao.BlogsDao;
import com.monolog7.blogs.entity.Blog;
import com.monolog7.blogs.entity.BlogsOwner;
import com.monolog7.blogs.service.BlogsService;
import com.monolog7.blogs.service.UserService;
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
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        Blog blog = new Blog();
        blog.setBlogId((System.currentTimeMillis() / 1000));
        blog.setOwnerId(1);
        blog.setTitle("123");
        String result = blogsService.addBlog(blog);
        System.out.println(result);
    }
    @Test
    public void testUserRegister(){
        BlogsOwner blogsOwner = new BlogsOwner();
        blogsOwner.setName("诗酒趁年华");
        blogsOwner.setPasswd("cccccc");

        String result = userService.addUser(blogsOwner);
        System.out.println(result);
    }

    @Test
    public void testLogin(){
        String name = "诗酒趁年华1";
        String passwd = "cccccc";

        BlogsOwner blogsOwner = new BlogsOwner();
        blogsOwner.setName(name);
        blogsOwner.setPasswd(passwd);
        String result = userService.checkUserLogin(blogsOwner);
        System.out.println(result);
    }


}
