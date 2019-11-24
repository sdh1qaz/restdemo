package com.dhsu.restdemo;

import java.io.Serializable;

public class RequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2042944868904425351L;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
