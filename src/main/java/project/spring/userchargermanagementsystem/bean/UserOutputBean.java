package project.spring.userchargermanagementsystem.bean;

import java.io.Serializable;
import java.util.List;

import project.spring.userchargermanagementsystem.config.Role;
import project.spring.userchargermanagementsystem.model.entity.User;

public class UserOutputBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String phone;
	private String fullname;
	private String address;
	private List<Role> roles;
	private String password;
	
	public UserOutputBean(User user){
		this.phone = user.getPhone();
		this.fullname = user.getFullname();
		this.address = user.getAddress();
		this.roles = user.getRoles();
		this.password = user.getPassword();
	}
	
	public String getUsername() {
		return fullname;
	}
	
	public void setUsername(String username) {
		this.fullname = username;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
