package com.bigc.service;

import com.bigc.pojo.DiscussPost;

import java.util.List;

public interface DiscussPostService {

    List<DiscussPost> findDiscussPosts(int userId, int offset, int limit);

    int findDiscussPostRows(int userId);

    void addDiscussPost(DiscussPost post);

    DiscussPost findDiscussPostById(int id);
}
