package edu.miu.cs545.restApi;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.User1;
import edu.miu.cs545.restApi.repo.PostRepo;
import edu.miu.cs545.restApi.repo.User1Repo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RestApiApplication {

	@Autowired
	private PostRepo postRepo;
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(User1Repo user1Repo){
		return (args -> {
			Post p1 = new Post("first post","java","muhedin");
			Post p2 = new Post("second post","hibernate","john");
			Post p3 = new Post("third post","spring","dani");
			postRepo.save(p1);
			postRepo.save(p2);
			postRepo.save(p3);

			User1 u = new User1("merha");
			u.setPosts(Arrays.asList(p1,p2,p3));
			user1Repo.save(u);
//			insertUser(user1Repo);
		});
	}




	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


}
