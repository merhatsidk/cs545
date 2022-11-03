package edu.miu.cs545.restApi.controller;

import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.dto.User1Dto;
import edu.miu.cs545.restApi.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class User1Controller {

    @Autowired
    private User1Service userService;

    @GetMapping
    public List<User1Dto> findAll(){
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public User1Dto findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody User1Dto user1Dto){
        userService.save(user1Dto);
    }

    @GetMapping("/{id}/posts")
    public List<PostResponseDto> findPostById(@PathVariable Long id){
        return userService.findPostById(id);
    }

}
