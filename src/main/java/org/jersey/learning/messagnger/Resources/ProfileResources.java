package org.jersey.learning.messagnger.Resources;

import java.util.List;

import javax.ws.rs.BeanParam;
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

import org.jersey.learning.messagnger.Bean.FilterBeanParam;
import org.jersey.learning.messagnger.Error.UserError;
import org.jersey.learning.messagnger.Model.*;
import org.jersey.learning.messagnger.Service.ProfileServices;
@Path("/profiles")
public class ProfileResources {
	
	ProfileServices profileService = new ProfileServices();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles(@BeanParam FilterBeanParam filterParam){
		if(filterParam.getYear() > 0)
			return profileService.getAllProfile(filterParam.getYear());
		if(filterParam.getStart() >= 0 && filterParam.getSize() > 0)
			return profileService.getAllProfile(filterParam.getStart() ,filterParam.getSize());
		return profileService.getAllProfile();
	}
	
	@GET
	@Path("{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("messageid") String messageid) {
		Profile p = null;
		try {
			p = profileService.getProfile(Integer.parseInt(messageid));
			if(p == null)
				p = new Profile(UserError.getNotFoundNumber(),UserError.getFirstNameNotFound(),UserError.getSecondNameNotFound(),UserError.getProfileNameNotFound());
		}catch(NumberFormatException e)
		{
			p = new Profile(UserError.getNotFoundNumber(),UserError.getSystemAuthor(),UserError.getNumberFormExceptionErrorMessage(),UserError.getNumberFormExceptionErrorMessage());
		}finally {
			return p;
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,@FormParam("profilename") String profilename) {
		return profileService.addProfile(new Profile(1,firstname,lastname,profilename));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@FormParam("profileid") String profileid, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname, @FormParam("profilename") String profilename) {
		Profile p = new Profile(Integer.parseInt(profileid),firstname,lastname,profilename);	
		p = profileService.updateProfile(p);
		if(p == null)
			p =  new Profile(UserError.getNotFoundNumber(),UserError.getFirstNameNotFound(),UserError.getSecondNameNotFound(),UserError.getProfileNameNotFound());
		return p;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile removeDelete(@FormParam("profileid") String profileid) {
		Profile p = profileService.removeProfile(Integer.parseInt(profileid));
		if(p == null)
			p =  new Profile(UserError.getNotFoundNumber(),UserError.getFirstNameNotFound(),UserError.getSecondNameNotFound(),UserError.getProfileNameNotFound());
		return p;
	}
}
