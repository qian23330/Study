package com.bigc.mapper;

import com.bigc.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */

@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     */
//    @Select("select count(*) from emp")
//    Long count();

    /**
     * 分页查询获取列表数据
     * @param start
     * @param pageSize
     */
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     */
    // @Select("select * from emp")
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 根据 id 查询员工
     * @param id
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 根据用户名和密码查询员工
     * @param emp
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
