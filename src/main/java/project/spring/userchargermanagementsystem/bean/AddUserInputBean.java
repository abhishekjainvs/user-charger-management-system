package project.spring.userchargermanagementsystem.bean;

import java.io.Serializable;
import java.util.List;

import project.spring.userchargermanagementsystem.config.Role;

public class AddUserInputBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String phone;
	private String fullname;
	private String address;
	private List<Role> roles;
	private String password;
	
	public String getPhone() {
		return phone;
	}
	public String getFullname() {
		return fullname;
	}
	public String getAddress() {
		return address;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public String getPassword() {
		return password;
	}
}
