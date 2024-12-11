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
        try {
            log.info("新增信息：{}", people);
            peopleService.addOrUpdate(people);
            return Result.success();
        } catch (Exception ex) {
            System.out.println(ex);
            return Result.error("System failed, please try again later.");
        }

    }
}
