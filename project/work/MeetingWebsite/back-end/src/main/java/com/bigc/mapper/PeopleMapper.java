package com.bigc.mapper;

import com.bigc.pojo.People;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleMapper {

    int registeredCount();

    int submittedCount();

    @Insert("insert into register_info_test (id, name, email, telephone, title, content, create_time) values " +
            "(#{id}, #{name}, #{email}, #{telephone}, #{title}, #{content}, #{createTime})")
    void add(People people);
}
