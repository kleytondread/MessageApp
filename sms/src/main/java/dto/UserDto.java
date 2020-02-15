package dto;

import java.util.ArrayList;

public class UserDto {

	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean status;
	private ArrayList<ContactDto> contacts;
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<ContactDto> contacts) {
		this.contacts = contacts;
	}

	public UserProfileDto getUserProfileDto() {
		return userProfileDto;
	}

	public void setUserProfileDto(UserProfileDto userProfile) {
		this.userProfileDto = userProfile;
	}
}
