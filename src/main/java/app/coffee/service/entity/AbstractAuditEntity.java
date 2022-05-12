package app.coffee.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = 1593946058183148642L;

	@Column(name = "MODIFIED_BY")
	private Long modifiedBy = 1L;

	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	private Long createdBy = 1L;

	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate = new Date();

	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
	private Date createdDate = new Date();

	@Column(name = "IS_DEACTIVATED")
	private boolean isDeactivated = false;

	public AbstractAuditEntity() {
		super();
	}

	public AbstractAuditEntity(Long modifiedBy, Long createdBy, Date modifiedDate, Date createdDate,
			boolean isDeactivated) {
		super();
		this.modifiedBy = modifiedBy;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.createdDate = createdDate;
		this.isDeactivated = isDeactivated;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isDeactivated() {
		return isDeactivated;
	}

	public void setDeactivated(boolean isDeactivated) {
		this.isDeactivated = isDeactivated;
	}

}
