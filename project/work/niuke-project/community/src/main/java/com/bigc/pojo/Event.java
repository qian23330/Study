package com.bigc.pojo;

import java.util.HashMap;
import java.util.Map;

public class Event {
    private String topic;
    private int userId;
    private int entityType;
    private int entityId;
    private int entityUserId;
    private Map<String, Object> data = new HashMap<>();

    public Event() {
    }

    public Event(String topic, int userId, int entityType, int entityId, int entityUserId, Map<String, Object> data) {
        this.topic = topic;
        this.userId = userId;
        this.entityType = entityType;
        this.entityId = entityId;
        this.entityUserId = entityUserId;
        this.data = data;
    }

    /**
     * 获取
     * @return topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 设置
     * @param topic
     */
    public Event setTopic(String topic) {
        this.topic = topic;
        return this;
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
    public Event setUserId(int userId) {
        this.userId = userId;
        return this;
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
    public Event setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
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
    public Event setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    /**
     * 获取
     * @return entityUserId
     */
    public int getEntityUserId() {
        return entityUserId;
    }

    /**
     * 设置
     * @param entityUserId
     */
    public Event setEntityUserId(int entityUserId) {
        this.entityUserId = entityUserId;
        return this;
    }

    /**
     * 获取
     * @return data
     */
    public Map<String, Object> getData() {
        return data;
    }

    /**
     * 设置
     * @param key, value
     */
    public Event setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public String toString() {
        return "Event{topic = " + topic + ", userId = " + userId + ", entityType = " + entityType + ", entityId = " + entityId + ", entityUserId = " + entityUserId + ", data = " + data + "}";
    }
}
