package edu.miu.cs545.restApi.service;


import edu.miu.cs545.restApi.dto.PostResponseDto;
import edu.miu.cs545.restApi.dto.User1Dto;

import java.util.List;

public interface User1Service {
    public List<User1Dto> findAll();

    User1Dto findById(Long id);

    void save(User1Dto user1Dto);

    List<PostResponseDto> findPostById(Long id);
}
