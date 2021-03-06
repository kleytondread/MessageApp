package com.pitang.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "user_profile")
public class UserProfile{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size (max = 65)
	@Column (name = "first_name")
	private String firstName;
	
	@Size (max = 65)
	@Column (name = "last_name")
	private String lastName;
	
	@Size (max = 15)
	private String telephone1;
	
	@Size (max = 15)
	private String telephone2;
	
	@Size (max = 150)
	private String address1;
	
	@Size (max = 150)
	private String address2;
	
	@Size (max = 65)
	private String city;
	
	@Size (max = 65)
	private String country;
	
	@OneToOne (fetch = FetchType.LAZY)
	//@MapsId
	private UserModel user;

	public UserProfile() {
		
	}

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

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserModel getUserModel() {
		return user;
	}

	public void setUserModel(UserModel userModel) {
		this.user = userModel;
	}
	
}
	