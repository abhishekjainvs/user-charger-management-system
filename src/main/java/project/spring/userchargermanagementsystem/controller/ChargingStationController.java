package project.spring.userchargermanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.spring.userchargermanagementsystem.bean.ChargingStationInputBean;
import project.spring.userchargermanagementsystem.bean.ChargingStationOutputBean;
import project.spring.userchargermanagementsystem.model.entity.ChargingStation;
import project.spring.userchargermanagementsystem.service.ChargingStationService;

@RestController
public class ChargingStationController {
	
	@Autowired
	private ChargingStationService chargingStationService;

	@Secured("ROLE_HOST")
	@RequestMapping(value = "/addChargingStation", method = RequestMethod.POST)
	public ResponseEntity<?> addChargingStation(@RequestBody ChargingStationInputBean chargingStationBean,
			Authentication authentication) throws Exception {
		if(ObjectUtils.isEmpty(chargingStationBean.getType())){
			throw new Exception("type can't be null");
		}
		if(ObjectUtils.isEmpty(chargingStationBean.getLocation())){
			throw new Exception("location can't be null");
		}
		
		ChargingStation chargingStation = chargingStationService.addChargingStation(authentication.getName(),
				chargingStationBean.getType(), chargingStationBean.getLocation());
		
		ChargingStationOutputBean chargingStationOutputBean = new ChargingStationOutputBean(
				chargingStation.getType(), chargingStation.getLocation());
		return ResponseEntity.ok(chargingStationOutputBean);
	}

	@Secured("ROLE_HOST")
	@RequestMapping(value = "/getChargingStationsForUser", method = RequestMethod.GET)
	public ResponseEntity<?> getChargingStationsForUser(Authentication authentication) throws Exception {

		List<ChargingStation> chargingStations = chargingStationService.getChargingStationsForUser(
				authentication.getName());
		
		List<ChargingStationOutputBean> chargingStationOutputBeans = new ArrayList<>();
		for(ChargingStation chargingStation : chargingStations){
			ChargingStationOutputBean chargingStationOutputBean = new ChargingStationOutputBean(
					chargingStation.getType(), chargingStation.getLocation());
			chargingStationOutputBeans.add(chargingStationOutputBean);
		}
		return ResponseEntity.ok(chargingStationOutputBeans);
	}
}
