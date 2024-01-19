package com.bigc.shortlink.project.dto.req;

import lombok.Data;

import java.util.Date;

/**
 * 短链接创建请求对象
 */
@Data
public class ShortLinkCreateReqDTO {

    /**
     * 域名
     */
    private String domain;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 创建类型 0: 接口创建 1: 控制台创建
     */
    private Integer createType;

    /**
     * 有效期类型 0: 永久有效 1: 自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    private Date validTime;

    /**
     * 描述
     */
    private String describe;
}
