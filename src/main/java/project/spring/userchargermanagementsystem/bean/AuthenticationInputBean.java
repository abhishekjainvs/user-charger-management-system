package project.spring.userchargermanagementsystem.bean;

import java.io.Serializable;

public class AuthenticationInputBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String phone;
	private String password;

	public String getPhone() {
		return this.phone;
	}

	public String getPassword() {
		return this.password;
	}
}