package com.bigc.service;

import com.bigc.pojo.Comment;
import java.util.List;

public interface CommentService {

    List<Comment> findCommentsByEntityId(int entityType, int entityId, int offset, int limit);

    int findCommentCount(int entityType, int entityId);

    int addComment(Comment comment);
}
