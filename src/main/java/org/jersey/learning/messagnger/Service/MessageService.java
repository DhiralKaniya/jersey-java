package org.jersey.learning.messagnger.Service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.jersey.learning.messagnger.DataBase.DatabaseConnection;
import org.jersey.learning.messagnger.Model.Message;

public class MessageService {
	private Map<Integer, Message> messages = DatabaseConnection.getMessages();
	public MessageService() {
	}
	
	public List<Message> getAllMessages(){	
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessages(int year){
		Calendar calender = Calendar.getInstance();
		ArrayList<Message> messageFromYear = new ArrayList<Message>();
		for(Map.Entry<Integer, Message> m : messages.entrySet()) {
			calender.setTime(m.getValue().getCreatedDate());
			if(year == calender.get(Calendar.YEAR))
				messageFromYear.add(m.getValue());
		}
		return messageFromYear;
	}
	public List<Message> getAllMessages(int start,int size){
		if(start + size <= messages.size()) {
			ArrayList<Message> messageFromIndex = new ArrayList<Message>(messages.values());
			return messageFromIndex.subList(start, start + size);
		}else {
			return new ArrayList<Message>();
		}
	}
	public Message getMessage(int id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message m) {
		m.setId(messages.size() + 1);
		messages.put(m.getId(), m);
		return m;
	}
	
	public Message removeMessage(int id) {
		if(id<0)
			return null;
		return messages.remove(id);
	}
	
	public Message updateMessage(Message m) {
		if(m.getId()<0)
			return m;
		if(messages.containsKey(m.getId())) {
			messages.put(m.getId(), m);
			return messages.get(m.getId());
		}
		else {
			return null;
		}
	}
}
