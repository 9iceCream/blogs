package com.monolog7.blogs.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.monolog7.blogs.entity.Blog;
import com.monolog7.blogs.entity.ErrorInfo;
import com.monolog7.blogs.service.BlogsService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(description = "博客信息")
@RestController
public class BlogsController {
    @Autowired
    private BlogsService blogsService;

    private Logger logger = LoggerFactory.getLogger(BlogsController.class);

    @ApiOperation(value = "查询博客信息")
//    @ApiImplicitParams({@ApiImplicitParam(name="ownerId",value = "博主ID",dataType = "Integer")})
    @ApiResponses({@ApiResponse(code = 200,message = "博客信息",response = String.class)})
    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "/blogs/blogsInfo",method = RequestMethod.GET)
    public String getBlogsByOwner(HttpSession session){
//        String response = blogsService.queryBlogsByOwner(0);
        String usernmae = String.valueOf(session.getAttribute("username"));
        String response = blogsService.queryBlogsByName(usernmae);
        return response;
    }

    @ApiOperation(value = "查询博客内容")
    @ApiImplicitParams({@ApiImplicitParam(name="blogId",value = "博客",required = true,dataType = "Integer")})
    @ApiResponses({@ApiResponse(code = 200,message = "博客内容",response = String.class)})
    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "/blogs/blogContent",method = RequestMethod.GET)
    public String getBlogsContentById(@RequestParam(name = "blogId") int id){
        String response = blogsService.queryBlogsContentById(id);
        return response;
    }

    @ApiOperation(value = "添加博客")
    /*@ApiImplicitParams({@ApiImplicitParam(name="blogId",value = "博客",required = true,dataType = "Integer")})*/
    @ApiResponses({@ApiResponse(code = 200,message = "博客内容",response = String.class)})
    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "/blogs/blogContent",method = RequestMethod.POST)
    public String addBlog(@RequestBody Blog blog, HttpSession session){
        logger.info("addBlog#入参：{}", JSON.toJSONString(blog));
        String response = "";
        Object userIdObj = session.getAttribute("userId");
        JSONObject jsonObject = new JSONObject();
        if(userIdObj == null){
            jsonObject.put("code",ErrorInfo.CODE_1004.getCode());
            jsonObject.put("message",ErrorInfo.CODE_1004.getMessage());
            response = jsonObject.toJSONString();
        }else{
            blog.setOwnerId((int) userIdObj);
            response = blogsService.addBlog(blog);
        }
        return response;
    }
}
