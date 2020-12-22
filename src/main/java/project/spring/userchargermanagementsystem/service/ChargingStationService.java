package project.spring.userchargermanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.userchargermanagementsystem.model.entity.ChargingStation;
import project.spring.userchargermanagementsystem.model.repository.ChargingStationRepository;
import project.spring.userchargermanagementsystem.model.repository.UserRepository;

@Service
public class ChargingStationService {

	@Autowired
	ChargingStationRepository chargingStationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public ChargingStation addChargingStation(String phone, String type, String location) {
		ChargingStation chargingStation = new ChargingStation(type, location, phone);
		return chargingStationRepository.save(chargingStation);
	}

	public List<ChargingStation> getChargingStationsForUser(String phone) {
		List<ChargingStation> chargingStations = chargingStationRepository.findByUserId(phone);
		return chargingStations;
	}

}
