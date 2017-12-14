package org.jersey.learning.messagnger.Model;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	
	private int id;
	private String author;
	
	private Date createdDate;
	
	//@FormParam("message")
	private String message;
	
	public Message() {
		
	}
	public Message(String id, String author, String message) {
		this.id = Integer.parseInt(id);
		this.message = message;
		this.author = author;
		this.createdDate = new Date();
	}
	public Message(int id, String author, String message) {
		this.id = id;
		this.author = author;
		this.createdDate = new Date();
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
