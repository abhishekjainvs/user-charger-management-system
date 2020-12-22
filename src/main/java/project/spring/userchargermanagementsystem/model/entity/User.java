package project.spring.userchargermanagementsystem.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;

import project.spring.userchargermanagementsystem.config.Role;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String phone;
	
	private String fullname;
	private String address;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(nullable = false)
	@Enumerated(value=EnumType.STRING)
	private List<Role> roles = new ArrayList<Role>();
	
	@Column(nullable = false)
	private String password;
	
	public User() {
	}
	
	public User(String phone, String fullname, String address, List<Role> roles, String password) {
		this.phone = phone;
		this.fullname = fullname;
		this.address = address;
		this.roles = roles;
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public void setRoles(List<Role> role) {
		this.roles = role;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [phone=" + phone + ", fullname=" + fullname + ", roles=" + roles + "]";
	}
}
