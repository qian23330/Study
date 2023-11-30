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
}
