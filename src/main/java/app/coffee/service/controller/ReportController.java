package app.coffee.service.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.coffee.service.dto.report.EmployeeSaleReportDetail;
import app.coffee.service.dto.report.ReportFilter;
import app.coffee.service.dto.report.SaleReportDetail;
import app.coffee.service.entity.Order;
import app.coffee.service.entity.User;
import app.coffee.service.repository.OrderRepository;
import app.coffee.service.repository.UserRepository;

@RestController
@RequestMapping(path = "/api/reports")
public class ReportController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@PostMapping("/showSaleReport")
	SaleReportDetail showSaleReport(@RequestBody ReportFilter reportFilter) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = sdf.parse(reportFilter.getFromDate());
		Date toDate = sdf.parse(reportFilter.getToDate());

		List<Order> orders = new ArrayList<Order>();
		orders = orderRepository.findAllBetweenDates(fromDate, toDate);

		Map<Long, List<Order>> ordersByUserMap = orders.stream().collect(Collectors.groupingBy(Order::getCreatedBy));

		List<EmployeeSaleReportDetail> empReports = new ArrayList<EmployeeSaleReportDetail>();
		for (Entry<Long, List<Order>> entry : ordersByUserMap.entrySet()) {
			EmployeeSaleReportDetail empReport = new EmployeeSaleReportDetail();
			empReport.setUserId(entry.getKey());
			Integer totalOrders = entry.getValue().size();
			empReport.setTotalOrders(totalOrders);
			double totalOrderAmount = entry.getValue().stream().mapToDouble(Order::getTotalAmount).sum();
			empReport.setTotalOrderAmount(totalOrderAmount);
			Optional<User> userData = userRepository.findById(entry.getKey());
			if (userData.isPresent()) {
				empReport.setUsername(userData.get().getFname() + " " + userData.get().getLname());
			}
			empReports.add(empReport);
		}

		SaleReportDetail saleReport = new SaleReportDetail();
		saleReport.setTotalTax(orders.stream().mapToDouble(Order::getTaxAmount).sum());
		saleReport.setTotalAmount(orders.stream().mapToDouble(Order::getTotalAmount).sum());
		saleReport.setEmpSaleReports(empReports);

		return saleReport;
	}

	@ResponseBody
	@PostMapping("/showPerformanceReport")
	List<EmployeeSaleReportDetail> showPerformanceReport(@RequestBody ReportFilter reportFilter) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = sdf.parse(reportFilter.getFromDate());
		Date toDate = sdf.parse(reportFilter.getToDate());

		List<Order> orders = new ArrayList<Order>();
		orders = orderRepository.findAllBetweenDates(fromDate, toDate);

		Map<Long, List<Order>> ordersByUserMap = orders.stream().collect(Collectors.groupingBy(Order::getCreatedBy));

		List<EmployeeSaleReportDetail> empReports = new ArrayList<EmployeeSaleReportDetail>();
		for (Entry<Long, List<Order>> entry : ordersByUserMap.entrySet()) {
			EmployeeSaleReportDetail empReport = new EmployeeSaleReportDetail();
			empReport.setUserId(entry.getKey());
			Integer totalOrders = entry.getValue().size();
			empReport.setTotalOrders(totalOrders);
			double totalOrderAmount = entry.getValue().stream().mapToDouble(Order::getTotalAmount).sum();
			empReport.setTotalOrderAmount(totalOrderAmount);
			Optional<User> userData = userRepository.findById(entry.getKey());
			if (userData.isPresent()) {
				empReport.setUsername(userData.get().getFname() + " " + userData.get().getLname());
			}
			empReports.add(empReport);
		}

		return empReports;
	}

	@ResponseBody
	@PostMapping("/showOrderHistoryReport")
	List<Order> showOrderHistoryReport(@RequestBody ReportFilter reportFilter) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = sdf.parse(reportFilter.getFromDate());
		Date toDate = sdf.parse(reportFilter.getToDate());

		List<Order> orders = orderRepository.findAllBetweenDates(fromDate, toDate);
		return orders;
	}

}
