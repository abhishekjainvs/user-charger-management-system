package project.spring.userchargermanagementsystem.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.spring.userchargermanagementsystem.config.Role;
import project.spring.userchargermanagementsystem.model.entity.User;
import project.spring.userchargermanagementsystem.model.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findById(phone);
		
		if(!optionalUser.isPresent()){
			throw new UsernameNotFoundException("User not found with phone: " + phone);
		} else{
			User user = optionalUser.get();
			return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), getAuthorities(user));
		}
	}

	private Set<GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
		return authorities;
	}

	public User addUser(User user) throws Exception {
		if(userAlreadyExists(user.getPhone())){
			throw new Exception("User already exists with phone: " + user.getPhone());
		}
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	private boolean userAlreadyExists(String phone) {
		Optional<User> optionalUser = userRepository.findById(phone);
		if(optionalUser.isPresent()){
			return true;
		}
		return false;
	}

	public User updateUserInformation(String phone, String address) {
		Optional<User> optionalUser = userRepository.findById(phone);

		if(!optionalUser.isPresent()){
			throw new UsernameNotFoundException("User not found with phone: " + phone);
		} else{
			User user = optionalUser.get();
			user.setAddress(address);
			return userRepository.save(user);
		}
	}
}
