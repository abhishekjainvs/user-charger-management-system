package project.spring.userchargermanagementsystem.bean;

import java.io.Serializable;

public class AuthenticationOutputBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String jwttoken;

	public AuthenticationOutputBean(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
