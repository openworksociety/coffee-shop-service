package app.coffee.service.dto;

import java.io.Serializable;

import app.coffee.service.entity.Product;

public class ProductResponse implements Serializable {

	private static final long serialVersionUID = 2226913389919764149L;

	private Product product;
	private String message;

	public ProductResponse(Product product, String message) {
		this.product = product;
		this.message = message;
	}

	public ProductResponse() {
		super();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
