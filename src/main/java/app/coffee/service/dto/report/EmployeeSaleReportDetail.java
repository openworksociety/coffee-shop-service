package app.coffee.service.dto.report;

import java.io.Serializable;

public class EmployeeSaleReportDetail implements Serializable {

	private static final long serialVersionUID = -573396913478249323L;
	private Long userId;
	private String username;
	private Integer totalOrders;
	private double totalOrderAmount;

	public EmployeeSaleReportDetail() {
		super();
	}

	public EmployeeSaleReportDetail(Long userId, String username, Integer totalOrders, double totalOrderAmount) {
		super();
		this.userId = userId;
		this.username = username;
		this.totalOrders = totalOrders;
		this.totalOrderAmount = totalOrderAmount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(Integer totalOrders) {
		this.totalOrders = totalOrders;
	}

	public double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

}
