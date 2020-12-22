package project.spring.userchargermanagementsystem.bean;

import java.io.Serializable;

public class ChargingStationInputBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String location;
	
	public String getType() {
		return type;
	}

	public String getLocation() {
		return location;
	}
}
