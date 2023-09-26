package br.com.mbds.productorder.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.mbds.productorder.entities.Category;
import br.com.mbds.productorder.entities.Order;
import br.com.mbds.productorder.entities.OrderItem;
import br.com.mbds.productorder.entities.Payment;
import br.com.mbds.productorder.entities.Product;
import br.com.mbds.productorder.entities.User;
import br.com.mbds.productorder.entities.enums.OrderStatus;
import br.com.mbds.productorder.repositories.CategoryRepository;
import br.com.mbds.productorder.repositories.OrderItemRepository;
import br.com.mbds.productorder.repositories.OrderRepository;
import br.com.mbds.productorder.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		List<User> users = userRepository.saveAll(Arrays.asList(
				User.builder().name("Alex Green").email("alex@mail.com").phone("(99)99999-9999").password("123456")
						.build(),
				User.builder().name("Maria Brown").email("maria@mail.com").phone("(99)98888-8888").password("123456")
						.build()));

		List<Order> orders = orderRepository.saveAll(Arrays.asList(
				Order.builder().moment(Instant.parse("2023-06-20T19:53:07Z")).client(users.get(0))
						.orderStatus(OrderStatus.DELIVERED.getId()).build(),
				Order.builder().moment(Instant.parse("2013-07-21T03:42:10Z")).client(users.get(0))
						.orderStatus(OrderStatus.PAID.getId()).build(),
				Order.builder().moment(Instant.parse("2013-07-22T05:42:10Z")).client(users.get(1))
						.orderStatus(OrderStatus.WAITING_PAYMENT.getId()).build()));

		List<Category> categories = categoryRepository
				.saveAll(Arrays.asList(Category.builder().name("Electronics").build(),
						Category.builder().name("Books").build(), Category.builder().name("Computers").build()));

		List<Product> products = productRepository.saveAll(Arrays.asList(
				Product.builder().name("The Lord of the Rings").description("The Lord of the Rings description.")
						.price(90.5).build(),
				Product.builder().name("Smart TV").description("Smart TV description.").price(2190.0).build(),
				Product.builder().name("Macbook Pro").description("Macbook Pro description.").price(1250.0).build(),
				Product.builder().name("PC Gamer").description("PC Gamer description.").price(1200.0).build(),
				Product.builder().name("Rails for Dummies").description("Rails for Dummies description.").price(100.99)
						.build()));

		products.get(0).getCategories().add(categories.get(1));
		products.get(1).getCategories().add(categories.get(0));
		products.get(1).getCategories().add(categories.get(2));
		products.get(2).getCategories().add(categories.get(2));
		products.get(3).getCategories().add(categories.get(2));
		products.get(4).getCategories().add(categories.get(1));
		productRepository.saveAll(products);

		orderItemRepository
				.saveAll(Arrays.asList(new OrderItem(orders.get(0), products.get(0), 2, products.get(0).getPrice()),
						new OrderItem(orders.get(0), products.get(2), 1, products.get(2).getPrice()),
						new OrderItem(orders.get(1), products.get(2), 2, products.get(2).getPrice()),
						new OrderItem(orders.get(2), products.get(4), 2, products.get(4).getPrice())));

		orders.get(0).setPayment(new Payment(null, Instant.parse("2023-06-20T20:13:48Z"), orders.get(0)));
		orders.get(1).setPayment(new Payment(null, Instant.parse("2013-07-21T05:28:19Z"), orders.get(1)));
		orderRepository.saveAll(orders);

	}

}
