package digytal.myfriends.restapi;

import digytal.myfriends.restapi.service.FriendService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyFriendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFriendsApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(FriendService bean) throws Exception {
		return args -> {

		};
	}


}
