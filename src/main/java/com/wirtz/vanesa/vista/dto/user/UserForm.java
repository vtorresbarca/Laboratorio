package com.wirtz.vanesa.vista.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

	private Long id;
	
	@NotNull(message="El nombre de usuario es obligatorio")
	@NotBlank(message="El nombre de usuario no puede estar en blanco")
	@Size(min = 3, max = 20)
	private String username;

	private String password;
	
	private String password2;

	@Size(min = 5, max = 20)
	@NotBlank(message="El nombre no puede estar en blanco")
	private String name;
	
	@Size(min = 5, max = 20)
	@NotBlank(message="El apellido no puede estar en blanco")
	private String firstName;
	
	@Size(min = 5, max = 20)
	@NotBlank(message="El apellido no puede estar en blanco")
	private String secondName;

	@Email
	private String email;
	
	public UserForm() {
	}
	
	public UserForm(Long id,
			@NotNull(message = "El nombre de usuario es obligatorio") @NotBlank(message = "El nombre de usuario no puede estar en blanco") String username,
			String password, String password2, String name, String firstName, String secondName, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.name = name;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
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
