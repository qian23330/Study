package com.bigc.pojo;

import java.util.Date;


public class LoginTicket {
    private int id;
    private int userId;
    private String ticket;
    private int status;
    private Date expired;

    public LoginTicket() {
    }

    public LoginTicket(int id, int userId, String ticket, int status, Date expired) {
        this.id = id;
        this.userId = userId;
        this.ticket = ticket;
        this.status = status;
        this.expired = expired;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return ticket
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * 设置
     * @param ticket
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * 获取
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 获取
     * @return expired
     */
    public Date getExpired() {
        return expired;
    }

    /**
     * 设置
     * @param expired
     */
    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public String toString() {
        return "LoginTicket{id = " + id + ", userId = " + userId + ", ticket = " + ticket + ", status = " + status + ", expired = " + expired + "}";
    }
}
