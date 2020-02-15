package model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long messageId;
	
	@NotNull
	@OneToOne (fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "user")
	private UserModel sender;
	
	@NotNull
	@OneToOne (fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "user")
	private UserModel recipient;
	
	@NotNull
	@Size(max = 1000)
	@Column(name = "text")
	private String text;
	
	@NotNull
    @Temporal(TemporalType.DATE)
	@Column(name = "message_Date")
	private Date messageDate;
	
	public Message() { //Construtor hibernate

	}
	
	
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public UserModel getSender() {
		return sender;
	}
	public void setSender(UserModel sender) {
		this.sender = sender;
	}
	public UserModel getRecipient() {
		return recipient;
	}
	public void setRecipient(UserModel recipient) {
		this.recipient = recipient;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
