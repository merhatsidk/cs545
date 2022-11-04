package edu.miu.cs545.restApi.service;

import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.dto.PostRequestDto;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;

    @Override
    public List<PostResponseDto> findAll() {
        var posts = postRepo.findAll();
              return posts.stream()
                .map(post -> modelMapper.map(post,PostResponseDto.class))
                .collect(Collectors.toList());

    }



    @Override
    public PostResponseDto findById(Long id) {
        return modelMapper.map(postRepo.findById(id).isPresent() ? postRepo.findById(id).get():new PostResponseDto(),PostResponseDto.class);
    }

    @Override
    public void save(PostRequestDto postRequestDto) {
        Post post = modelMapper.map(postRequestDto,Post.class);
        postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public List<Comment> findCommentById(Long id) {
        var post  = postRepo.findById(id).get();
        return new ArrayList<>(post.getComments());
    }

    @Override
    public void saveCommentById(Long id, List<Comment> comment) {
        Post p = postRepo.findById(id).get();
        List<Comment> comments = p.getComments();
        comments.addAll(comment);
        postRepo.save(p);

    }

    @Override
    public List<Post> findCommentByTitle(String title) {
        return postRepo.findPostByTitleMatches(title);
    }
}
