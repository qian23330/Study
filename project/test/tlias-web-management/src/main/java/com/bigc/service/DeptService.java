package com.bigc.service;

import com.bigc.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门数据
     * @return 存储Dept对象的集合
     */
    List<Dept> list();

    /**
     * 删除部门
     */
    void delete(Integer id);

    /**
     * 新增部门
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     */
    Dept select(Integer id);

    /**
     * 修改部门
     */
    void update(Dept dept);
}
