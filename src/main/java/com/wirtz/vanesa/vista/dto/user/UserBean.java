package com.wirtz.vanesa.vista.dto.user;

public class UserBean {

	private String username;

	private String name;
	
	private String firstName;
	
	private String secondName;
	
	private String email;
	
	public UserBean() {
		
	}

	public UserBean(String username, String name, String firstName, String secondName, String email) {
		super();
		this.username = username;
		this.name = name;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
