package com.monolog7.blogs.controller;

import com.monolog7.blogs.service.BlogsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "博客信息")
@RestController
public class BlogsController {
    @Autowired
    private BlogsService blogsService;

    @ApiOperation(value = "查询博客信息")
//    @ApiImplicitParams({@ApiImplicitParam(name="ownerId",value = "博主ID",dataType = "Integer")})
    @ApiResponses({@ApiResponse(code = 200,message = "博客信息",response = String.class)})
    @CrossOrigin
    @RequestMapping(value = "/blogs/blogsInfo",method = RequestMethod.GET)
    public String getBlogsByOwner(){
        String response = blogsService.queryBlogsByOwner(0);
        return response;
    }

    @ApiOperation(value = "查询博客内容")
    @ApiImplicitParams({@ApiImplicitParam(name="blogId",value = "博客",required = true,dataType = "Integer")})
    @ApiResponses({@ApiResponse(code = 200,message = "博客内容",response = String.class)})
    @CrossOrigin
    @RequestMapping(value = "/blogs/blogContent",method = RequestMethod.GET)
    public String getBlogsContentById(@RequestParam(name = "blogId") int id){
        String response = blogsService.queryBlogsContentById(id);
        return response;
    }
}
