package com.bigc.mapper;

import com.bigc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    // 查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
