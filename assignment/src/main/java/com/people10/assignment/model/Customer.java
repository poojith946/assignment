package com.people10.assignment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tbl_customer")
@ApiModel(description = "All details about the customer. ")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(notes = "First name must not be empty", required = true)
	@NotEmpty(message = "First name must not be empty")
	private String firstName;

	@ApiModelProperty(notes = "Last name must not be empty")
	@NotEmpty(message = "Last name must not be empty")
	private String lastName;

	@ApiModelProperty(notes = "Email must not be empty and valid email address")
	@NotEmpty(message = "Email must not be empty")
	@Email(message = "Email must be a valid email address")
	private String email;

	private Date dob;

	@ApiModelProperty(notes = "password must not be empty")
	@NotEmpty(message = "password must not be empty")
	@ValidPassword
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}