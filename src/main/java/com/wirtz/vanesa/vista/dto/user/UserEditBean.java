package com.wirtz.vanesa.vista.dto.user;

public class UserEditBean {


	private Long id;
	
	private String username;

	private String name;
	
	private String firstName;
	
	private String secondName;
	
	private String email;
	
	private String password;
	
	private String password2;
	
	public UserEditBean() {
		
	}

	public UserEditBean(Long id, String username, String name, String firstName, String secondName, String email,
			String password, String password2) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.password = password;
		this.password2 = password2;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
