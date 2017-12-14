package org.jersey.learning.messagnger.Bean;

import javax.ws.rs.QueryParam;

public class FilterBeanParam {
	private @QueryParam("year") int year;
	private @QueryParam("size") int size;
	private @QueryParam("start") int start;
	public FilterBeanParam() {
		this.year = -1;
		this.size = -1;
		this.start = -1;
	}
	
	public FilterBeanParam(int year, int size, int start) {
		super();
		this.year = year;
		this.size = size;
		this.start = start;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
	
}
