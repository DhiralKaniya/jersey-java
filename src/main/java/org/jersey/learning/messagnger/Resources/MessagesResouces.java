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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.jersey.learning.messagnger.Service.MessageService;
import org.jersey.learning.messagnger.Model.Message;
import org.jersey.learning.messagnger.Error.UserError;

@Path("/messages")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public class MessagesResouces {
	MessageService messageService = new MessageService(); 
	
	@GET
	public List<Message> getMessages(@Context UriInfo info) {
		int year=-1,size=-1,start = -1;
		try {
			year = Integer.parseInt(info.getQueryParameters().getFirst("year"));
			
		}catch(NumberFormatException e) {
			year = -1;	
		}
		try {
			start = Integer.parseInt(info.getQueryParameters().getFirst("start"));
			size= Integer.parseInt(info.getQueryParameters().getFirst("size"));
		}catch(NumberFormatException e) {
			size = -1;
			start = -2;
		}
		
		List<Message> messages = new ArrayList<Message>();
		if(year > 0) {
			messages = messageService.getAllMessages(year);
			if(messages.size() == 0) {
				messages.add(new Message(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException()));
			}
			return messages;
		}
		if(start > -1 && size > 0) {
			 messages =  messageService.getAllMessages(start, size);
			 if(messages.size() == 0) {
				messages.add(new Message(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException()));
			}
			 return messages;
		}
		return  messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID") int messageid) {
		Message m = null;
		try {
			m = messageService.getMessage(messageid);
			if(m==null)
				m = new Message(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException());
		}catch(NullPointerException e) {
			System.out.println(e.getLocalizedMessage()+" + Null");
			m =new Message(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getStringNotAllowed());
		}finally{
			return m;
		}
	}
	
	@POST
	public Message addMessage(@FormParam("author") String author, 
			@FormParam("message") String message) {
		Message addMessage = messageService.addMessage(new Message(1,author,message));
		return addMessage;
	}
	
	@PUT
	public Message updateMessage(@FormParam("message") String message,
			@FormParam("author") String author,
			@FormParam("id") String id
			) {
		Message updateMessage = messageService.updateMessage(new Message(id,author,message));
		if(updateMessage == null) {
			updateMessage = new Message(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException());
		}
		return updateMessage;
	}
	@DELETE
	public Message deleteMessafe(@FormParam("id") String id) {
		Message deleteMessage = messageService.removeMessage(Integer.parseInt(id));
		if(deleteMessage == null)
			deleteMessage = new Message(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getDataNotFoundException());
		return deleteMessage;
	}
}
