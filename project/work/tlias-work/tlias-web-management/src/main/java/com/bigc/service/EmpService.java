package com.bigc.service;

import com.bigc.pojo.Emp;
import com.bigc.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    /**
     * 分页查询
     * @param page
     * @param pageSizeString
     * @param name
     * @param gender
     * @param begin
     * @param end
     */
    PageBean page(Integer page, Integer pageSizeString, String name, Short gender,
                  LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据 id 查询员工
     * @param id
     */
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp
     */
    Emp login(Emp emp);
}
