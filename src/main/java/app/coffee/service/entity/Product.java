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
@Table(name = "CS_PRODUCT")
@DynamicUpdate
public class Product extends AbstractAuditEntity {

	private static final long serialVersionUID = 8413637696829749171L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE", nullable = false)
	private double price;

	public Product() {
		super();
	}

	public Product(Long id, String name, String description, double price, Long modifiedBy, Long createdBy,
			Date modifiedDate, Date createdDate, boolean isDeactivated) {
		super(modifiedBy, createdBy, modifiedDate, createdDate, isDeactivated);
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
