package edu.miu.cs545.restApi.service;

import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }


}
