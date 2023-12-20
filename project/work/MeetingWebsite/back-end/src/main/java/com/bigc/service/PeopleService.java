package com.bigc.service;

import com.bigc.pojo.People;

public interface PeopleService {
    /**
     * 查询注册人总数
     */
    int getRegisteredCount();

    /**
     * 查询投稿人总数
     */
    int getSubmittedCount();

    /**
     * 新增注册/投稿人信息
     */
    void add(People people);
}
