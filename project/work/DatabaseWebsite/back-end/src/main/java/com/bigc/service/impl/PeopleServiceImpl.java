package com.bigc.service.impl;

import com.bigc.mapper.PeopleMapper;
import com.bigc.pojo.People;
import com.bigc.service.PeopleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleMapper peopleMapper;

    @Override
    public void addOrUpdate(People people) {
        People existingPeople = peopleMapper.findByEmail(people.getEmail());
        if (existingPeople != null) {
            people.setId(existingPeople.getId()); // 使用已存在记录的ID
            people.setUpdateTime(LocalDateTime.now()); // 更新修改时间
            // 不需要设置创建时间，它保持在数据库中的原样
            peopleMapper.update(people);
        } else {
            people.setCreateTime(LocalDateTime.now()); // 设置创建时间
            people.setUpdateTime(LocalDateTime.now()); // 设置修改时间
            peopleMapper.insert(people);
        }
    }
}
