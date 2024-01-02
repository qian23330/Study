package com.bigc.mapper;

import com.bigc.pojo.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginTicketMapper {

    @Insert(
        "insert into login_ticket(user_id, ticket, status, expired) " +
        "values(#{userId}, #{ticket}, #{status}, #{expired})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertLoginTicket(LoginTicket loginTicket);

    @Select("select id, user_id, ticket, status, expired " +
            "from login_ticket where ticket=#{ticket}")
    LoginTicket selectByTicket(String ticket);

    @Update("update login_ticket set status=#{status} where ticket=#{ticket}")
    void updateStatus(String ticket, int status);

}
