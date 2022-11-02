package edu.miu.cs545.restApi.repo.impl;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts;
    private static Long postId = 100L;

    static {
        posts = new ArrayList<>();
        Post post1 = new Post(1,"harry Poter","fictional","john");
        Post post2 = new Post(2,"Lord of the ring","movie","math");
        Post post3 = new Post(3,"Hibernate","educational","david");
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(postId++);
        posts.add(post);
    }

    @Override
    public void deleteById(long id) {
        var post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
        posts.remove(post);

    }
}
