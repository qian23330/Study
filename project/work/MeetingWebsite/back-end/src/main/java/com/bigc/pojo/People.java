package com.bigc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDateTime createTime;
}
