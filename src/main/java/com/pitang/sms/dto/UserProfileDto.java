package com.pitang.sms.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfileDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String telephone1;
	private String telephone2;
	private String address1;
	private String address2;
	private String city;
	private String country;
    private Date dateOfBirth;
	private UserDto userModel;
	
	public UserProfileDto(Long id, String firstName, String lastName, String telephone1, String telephone2,
			String address1, String address2, String city, String country, Date dateOfBirth, UserDto userModel) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone1 = telephone1;
		this.telephone2 = telephone2;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
		this.userModel = userModel;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public UserDto getUserModel() {
		return userModel;
	}

	public void setUserModel(UserDto userModel) {
		this.userModel = userModel;
	}
	

}