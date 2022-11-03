package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT  u.name from User u where u.posts.size > 1 ")
    List<String> findUsersMoreThanOne();
}
