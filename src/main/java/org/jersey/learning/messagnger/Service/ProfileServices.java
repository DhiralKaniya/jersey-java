package org.jersey.learning.messagnger.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.jersey.learning.messagnger.DataBase.DatabaseConnection;
import org.jersey.learning.messagnger.Model.*;
public class ProfileServices {
	private Map<Integer, Profile> profiles = DatabaseConnection.getProfiles();
	public ProfileServices() {
		/*Profile p1 = new Profile(1,"Dhiral","Kaniya","the_king");
		Profile p2 = new Profile(2,"Hello","World","hello_world");
		addProfile(p1);
		addProfile(p2);*/
		
	}
	public List<Profile> getAllProfile(){
		return new ArrayList<>(profiles.values());
	}
	public List<Profile> getAllProfile(int year){
		ArrayList<Profile> profileYear = new ArrayList<Profile>();
		Calendar cal = Calendar.getInstance();
		for(Map.Entry<Integer, Profile> m : profiles.entrySet()) {
			cal.setTime(m.getValue().getCreated());
			if(year == cal.get(Calendar.YEAR)) {
				profileYear.add(m.getValue());
			}
		}
		return profileYear;
	}
	public List<Profile> getAllProfile(int start, int size){
		if(size + start <= profiles.size()) {
			ArrayList<Profile> pagingArrayList = new ArrayList<Profile>(profiles.values());
			return pagingArrayList.subList(start, start + size);
		}
		return new ArrayList<Profile>();
	}
	public Profile addProfile(Profile p) {
		p.setId(profiles.size() + 1);
		profiles.put(p.getId(), p);
		return p;
	}
	public Profile updateProfile(Profile p) {
		if(profiles.containsKey(p.getId())) {
			profiles.put(p.getId(), p);
			return p;
		}else {
			return null;
		}
	}
	public Profile removeProfile(int id) {
		if(id <= 0)
			return null;
		return profiles.remove(id);
	}
	public Profile getProfile(int id) {
		if(id <= 0) 
			return null;
		return profiles.get(id);
	}
	
}
