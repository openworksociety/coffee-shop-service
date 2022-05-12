package app.coffee.service.repository;

import org.springframework.data.repository.CrudRepository;

import app.coffee.service.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
