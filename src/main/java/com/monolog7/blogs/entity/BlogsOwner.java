package com.monolog7.blogs.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class BlogsOwner {
    private int id;
    private String name;
    private String info;
    private int role;
    private long createTime;
    private long updateTime;
}
