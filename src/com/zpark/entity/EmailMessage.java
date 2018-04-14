package com.zpark.entity;

public class EmailMessage {
	private String sender;
	private String password;
	private String receiver;
	private String copyReceiver;
	private String title;
	private String content;
	@Override
	public String toString() {
		return "EmailMessage [content=" + content + ", copyReceiver="
				+ copyReceiver + ", password=" + password + ", receiver="
				+ receiver + ", sender=" + sender + ", title=" + title + "]";
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getCopyReceiver() {
		return copyReceiver;
	}
	public void setCopyReceiver(String copyReceiver) {
		this.copyReceiver = copyReceiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
