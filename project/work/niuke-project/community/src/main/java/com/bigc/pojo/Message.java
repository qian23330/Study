package com.bigc.pojo;


import java.util.Date;


public class Message {
    private int id;
    private int fromId;
    private int toId;
    private String conversationId;
    private String content;
    private int status;
    private Date createTime;

    public Message() {
    }

    public Message(int id, int fromId, int toId, String conversationId, String content, int status, Date createTime) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.conversationId = conversationId;
        this.content = content;
        this.status = status;
        this.createTime = createTime;
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
     * @return fromId
     */
    public int getFromId() {
        return fromId;
    }

    /**
     * 设置
     * @param fromId
     */
    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    /**
     * 获取
     * @return toId
     */
    public int getToId() {
        return toId;
    }

    /**
     * 设置
     * @param toId
     */
    public void setToId(int toId) {
        this.toId = toId;
    }

    /**
     * 获取
     * @return conversationId
     */
    public String getConversationId() {
        return conversationId;
    }

    /**
     * 设置
     * @param conversationId
     */
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
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
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String toString() {
        return "Message{id = " + id + ", fromId = " + fromId + ", toId = " + toId + ", conversationId = " + conversationId + ", content = " + content + ", status = " + status + ", createTime = " + createTime + "}";
    }
}
