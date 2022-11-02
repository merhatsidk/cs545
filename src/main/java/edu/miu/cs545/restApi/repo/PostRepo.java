package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PostRepo {

    public List<Post> findAll();

    public Post findById(long id);

    public void save(Post post);

    public void deleteById(long id);
}
