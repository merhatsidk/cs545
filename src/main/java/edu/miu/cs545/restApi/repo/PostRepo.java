package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

    //8-	Make a query that will find all the posts that match a given title.
    @Query("select p from Post p where p.title = :title")
    List<Post> findPostByTitleMatches(String title);


}
