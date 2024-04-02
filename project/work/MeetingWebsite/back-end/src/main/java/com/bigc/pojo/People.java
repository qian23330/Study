package com.bigc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {
    private Integer id;
    private String name;
    private String email;
    private String telephone;
    private String institution;
    private String title;
    private short topic;
    private String bookHotel;
    private short roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
