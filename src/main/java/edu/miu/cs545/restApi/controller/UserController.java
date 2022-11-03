package edu.miu.cs545.restApi.controller;

import edu.miu.cs545.restApi.domain.User;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.dto.UserDto;
import edu.miu.cs545.restApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @GetMapping("/{id}/posts")
    public List<PostResponseDto> findPostById(@PathVariable Long id){
        return userService.findPostById(id);
    }

    //6-	Make a query that will return all the users that have more than 1 post

    @GetMapping("/moreThanOne")
    public List<String> moreThanOne(){
        return userService.getUsersMoreThanOne();
    }

}
