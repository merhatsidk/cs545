package edu.miu.cs545.restApi.service;


import edu.miu.cs545.restApi.domain.User;
import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.dto.UserDto;

import javax.persistence.Id;
import java.util.List;

public interface UserService {
    public List<UserDto> findAll();

    UserDto findById(Long id);

    void save(UserDto userDto);

    List<PostResponseDto> findPostById(Long id);

   List<String> findUsersMoreThanOne();

    List<UserDto> moreThanNPosts(int num);
}
