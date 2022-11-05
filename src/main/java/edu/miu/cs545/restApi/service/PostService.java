package edu.miu.cs545.restApi.service;

import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.dto.PostRequestDto;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.dto.PostResponseDtoV2;

import java.util.List;

public interface PostService {

    public PostResponseDto findById(Long id);

    List<PostResponseDto> findAllV1();

    List<PostResponseDtoV2> findAllV2();

    public void save(PostRequestDto postRequestDto);

//    public void save(Comment comment);

    public  void deleteById(Long id);

    List<Comment> findCommentById(Long id);

    void saveCommentById(Long id, List<Comment> comment);

    List<Post> findCommentByTitle(String title);
}
