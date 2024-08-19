package com.example.voting_sys2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voting_sys2.entity.Poll;
import com.example.voting_sys2.entity.User;
import com.example.voting_sys2.repository.AdminRepository;
import com.example.voting_sys2.repository.PollRepository;
import com.example.voting_sys2.repository.UserRepository;


@Service
public class AdminService {
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PollRepository pollRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	
	
	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	public void createPoll(Poll poll) {
		pollRepository.save(poll);
	}

	public void createUser(User user) {
		userRepository.save(user);
	}
	
	/*
	 * public List<Poll> getAllPolls(){
	 * 
	 * return pollRepository.findAll(); }
	 */

	public User getUserById(String id) {
		return userRepository.findById(id).get();
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUserById(String id) {
		userRepository.deleteById(id);	
	}
	

	public Poll getPollById(int id) {
		
		return pollRepository.findById(id).orElseThrow();
	}

	public void deletePollById(int id) {
		pollRepository.deleteById(id);
	}
	
}
