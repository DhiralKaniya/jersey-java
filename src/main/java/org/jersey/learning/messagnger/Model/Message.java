package org.jersey.learning.messagnger.Model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	
	private int id;
	private String author;
	
	private Date createdDate;
	private Map<Integer, Comment> comments ;
	private String message;
	
	public Message() {
		this.comments = new HashMap<>();
	}
	public Message(String id, String author, String message) {
		this.id = Integer.parseInt(id);
		this.message = message;
		this.author = author;
		this.createdDate = new Date();
		this.comments = new HashMap<>();
	}
	public Message(int id, String author, String message) {
		this.id = id;
		this.author = author;
		this.createdDate = new Date();
		this.message = message;
		this.comments = new HashMap<>();
	}
	
	public Map<Integer, Comment> getComments() {
		return comments;
	}
	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
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
