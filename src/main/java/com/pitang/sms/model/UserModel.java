package com.pitang.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")

public class UserModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull
	@Size(max= 65)
	@Column(name = "user_name",
			unique = true)
	private String userName;
	
	@NotNull
	@Size(max= 65)
	@Column (name = "first_name")
	private String firstName;
	
	@Size(max= 65)
	@Column (name = "last_name")
	private String lastName;
	
	@NotNull
	@Email
	@Size(max= 100)
	@Column (unique = true)
	private String email;
	
	@NotNull
	@Size(max= 32)
	@Column (unique = true)
	private String password;
	
	@NotNull
	private Boolean status;
	
    @Column(name = "image")
    @Lob
    private byte[] image;
	
	@OneToMany (fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "user")
	private List<Contact> contacts;
	
	@OneToOne (fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "user")
	private UserProfile userProfile;
	
	public UserModel () { //hibernate não precisa de construtor
		
	}


	public UserModel(String firstName, String lastName, String email, String password, String userName) { //construtor simples só por precaução
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

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public void addSingleContact(Contact contact) {
		contacts.add(contact);
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
	

}
