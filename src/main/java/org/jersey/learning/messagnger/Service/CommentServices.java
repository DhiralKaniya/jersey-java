package org.jersey.learning.messagnger.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jersey.learning.messagnger.AutoHashMap;
import org.jersey.learning.messagnger.DataBase.DatabaseConnection;
import org.jersey.learning.messagnger.Error.UserError;
import org.jersey.learning.messagnger.Model.*;
public class CommentServices {
	private HashMap<Integer, Message> messageService = DatabaseConnection.messages;
	

	public List<Comment> getComments(int messageid){
		List<Comment> mycomments = new ArrayList<Comment>();
		try {
			if(messageService.get(messageid).getCommentValues().size() > 0)
				mycomments = new ArrayList<Comment>(messageService.get(messageid).getCommentValues());
			else
				mycomments.add(new Comment(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException()));
		}catch(Exception e) {
			mycomments.add(new Comment(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException()));
		}
		return mycomments;
	}
	public Comment getComment(int messageid,int commentid) {
		try {
			List<Comment> commentValues = messageService.get(messageid).getCommentValues();
			List<Integer> commentIDs = messageService.get(messageid).getCommentIDs();
			HashMap<Integer, Comment> comments = new AutoHashMap<Integer, Comment>(commentIDs, commentValues);
			if(comments.containsKey(commentid))
				return comments.get(commentid);
			else
				return new Comment(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException());
		}catch(Exception e) {
			return new Comment(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException());
		}
	}
	public Comment addComment(Comment comment ) {
		if(messageService.get(comment.getMessageid()) != null) {
			try {
				List<Comment> commentValues = messageService.get(comment.getMessageid()).getCommentValues();
				List<Integer> commentIDs = messageService.get(comment.getMessageid()).getCommentIDs();
				HashMap<Integer, Comment> comments = new AutoHashMap<Integer, Comment>(commentIDs, commentValues);
				comment.setCommentid(comments.size()+1);
				comments.put(comment.getCommentid(), comment);
				messageService.get(comment.getMessageid()).setComments(comments);
				return comment;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}
	public Comment updateComment(Comment comment) {
		if(messageService.get(comment.getMessageid()) != null) {
			try {
				List<Comment> commentValues = messageService.get(comment.getMessageid()).getCommentValues();
				List<Integer> commentIDs = messageService.get(comment.getMessageid()).getCommentIDs();
				HashMap<Integer, Comment> comments = new AutoHashMap<Integer, Comment>(commentIDs, commentValues);
				if(comments.containsKey(comment.getCommentid())) {
					comments.put(comment.getCommentid() , comment);
					return comment;
				}
			}catch(Exception e) {
				System.out.print(e.getMessage());
				return null;
			}
		}
		return null;
	}
	public Comment removeComment(int commentid, int messageid) {
		if(messageService.get(messageid)!= null) {
			try {
				List<Comment> commentValues = messageService.get(messageid).getCommentValues();
				List<Integer> commentIDs = messageService.get(messageid).getCommentIDs();
				HashMap<Integer, Comment> comments = new AutoHashMap<Integer, Comment>(commentIDs, commentValues);
				return comments.remove(commentid);
			}catch(Exception e) {
				return null;
			}
		}
		return null;
	}
}
