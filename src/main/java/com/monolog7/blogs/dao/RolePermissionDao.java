package com.monolog7.blogs.dao;

import com.monolog7.blogs.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionDao {
    RolePermission getRole(int role);
}
