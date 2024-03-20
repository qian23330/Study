package com.bigc.mapper;

import com.bigc.pojo.People;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleMapper {

    @Insert("insert into register_info (id, name, email, telephone, institution, title, topic, create_time) values " +
            "(#{id}, #{name}, #{email}, #{telephone}, #{institution} , #{title}, #{topic}, #{createTime})")
    void add(People people);
}
