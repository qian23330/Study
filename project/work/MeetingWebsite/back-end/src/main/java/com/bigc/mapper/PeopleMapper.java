package com.bigc.mapper;

import com.bigc.pojo.People;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PeopleMapper {

    @Select("SELECT * FROM register_info WHERE email = #{email}")
    People findByEmail(String id);

    @Insert("INSERT INTO register_info (id, name, email, telephone, institution, title, topic, " +
            "book_hotel, room_type, checkin_date, checkout_date, create_time, update_time) " +
            "VALUES (#{id}, #{name}, #{email}, #{telephone}, #{institution} , #{title}, #{topic}, #{bookHotel}, " +
            "#{roomType}, #{checkInDate}, #{checkOutDate}, #{createTime}, #{updateTime})")
    void insert(People people);

    @Update("UPDATE register_info SET name = #{name}, telephone = #{telephone}, institution = #{institution}, " +
            "title = #{title}, topic = #{topic}, book_hotel = #{bookHotel}, room_type = #{roomType}, checkin_date = #{checkInDate}," +
            "checkout_date = #{checkOutDate}, update_time = #{updateTime} WHERE id = #{id}")
    void update(People people);
}
