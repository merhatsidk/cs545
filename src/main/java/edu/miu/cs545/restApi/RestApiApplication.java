package edu.miu.cs545.restApi;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.User;
import edu.miu.cs545.restApi.repo.PostRepo;
import edu.miu.cs545.restApi.repo.UserRepo;
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
	public CommandLineRunner run(UserRepo userRepo){
		return (args -> {
			Post p1 = new Post("first post","java","muhedin");
			Post p2 = new Post("second post","hibernate","john");
			Post p3 = new Post("third post","spring","dani");
			postRepo.save(p1);
			postRepo.save(p2);
			postRepo.save(p3);

			User u = new User("merha");
			u.setPosts(Arrays.asList(p1,p2,p3));
			userRepo.save(u);
//			insertUser(user1Repo);
		});
	}




	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


}
