package com.bigc.mapper;

import com.bigc.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return 返回所有部门数据
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 删除部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门信息
     */
    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门信息
     *
     */
    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);

    /**
     * 修改部门信息
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
