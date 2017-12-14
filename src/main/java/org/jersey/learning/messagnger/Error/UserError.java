package org.jersey.learning.messagnger.Error;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserError {

	public static String getErrorMessage() {
		return "Something goes wrong";
	}
	public static String getDataNotFoundException() {
		return "Data Not Found Exception";
	}
	public static String getNumberFormExceptionErrorMessage() {
		return "Number Format Exception";
	}
	public static String getSystemAuthor() {
		return "System Author";
	}
	public static String getStringNotAllowed() {
		return "String Input Not allowed";
	}
	public static int getNotFoundNumber() {
		return 404;
	}
	public static String getFirstNameNotFound() {
		return "First Name not founded";
	}
	public static String getSecondNameNotFound() {
		return "Second Name not Founded";
	}
	public static String getProfileNameNotFound() {
		return "ProfileName not Founded";
	}
	
}
