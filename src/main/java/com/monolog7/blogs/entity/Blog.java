package com.monolog7.blogs.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Blog {
    private int id;
    private long blogId;
    private int ownerId;
    private String title;
    private String info;
    private String coverImg;
    private String tags;
    private long createTime;
    private long updateTime;
    private String contents;
    private String contentsMd;
    private String images;
    private String timeStr;
    private String[] tagArr;
}
