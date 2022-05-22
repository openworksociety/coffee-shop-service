package app.coffee.service.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CS_ORDERS")
@DynamicUpdate
public class Order extends AbstractAuditEntity {

	private static final long serialVersionUID = 4452551194453585976L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "CONTACT", length = 10, nullable = false)
	private Long contact;

	@Column(name = "TAX_AMOUNT", nullable = false)
	private double taxAmount;

	@Column(name = "SUBTOTAL_AMOUNT", nullable = false)
	private double subTotalAmount;

	@Column(name = "TOTAL_AMOUNT", nullable = false)
	private double totalAmount;

	@Column(name = "NOTE")
	private String note;

	public Order() {
		super();
	}

	public Order(Long id, String name, Long contact, double taxAmount, double subTotalAmount, double totalAmount,
			String note, Long modifiedBy, Long createdBy, Date modifiedDate, Date createdDate, boolean isDeactivated) {
		super(modifiedBy, createdBy, modifiedDate, createdDate, isDeactivated);
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.taxAmount = taxAmount;
		this.subTotalAmount = subTotalAmount;
		this.totalAmount = totalAmount;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getSubTotalAmount() {
		return subTotalAmount;
	}

	public void setSubTotalAmount(double subTotalAmount) {
		this.subTotalAmount = subTotalAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
