package com.example.voting_sys2.service;
 
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.voting_sys2.dto.UserRegistrationDto;
import com.example.voting_sys2.entity.Role;
import com.example.voting_sys2.entity.User;
import com.example.voting_sys2.entity.UserPrincipal;
import com.example.voting_sys2.repository.RoleRepository;
import com.example.voting_sys2.repository.UserRepository;
 
@Service
@Transactional
public class UserService {
 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
 
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
 
	public List<User> getAllUsers() {
 
		return userRepository.findAll();
	}
 
	public User updateUser(User user) {
		return userRepository.save(user);
	}
 
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
 
	public User getUserById(int id) {
 
		return userRepository.getById(id);
	}
 
	public User saveUser(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				registrationDto.getUsername(), registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
 
		return userRepository.save(user);
	}
	
	private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
	
	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { User user =
	 * userRepository.findByUsername(username); if (user == null) {
	 * System.out.println("User Not Found"); throw new
	 * UsernameNotFoundException("user not found"); }
	 * 
	 * return new UserPrincipal(user); }
	 */

 

}