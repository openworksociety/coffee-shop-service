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

import app.coffee.service.entity.Product;
import app.coffee.service.repository.ProductRepository;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/create")
	public void create(@RequestBody Product product) {
		product.setId(null);
		productRepository.save(product);
	}

	@ResponseBody
	@GetMapping("/{id}")
	public Product findById(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@ResponseBody
	@GetMapping("")
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		Iterable<Product> iterable = productRepository.findAll();
		iterable.forEach(product -> {
			if (!product.isDeactivated()) {
				products.add(product);
			}
		});
		return products;
	}

	@PutMapping("/update")
	public void update(@RequestBody Product product) {
		if (product.getId() != null) {
			Optional<Product> productEntity = productRepository.findById(product.getId());
			if (productEntity.isPresent()) {
				productRepository.save(product);
			}
		}
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			product.get().setDeactivated(true);
			product.get().setModifiedDate(new Date());
			productRepository.save(product.get());
		}
	}

}
