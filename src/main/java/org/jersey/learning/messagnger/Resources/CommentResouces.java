package org.jersey.learning.messagnger.Resources;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.message.internal.MediaTypes;
import org.jersey.learning.messagnger.Error.UserError;
import org.jersey.learning.messagnger.Model.Comment;
import org.jersey.learning.messagnger.Model.Message;
import org.jersey.learning.messagnger.Model.c1;
import org.jersey.learning.messagnger.Service.CommentServices;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResouces {
	CommentServices commentService = new CommentServices();
	
	@GET
	public List<c1> getComments(@PathParam("messageid") int messageid) {
		//List<Comment> comments =  commentService.getComments(messageid);
		//System.out.println(comments.size());
		List<c1> m = new ArrayList<>();
		m.add(new c1(messageid));
		System.out.println(m.size());
		return m;
	}
	/*@GET
	public List<Comment> getComments(@PathParam("messageid") int messageid){
		List<Comment> comments = new ArrayList<Comment>();
		try {
			comments = commentService.getComments(messageid);
			if(comments.size() == 0)
				comments.add(new Comment(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException()));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			comments.add(new Comment(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException()));
		}
		return comments;
	}
	
	@POST
	public Comment addComment(@FormParam("messageid") int messageid, @FormParam("comment") String comment, @FormParam("author") String author) {
		return commentService.addComment(new Comment(messageid,comment,author));
	}
	
	@PUT
	public Comment updateComment(@FormParam("messageid") int messageid, @FormParam("commentid") int commentid,@FormParam("comment") String comment,@FormParam("author") String author) {
		return commentService.updateComment(new Comment(commentid, messageid, comment, author));
	}
	
	@DELETE
	public Comment removeComment(@FormParam("messageid") int messageid, @FormParam("commentid") int commentid) {
		return commentService.removeComment(commentid, messageid);
	}*/
}
