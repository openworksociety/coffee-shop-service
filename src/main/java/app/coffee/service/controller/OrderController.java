package app.coffee.service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.coffee.service.entity.Order;
import app.coffee.service.repository.OrderRepository;

@RestController
@RequestMapping(path = "/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@PostMapping("/create")
	void create(@RequestBody Order order) {
		order.setId(null);
		orderRepository.save(order);
	}

	@ResponseBody
	@GetMapping("/{id}")
	Order findById(@PathVariable Long id) {
		Optional<Order> orderEntity = orderRepository.findById(id);
		if (orderEntity.isPresent()) {
			return orderEntity.get();
		}
		return null;
	}

	@ResponseBody
	@GetMapping("")
	List<Order> findAll() {
		List<Order> orders = new ArrayList<Order>();
		Iterable<Order> iterable = orderRepository.findAll();
		iterable.forEach(order -> {
			if (!order.isDeactivated()) {
				orders.add(order);
			}
		});
		return orders;
	}

	@PutMapping("/update")
	void update(@RequestBody Order order) {
		if (order.getId() != null) {
			Optional<Order> orderEntity = orderRepository.findById(order.getId());
			if (orderEntity.isPresent()) {
				orderRepository.save(order);
			}
		}
	}

	@DeleteMapping("/delete/{id}")
	void delete(@PathVariable Long id) {
		Optional<Order> orderEntity = orderRepository.findById(id);
		if (orderEntity.isPresent()) {
			orderEntity.get().setDeactivated(true);
			orderEntity.get().setModifiedDate(new Date());
			orderRepository.save(orderEntity.get());
		}
	}

	@PostMapping("/test/{id}")
	void setupTestData(@PathVariable Long id) {

		for (int i = 1; i <= id.intValue(); i++) {
			Order newOrder = new Order();
			newOrder.setName("Order" + i);
			newOrder.setContact(123L);
			newOrder.setNote("test" + i);
			newOrder.setSubTotalAmount(100);
			newOrder.setTaxAmount(5);
			newOrder.setTotalAmount(105);
			newOrder.setCreatedBy(1L);
			newOrder.setModifiedBy(1L);
			newOrder.setCreatedDate(new Date());
			newOrder.setModifiedDate(new Date());
			newOrder.setDeactivated(false);
			orderRepository.save(newOrder);
		}
	}
}
