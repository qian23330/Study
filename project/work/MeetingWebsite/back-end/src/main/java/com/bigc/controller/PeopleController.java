package com.bigc.controller;

import com.bigc.pojo.People;
import com.bigc.pojo.Result;
import com.bigc.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/send")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping
    public Result add(@RequestBody People people) {
        log.info("新增信息：{}", people);
        peopleService.add(people);
        return Result.success();
    }
}
