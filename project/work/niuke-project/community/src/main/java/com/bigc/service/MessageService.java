package com.bigc.service;

import com.bigc.pojo.Message;

import java.util.List;

public interface MessageService {

    List<Message> findConversations(int userId, int offset, int limit);

    int findConversationCount(int userId);

    List<Message> findLetters(String conversationId, int offset, int limit);

    int findLetterCount(String conversationId);

    int findLetterUnreadCount(int userId, String conversationId);

    void addMessage(Message message);

    void readMessage(List<Integer> ids);

    void deleteMessage(int id);

    Message findLatestNotice(int userId, String topic);

    int findNoticeCount(int userId, String topic);

    int findNoticeUnreadCount(int userId, String topic);
}
