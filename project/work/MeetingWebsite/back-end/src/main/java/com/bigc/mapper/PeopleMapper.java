package com.bigc.mapper;

import com.bigc.pojo.People;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleMapper {

    @Insert("INSERT INTO register_info (id, name, email, telephone, institution, title, topic, create_time) " +
            "VALUES (#{id}, #{name}, #{email}, #{telephone}, #{institution} , #{title}, #{topic}, #{createTime}) " +
            "ON DUPLICATE KEY UPDATE name = #{name}, telephone = #{telephone}, institution = #{institution}, title = #{title}, topic = #{topic}, create_time = #{createTime}")
    void addOrUpdate(People people);
}
