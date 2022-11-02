package edu.miu.cs545.restApi.controller;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.dto.PostRequestDto;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostResponseDto> getPosts(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostResponseDto getById(@PathVariable("id") long id){
        return postService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody PostRequestDto postRequestDto){
        postService.save(postRequestDto);
    }

    @DeleteMapping
    public void delete( long id){
        postService.deleteById(id);
    }


}
