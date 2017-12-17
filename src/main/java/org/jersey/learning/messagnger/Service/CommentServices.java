package org.jersey.learning.messagnger.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jersey.learning.messagnger.DataBase.DatabaseConnection;
import org.jersey.learning.messagnger.Error.UserError;
import org.jersey.learning.messagnger.Model.*;
public class CommentServices {
	private HashMap<Integer, Message> messageService = DatabaseConnection.messages;
	

	public List<Comment> getComments(int messageid){
		List<Comment> mycomments = new ArrayList<Comment>();
		if(messageService.get(messageid).getComments().values().size() > 0)
			mycomments = new ArrayList<Comment>(messageService.get(messageid).getComments().values());
		else
			mycomments.add(new Comment(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException()));
		return mycomments;
	}
	public Comment getComment(int messageid,int commentid) {
		Map<Integer, Comment> comments = messageService.get(messageid).getComments();
		if(comments.containsKey(commentid))
			return comments.get(commentid);
		else
			return new Comment(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException());
	}
	public Comment addComment(Comment comment ) {
		if(messageService.get(comment.getMessageid()) != null) {
			Map<Integer, Comment> comments = messageService.get(comment.getMessageid()).getComments();
			comment.setCommentid(comments.size()+1);
			comments.put(comment.getCommentid(), comment);
			messageService.get(comment.getMessageid()).setComments(comments);
			return comment;
		}
		return null;
	}
	public Comment updateComment(Comment comment) {
		if(messageService.get(comment.getMessageid()) != null) {
			Map<Integer, Comment> comments = messageService.get(comment.getMessageid()).getComments();
			if(comments.containsKey(comment.getCommentid())) {
				comments.put(comment.getCommentid() , comment);
				return comment;
			}
		}
		return null;
	}
	public Comment removeComment(int commentid, int messageid) {
		if(messageService.get(messageid)!= null) {
			return messageService.get(messageid).getComments().remove(commentid);
		}
		return null;
	}
}
