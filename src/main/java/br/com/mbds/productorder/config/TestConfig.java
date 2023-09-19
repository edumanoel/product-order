package br.com.mbds.productorder.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.mbds.productorder.entities.Category;
import br.com.mbds.productorder.entities.Order;
import br.com.mbds.productorder.entities.User;
import br.com.mbds.productorder.entities.enums.OrderStatus;
import br.com.mbds.productorder.repositories.CategoryRepository;
import br.com.mbds.productorder.repositories.OrderRepository;
import br.com.mbds.productorder.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(Arrays.asList(
				User.builder().name("Alex Green").email("alex@mail.com").phone("(99)99999-9999").password("123456")
						.build(),
				User.builder().name("Maria Brown").email("maria@mail.com").phone("(99)98888-8888").password("123456")
						.build()));

		User user1 = userRepository.findById(1L).get();
		User user2 = userRepository.findById(2L).get();

		orderRepository.saveAll(Arrays.asList(
				Order.builder().moment(Instant.parse("2023-06-20T19:53:07Z")).client(user1)
						.orderStatus(OrderStatus.DELIVERED.getId()).build(),
				Order.builder().moment(Instant.parse("2013-07-21T03:42:10Z")).client(user1)
						.orderStatus(OrderStatus.PAID.getId()).build(),
				Order.builder().moment(Instant.parse("2013-07-22T05:42:10Z")).client(user2)
						.orderStatus(OrderStatus.WAITING_PAYMENT.getId()).build()));

		categoryRepository.saveAll(Arrays.asList(Category.builder().name("Electronics").build(),
				Category.builder().name("Books").build(), Category.builder().name("Computers").build()));
	}

}
