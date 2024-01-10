package com.bigc.service;

import com.bigc.pojo.Comment;
import java.util.List;

public interface CommentService {

    List<Comment> findCommentsByEntityId(int entityType, int entityId, int offset, int limit);

    int findCommentCount(int entityType, int entityId);

    void addComment(Comment comment);

    Comment findCommentById(int id);

    List<Comment> findCommentsByUser(int userId, int offset, int limit);

    int findCommentCountByUser(int userId);
}
