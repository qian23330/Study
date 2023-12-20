package com.bigc.service.impl;

import com.bigc.mapper.PeopleMapper;
import com.bigc.pojo.People;
import com.bigc.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public int getRegisteredCount() {
        return peopleMapper.registeredCount();
    }

    @Override
    public int getSubmittedCount() {
        return peopleMapper.submittedCount();
    }

    @Override
    public void add(People people) {
        people.setCreateTime(LocalDateTime.now());
        people.setUpdateTime(LocalDateTime.now());
        peopleMapper.add(people);
    }
}
