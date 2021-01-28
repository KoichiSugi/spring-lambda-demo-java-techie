package com.javatechie.aws.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javatechie.aws.lambda.domain.Order;
import com.javatechie.aws.lambda.repository.OrderDao;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private OrderDao orderDao;

	// get method
	@Bean
	public Supplier<List<Order>> orders() {
		return () -> orderDao.buildOrders();
	}

	// return a list of order and String when inputs and order name is identical
	@Bean
	public Function<String, List<Order>> findOrderByName() {
		return (input) -> orderDao.buildOrders().stream().filter(order -> order.getName().equals(input))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
