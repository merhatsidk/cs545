package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
