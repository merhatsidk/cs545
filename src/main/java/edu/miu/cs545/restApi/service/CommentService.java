package edu.miu.cs545.restApi.service;

import edu.miu.cs545.restApi.domain.Comment;

import java.util.List;

public interface CommentService {

    void save(Comment comment);

    List<Comment> findAll();
}
