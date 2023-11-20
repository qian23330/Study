package com.bigc.dao.impl;

import com.bigc.dao.EmpDao;
import com.bigc.pojo.Emp;
import com.bigc.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // IOC-控制反转
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 1、 加载并解析emp.xml文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
