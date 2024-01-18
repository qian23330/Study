package com.bigc.shortlink.admin.test;

public class UserTableShardingTest {

    public static final String SQL = "create table t_user_%d\n" +
            "(\n" +
            "    id            bigint auto_increment comment 'ID'\n" +
            "        primary key,\n" +
            "    username      varchar(256) null comment '用户名',\n" +
            "    password      varchar(512) null comment '密码',\n" +
            "    real_name     varchar(256) null comment '真实姓名',\n" +
            "    phone         varchar(128) null comment '手机号',\n" +
            "    mail          varchar(512) null comment '邮箱',\n" +
            "    deletion_time bigint       null comment '注销时间戳',\n" +
            "    create_time   datetime     null comment '创建时间',\n" +
            "    update_time   datetime     null comment '修改时间',\n" +
            "    del_flag      tinyint(1)   null comment '删除标识 0：未删除 1：已删除',\n" +
            "    constraint idx_unique_username\n" +
            "        unique (username)\n" +
            ")\n" +
            "    charset = utf8mb4;";

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}
