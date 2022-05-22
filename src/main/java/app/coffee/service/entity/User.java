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
@Table(name = "CS_USERS")
@DynamicUpdate
public class User extends AbstractAuditEntity {

	private static final long serialVersionUID = 2301613904143883569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String fname;

	@Column(name = "LAST_NAME")
	private String lname;

	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	public User() {
		super();
	}

	public User(Long id, String fname, String lname, String username, String password, Long modifiedBy, Long createdBy,
			Date modifiedDate, Date createdDate, boolean isDeactivated) {
		super(modifiedBy, createdBy, modifiedDate, createdDate, isDeactivated);
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
