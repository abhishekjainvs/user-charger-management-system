package project.spring.userchargermanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.spring.userchargermanagementsystem.bean.AddUserInputBean;
import project.spring.userchargermanagementsystem.bean.UserOutputBean;
import project.spring.userchargermanagementsystem.bean.AuthenticationInputBean;
import project.spring.userchargermanagementsystem.bean.AuthenticationOutputBean;
import project.spring.userchargermanagementsystem.config.JwtTokenUtil;
import project.spring.userchargermanagementsystem.model.entity.User;
import project.spring.userchargermanagementsystem.service.UserService;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationInputBean authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getPhone(), authenticationRequest.getPassword());

		UserDetails userDetails = userService
				.loadUserByUsername(authenticationRequest.getPhone());

		final String token = jwtTokenUtil.generateToken(userDetails.getUsername(), userDetails.getAuthorities());

		return ResponseEntity.ok(new AuthenticationOutputBean(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody AddUserInputBean userBean) throws Exception {
		if(ObjectUtils.isEmpty(userBean.getPhone())){
			throw new Exception("phone can't be null");
		}
		if(ObjectUtils.isEmpty(userBean.getPassword())){
			throw new Exception("password can't be null");
		}
		if(userBean.getRoles() == null || userBean.getRoles().isEmpty()){
			throw new Exception("role can't be null");
		}
		User user = new User(userBean.getPhone(), userBean.getFullname(), userBean.getAddress(),
				userBean.getRoles(), userBean.getPassword());
		UserOutputBean userOutputBean = new UserOutputBean(userService.addUser(user));
		return ResponseEntity.ok(userOutputBean);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}