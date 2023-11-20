package com.bigc.controller;

import com.bigc.pojo.Address;
import com.bigc.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试响应数据
 */
@RestController
public class ResponseController {
//    @RequestMapping("/hello")
//    public String hello() {
//        System.out.println("Hello Java!");
//        return "Hello Java!";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr() {
//        Address addr = new Address();
//        addr.setProvince("陕西");
//        addr.setCity("西安");
//        return addr;
//    }
//
//    @RequestMapping("/listAddrs")
//    public List<Address> listAddrs() {
//        List<Address> list = new ArrayList<>();
//
//        Address addr = new Address();
//        addr.setProvince("陕西");
//        addr.setCity("西安");
//
//        Address addr2 = new Address();
//        addr2.setProvince("广东");
//        addr2.setCity("深圳");
//
//        list.add(addr);
//        list.add(addr2);
//
//        return list;
//    }

    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("Hello Java!");
        return Result.success("Hello Java!");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address addr = new Address();
        addr.setProvince("陕西");
        addr.setCity("西安");
        return Result.success(addr);
    }

    @RequestMapping("/listAddrs")
    public Result listAddrs() {
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("陕西");
        addr.setCity("西安");

        Address addr2 = new Address();
        addr2.setProvince("广东");
        addr2.setCity("深圳");

        list.add(addr);
        list.add(addr2);

        return Result.success(list);
    }
}
