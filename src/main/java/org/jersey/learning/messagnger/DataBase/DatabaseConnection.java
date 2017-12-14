package org.jersey.learning.messagnger.DataBase;

import java.util.HashMap;
import java.util.Map;

import org.jersey.learning.messagnger.Model.*;

public class DatabaseConnection {
	public static HashMap<Integer, Message> messages = new HashMap<Integer, Message>();
	public static HashMap<Integer, Profile> profiles = new HashMap<Integer, Profile>();
	
	public static Map<Integer, Message> getMessages(){
		return messages;
	}
	
	public static Map<Integer, Profile> getProfiles(){
		return profiles;
	}
}
