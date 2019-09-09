package com.monolog7.blogs.controller;

import com.monolog7.blogs.service.BlogsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "博客信息")
@RestController
public class BlogsController {
    @Autowired
    private BlogsService blogsService;

    @ApiOperation(value = "查询博客信息")
    @ApiImplicitParams({@ApiImplicitParam(name="ownerId",value = "博主ID",required = true,dataType = "Integer")})
    @ApiResponses({@ApiResponse(code = 200,message = "博客信息",response = String.class)})
    @RequestMapping(value = "/blogs/blogsInfo",method = RequestMethod.GET)
    public String getBlogsByOwner(@RequestParam(name = "ownerId") int ownerId){
        String response = blogsService.queryBlogsByOwner(ownerId);
        return response;
    }

}
