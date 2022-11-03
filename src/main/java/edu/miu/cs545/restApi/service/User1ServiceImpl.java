package edu.miu.cs545.restApi.service;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.User1;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.dto.User1Dto;
import edu.miu.cs545.restApi.repo.User1Repo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class User1ServiceImpl implements User1Service {

    @Autowired
    private ModelMapper modelMapper;



    @Autowired
    private User1Repo userRepo;

    public List<User1Dto> findAll(){
        List<User1> users =  userRepo.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, User1Dto.class))
                .collect(Collectors.toList());
    }

    @Override
    public User1Dto findById(Long id) {
       return modelMapper.map(userRepo.findById(id), User1Dto.class);
    }

    @Override
    public void save(User1Dto user1Dto) {
        userRepo.save(modelMapper.map(user1Dto, User1.class));
    }

    @Override
    public List<PostResponseDto> findPostById(Long id) {
        User1 user = userRepo.findById(id).get();
        List<Post> posts =  user.getPosts();
       return   posts.stream()
                .map(post -> modelMapper.map(post,PostResponseDto.class))
               .collect(Collectors.toList());
    }

}
