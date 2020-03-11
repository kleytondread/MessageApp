package com.pitang.sms.model;

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
	
	@OneToOne (fetch = FetchType.LAZY,optional = false)
	@JoinColumn (name = "sender_user_id", nullable = false)
	private UserModel sender;
	
	@OneToOne (fetch = FetchType.LAZY,optional = false)
	@JoinColumn (name = "recipient_user_id", nullable = false)
	private UserModel recipient;
	
	@NotNull
	@Size(max = 1000)
	@Column(name = "text")
	private String text;
	
	@NotNull
	@Column (name="status_sender")
	private Boolean deletedStatusSender;
	
	@NotNull
	@Column (name="status_recipient")
	private Boolean deletedStatusRecipient;
	
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
	
	public Boolean getDeletedStatusSender() {
		return deletedStatusSender;
	}

	public void setDeletedStatusSender(Boolean deletedStatusSender) {
		this.deletedStatusSender = deletedStatusSender;
	}

	public Boolean getDeletedStatusRecipient() {
		return deletedStatusRecipient;
	}

	public void setDeletedStatusRecipient(Boolean deletedStatusRecipient) {
		this.deletedStatusRecipient = deletedStatusRecipient;
	}

	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

}
