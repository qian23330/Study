package com.bigc.controller;

import com.bigc.anno.Log;
import com.bigc.pojo.Dept;
import com.bigc.pojo.Result;
import com.bigc.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    // private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts", method = RequestMethod.GET)

    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");

        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门：{}", id);

        // 调用service删除部门数据
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);

        // 调用service新增部门数据
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id) {
        log.info("根据id查询部门：{}", id);

        // 调用service根据id查询部门数据
        Dept dept = deptService.select(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门：{}", dept);

        // 调用service修改部门数据
        deptService.update(dept);
        return Result.success();
    }
}
