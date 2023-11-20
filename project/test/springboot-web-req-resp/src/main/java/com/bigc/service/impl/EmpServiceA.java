package com.bigc.service.impl;

import com.bigc.dao.EmpDao;
import com.bigc.dao.impl.EmpDaoA;
import com.bigc.pojo.Emp;
import com.bigc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // IOC-控制反转
public class EmpServiceA implements EmpService {
    @Autowired // DI-依赖注入
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        // 1、调用dao，获取数据
        List<Emp> empList = empDao.listEmp();
        // 2、对数据进行转换处理-gender,job
        empList.stream().forEach(emp -> {
            // 处理gender
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }

            // 处理job
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            }else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
