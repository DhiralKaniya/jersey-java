package org.jersey.learning.messagnger.Model;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

public class Comment {
	private int commentid;
	private int messageid;
	private String comment;
	private String author;
	private Date created;
	public Comment(int commentid,int messageid, String comment, String author) {
	
		this.messageid = messageid;
		this.commentid = commentid;
		this.comment = comment;
		this.author = author;
		this.created = new Date();
	}
	public Comment( int messageid, String comment, String author) {
	
		this.commentid = 0;
		this.messageid = messageid;
		this.comment = comment;
		this.author = author;
		this.created = new Date();
	}
	
	
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
