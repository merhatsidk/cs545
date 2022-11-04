package edu.miu.cs545.restApi.service;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.User;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.dto.UserDto;
import edu.miu.cs545.restApi.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;



    @Autowired
    private UserRepo userRepo;

    public List<UserDto> findAll(){
        List<User> users =  userRepo.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
       return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void save(Long id, List<Post> posts) {
        User u = userRepo.findById(id).get();
        List<Post> postList =  u.getPosts();
        postList.addAll(posts);

        userRepo.save(u);
    }

    @Override
    public List<PostResponseDto> findPostById(Long id) {
        User user = userRepo.findById(id).get();
        List<Post> posts =  user.getPosts();
       return   posts.stream()
                .map(post -> modelMapper.map(post,PostResponseDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public List<String> findUsersMoreThanOne() {
        return userRepo.findUsersMoreThanOne();
    }

    @Override
    public List<UserDto> moreThanNPosts(int num) {
         List<User> users =userRepo.findUserByPostsGreaterThan(num);
         return users.stream()
                 .map(user -> modelMapper.map(user,UserDto.class))
                 .collect(Collectors.toList());
    }

}
