package project.spring.userchargermanagementsystem.bean;

import java.io.Serializable;

public class ChargingStationOutputBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String location;

	public ChargingStationOutputBean(String type, String location) {
		this.type = type;
		this.location = location;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}	
}
