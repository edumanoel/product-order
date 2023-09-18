package br.com.mbds.productorder.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.mbds.productorder.entities.User;
import br.com.mbds.productorder.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(Arrays.asList(
				User.builder().name("Alex Green").email("alex@mail.com").phone("(99)99999-9999").password("123456")
						.build(),
				User.builder().name("Maria Brown").email("maria@mail.com").phone("(99)98888-8888").password("123456")
						.build()));
	}

}
