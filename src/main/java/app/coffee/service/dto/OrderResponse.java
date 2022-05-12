package app.coffee.service.dto;

import java.io.Serializable;

import app.coffee.service.entity.Order;

public class OrderResponse implements Serializable {
	private static final long serialVersionUID = 1576996471053014792L;

	private String message;
	private Order order;

	public OrderResponse() {
		super();
	}

	public OrderResponse(String message, Order order) {
		super();
		this.message = message;
		this.order = order;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
