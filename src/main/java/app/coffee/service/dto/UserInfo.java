package app.coffee.service.dto;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 4824519366672272833L;

	private Long id;
	private String username;
	private String password;
	private String message;
	private boolean isValid;

	public UserInfo() {
		super();
	}

	public UserInfo(Long id, String username, String password, String message, boolean isValid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.message = message;
		this.isValid = isValid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
