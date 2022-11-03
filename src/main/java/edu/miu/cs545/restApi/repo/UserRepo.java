package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
//    List<User>
}
