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
    private String title;
    private String content;
    private String file;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
