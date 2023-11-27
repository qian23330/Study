package com.bigc.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {

    // 根据ID删除数据
    @Delete("delete from emp where id = #{id}")
    public int delete(Integer id);
}
