package app.coffee.service.repository;

import org.springframework.data.repository.CrudRepository;

import app.coffee.service.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
