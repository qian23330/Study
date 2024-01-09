package com.bigc.pojo;

import java.util.Date;


public class Comment {
    private int id;
    private int userId;
    private int entityType;
    private int entityId;
    private int targetId;
    private String content;
    private int status;
    private Date createTime;

    public Comment() {
    }

    public Comment(int id, int userId, int entityType, int entityId, int targetId, String content, int status, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.entityType = entityType;
        this.entityId = entityId;
        this.targetId = targetId;
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
     * @return entityType
     */
    public int getEntityType() {
        return entityType;
    }

    /**
     * 设置
     * @param entityType
     */
    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    /**
     * 获取
     * @return entityId
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * 设置
     * @param entityId
     */
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    /**
     * 获取
     * @return targetId
     */
    public int getTargetId() {
        return targetId;
    }

    /**
     * 设置
     * @param targetId
     */
    public void setTargetId(int targetId) {
        this.targetId = targetId;
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
        return "Comment{id = " + id + ", userId = " + userId + ", entityType = " + entityType + ", entityId = " + entityId + ", targetId = " + targetId + ", content = " + content + ", status = " + status + ", createTime = " + createTime + "}";
    }
}
