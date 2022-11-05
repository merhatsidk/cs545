package edu.miu.cs545.restApi.controller;

import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.dto.PostRequestDto;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.dto.PostResponseDtoV2;
import edu.miu.cs545.restApi.repo.CommentRepo;
import edu.miu.cs545.restApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(headers = "v=1")
    public List<PostResponseDto> findAllV1(){
        return postService.findAllV1();
    }

    @GetMapping(headers = "v=2")
    public List<PostResponseDtoV2> findAllV2(){
        return postService.findAllV2();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDto getById(@PathVariable("id") Long id){
        return postService.findById(id);
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PostRequestDto postRequestDto){
        postService.save(postRequestDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( Long id){
        postService.deleteById(id);
    }


    @GetMapping("{id}/comments")
    public List<Comment> findCommentById(@PathVariable("id") Long id){
        return postService.findCommentById(id);
    }



    @PostMapping("{id}/addComment")
    public void saveCommentById(@PathVariable Long id, @RequestBody List<Comment> comment){
         postService.saveCommentById(id,comment);
    }

    @GetMapping("/MatchingTitle/{title}")
    //8-	Make a query that will find all the posts that match a given title.
    public List<Post> getMatchingTitles( @PathVariable("title") String title){
        return postService.findCommentByTitle(title);
    }


}
