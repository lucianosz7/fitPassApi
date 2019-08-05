package com.api.fitPass;

import com.api.fitPass.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

import com.api.fitPass.model.User;

@SpringBootApplication
public class FitPassApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitPassApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository repository){
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						User u = new User();
						u.setName("User " + i);
						u.setEmail("Email " + i + "@email.com");
						u.setPhone("(111) 111-1111");
						return u;
					})
					.map(s -> repository.save(s))
					.forEach(System.out::println);
		};
	}
}
