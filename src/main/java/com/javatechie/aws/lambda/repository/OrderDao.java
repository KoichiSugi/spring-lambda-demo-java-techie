package com.javatechie.aws.lambda.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Order;

@Repository
public class OrderDao {

	public List<Order> buildOrders() {
		return Stream.of(
				new Order(101, "Mobile", 20000, 1), 
				new Order(102, "Book", 20, 1),
				new Order(103, "Book", 30, 1), 
				new Order(104, "Jeans", 2000, 1)
			).collect(Collectors.toList());
	}

}
