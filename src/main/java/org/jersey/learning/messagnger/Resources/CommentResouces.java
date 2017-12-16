package org.jersey.learning.messagnger.Resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jersey.learning.messagnger.Model.Comment;
import org.jersey.learning.messagnger.Service.CommentServices;

@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResouces {
	CommentServices commentService = new CommentServices();
	@GET
	public List<Comment> getComments(@PathParam("messageid") int messageid){
		return new ArrayList<Comment>(commentService.getComments(messageid));
	}
	
	@POST
	public Comment addComment(@PathParam("messageid") int messageid, @PathParam("comment") String comment, @PathParam("author") String author) {
		return commentService.addComment(new Comment(messageid,comment,author));
	}
	
	@PUT
	public Comment updateComment(@PathParam("messageid") int messageid, @PathParam("commentid") int commentid,@PathParam("comment") String comment,@PathParam("author") String author) {
		return commentService.updateComment(new Comment(commentid, messageid, comment, author));
	}
	
	@DELETE
	public Comment removeComment(@PathParam("messageid") int messageid, @PathParam("commentid") int commentid) {
		return commentService.removeComment(commentid, messageid);
	}
}
