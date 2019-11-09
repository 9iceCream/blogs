package com.monolog7.blogs.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.monolog7.blogs.dao.BlogsDao;
import com.monolog7.blogs.dao.BlogsOwnerDao;
import com.monolog7.blogs.entity.Blog;
import com.monolog7.blogs.entity.BlogsOwner;
import com.monolog7.blogs.entity.ErrorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogsService {
    @Autowired
    private BlogsDao blogsDao;
    @Autowired
    private BlogsOwnerDao blogsOwnerDao;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String queryBlogsByOwner(int ownerId){
        List<Blog> result = new ArrayList<>();
        List<Blog> blogs = blogsDao.queryBlogsByOwner(ownerId);
        for(Blog blog : blogs){
            result.add(execTimeAndTag(blog));
        }
        return JSON.toJSONString(result);
    }

    public String queryBlogsByName(String username){
        String result = "";

        JSONObject jsonObject = new JSONObject();
        if("null".equals(username)){
            jsonObject.put("code",ErrorInfo.CODE_1004.getCode());
            jsonObject.put("message",ErrorInfo.CODE_1004.getMessage());
        }else{

            BlogsOwner blogsOwner = blogsOwnerDao.queryUserByName(username);
            int ownerId = blogsOwner.getId();
            List<Blog> blogs = blogsDao.queryBlogsByOwner(ownerId);
            if(blogs != null && !blogs.isEmpty()){
                List<Blog> blogList = new ArrayList<>();
                for(Blog blog : blogs){
                    blogList.add(execTimeAndTag(blog));
                }
                jsonObject.put("code",ErrorInfo.CODE_0.getCode());
                jsonObject.put("message",ErrorInfo.CODE_0.getMessage());
                jsonObject.put("data",blogList);
            }else{
                jsonObject.put("code",ErrorInfo.CODE_1005.getCode());
                jsonObject.put("message",ErrorInfo.CODE_1005.getMessage());
            }
        }

        result = jsonObject.toJSONString();

        return result;
    }

    public String queryBlogsContentById(int id){
        Blog blog = execTimeAndTag(blogsDao.queryBlogsById(id));
        return JSON.toJSONString(blog);
    }

    public String addBlog(Blog blog){
        blog.setCreateTime(System.currentTimeMillis()/1000);
        blog.setUpdateTime(System.currentTimeMillis()/1000);
        if(blog.getCoverImg() == null || "".equals(blog.getCoverImg())){
            //http://116.62.213.246/blogs/imgs/cover-img-default.jpg
            blog.setCoverImg("http://www.monolog7.com/blogs/imgs/cover-img-default.jpg");
        }
        int result = blogsDao.insertOrUpdateBlog(blog);
        JSONObject jsonObject = new JSONObject();
        if(result>0){
//            Blog blogResp = execTimeAndTag(blogsDao.queryBlogsByBlogId(blog.getOwnerId(),blog.getBlogId()));
            jsonObject.put("code",ErrorInfo.CODE_0.getCode());
            jsonObject.put("message",ErrorInfo.CODE_0.getMessage());
        }else {
            jsonObject.put("code",ErrorInfo.CODE_1006.getCode());
            jsonObject.put("message",ErrorInfo.CODE_1006.getMessage());
        }
        return jsonObject.toJSONString();
    }

    private Blog execTimeAndTag(Blog blog){
        long createTime = blog.getCreateTime();
        String timeStr = simpleDateFormat.format(new Date(createTime*1000));
        if(timeStr!=null){
            blog.setTimeStr(timeStr);
        }
        String tags = blog.getTags();
        if(tags!=null && !"".equals(tags)){
            if(tags.contains(",")){
                String[] tagArr = tags.split(",");
                blog.setTagArr(tagArr);
            }else if(tags.contains("，")){
                String[] tagArr = tags.split("，");
                blog.setTagArr(tagArr);
            }else if(tags.contains(";")){
                String[] tagArr = tags.split(";");
                blog.setTagArr(tagArr);
            }else if(tags.contains("；")){
                String[] tagArr = tags.split("；");
                blog.setTagArr(tagArr);
            }
        }
        return blog;
    }
}
