package com.pitang.sms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String status;
	private byte[] image;
	private List<ContactDto> contacts;
	private UserProfileDto userProfileDto;
	
	public UserDto () { 
		
	}


	public UserDto(String firstName, String lastName, String email, String password, String userName) { //construtor simples só por precaução
		this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactDto> contacts) {
		this.contacts = contacts;
	}

	public UserProfileDto getUserProfileDto() {
		return userProfileDto;
	}

	public void setUserProfileDto(UserProfileDto userProfile) {
		this.userProfileDto = userProfile;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}
}
