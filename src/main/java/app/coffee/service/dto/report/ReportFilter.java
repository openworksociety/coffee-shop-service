package app.coffee.service.dto.report;

import java.io.Serializable;

public class ReportFilter implements Serializable {
	private static final long serialVersionUID = -39729181176263343L;

	private String fromDate;
	private String toDate;

	public ReportFilter() {
	}

	public ReportFilter(String fromDate, String toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
