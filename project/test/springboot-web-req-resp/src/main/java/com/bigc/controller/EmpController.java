package com.bigc.controller;

import com.bigc.pojo.Emp;
import com.bigc.pojo.Result;
import com.bigc.service.EmpService;
import com.bigc.service.impl.EmpServiceA;
import com.bigc.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired // DI-依赖注入
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {
        List<Emp> empList = empService.listEmp();
        return Result.success(empList);
    }
}
