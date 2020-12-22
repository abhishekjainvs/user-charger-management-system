package project.spring.userchargermanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.spring.userchargermanagementsystem.bean.UpdateUserInputBean;
import project.spring.userchargermanagementsystem.bean.UserOutputBean;
import project.spring.userchargermanagementsystem.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/updateUserInformation", method = RequestMethod.POST)
	public ResponseEntity<?> updateUserInformation(@RequestBody UpdateUserInputBean userBean, Authentication authentication) throws Exception {
		if(ObjectUtils.isEmpty(userBean.getAddress())){
			throw new Exception("Address can't be null");
		}
		UserOutputBean userOutputBean = new UserOutputBean(userService.updateUserInformation(authentication.getName(), userBean.getAddress()));
		return ResponseEntity.ok(userOutputBean);
	}

}
