package com.monolog7.blogs.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RolePermission {
    private int id;
    private int role;
    private String role_name;
    private String permission;
    private String menu;
}
