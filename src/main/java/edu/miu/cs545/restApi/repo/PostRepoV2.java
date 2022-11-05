package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.PostV2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepoV2 extends JpaRepository<PostV2,Long> {

}
