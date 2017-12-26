package org.jersey.learning.messagnger.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.jersey.learning.messagnger.Adapter.MapAdapter;

@XmlRootElement
public class Message {
	
	private int id;
	
	private String author;
	
	private Date createdDate;
	
	private HashMap<Integer, Comment> comments =  new HashMap<>();
	
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
	
	
	@XmlTransient
	public List< Comment> getCommentValues(){
		return new ArrayList<Comment>(comments.values());
	}
	@XmlTransient
	public List<Integer> getCommentIDs(){
		return new ArrayList<Integer>(comments.keySet());
	}
	
	public void setComments(HashMap<Integer, Comment> comments) {
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
