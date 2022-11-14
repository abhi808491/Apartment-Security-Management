package com.cg.aps.dto;

import lombok.Data;

@Data
public class RegisterUserRequest {
	
	private long id;
	private String firstName;
	private String LastName;
	private String password;
	private String emailId;
	public String getFirstName() {
		return firstName;
	}
	

}
