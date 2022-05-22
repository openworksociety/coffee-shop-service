package app.coffee.service.dto.report;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SaleReportDetail implements Serializable {

	private static final long serialVersionUID = -1143919559363182567L;
	private Date fromDate;
	private Date toDate;
	private double totalTax;
	private double totalAmount;

	private List<EmployeeSaleReportDetail> empSaleReports;

	public SaleReportDetail() {
		super();
	}

	public SaleReportDetail(Date fromDate, Date toDate, double totalTax, double totalAmount,
			List<EmployeeSaleReportDetail> empSaleReports) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.totalTax = totalTax;
		this.totalAmount = totalAmount;
		this.empSaleReports = empSaleReports;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<EmployeeSaleReportDetail> getEmpSaleReports() {
		return empSaleReports;
	}

	public void setEmpSaleReports(List<EmployeeSaleReportDetail> empSaleReports) {
		this.empSaleReports = empSaleReports;
	}

}
