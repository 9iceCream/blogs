package com.monolog7.blogs.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.Param;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class BlogsOwner {
    private int id;
    private String name;
    private String passwd;
    private String info;
    private int role;
    private long create_time;
    private long update_time;
}
