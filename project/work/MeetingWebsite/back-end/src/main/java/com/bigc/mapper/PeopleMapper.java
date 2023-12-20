package com.bigc.mapper;

import com.bigc.pojo.People;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleMapper {

    int registeredCount();

    int submittedCount();

    @Insert("insert into meeting_info.people_info (id, name, email, telephone, title, content, file, create_time, update_time) values " +
            "(#{id}, #{name}, #{email}, #{telephone}, #{title}, #{content}, #{file}, #{createTime}, #{updateTime})")
    void add(People people);
}
