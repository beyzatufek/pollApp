package com.example.voting_sys2.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voting_sys2.entity.Poll;
import com.example.voting_sys2.repository.PollRepository;



@Service
public class PollService {
	
	@Autowired
	private PollRepository pollRepository;
	
	
	public List<Poll> getAllPolls(){
		
		return pollRepository.findAll();
	}
	
	public Poll getPollById(int id) {
		
		return pollRepository.findById(id).orElseThrow();
	}
	

	public void createPoll(Poll poll) {
		pollRepository.save(poll);
	}
	
	public void deletePollById(int id) {
		pollRepository.deleteById(id);
	}

	public Poll updatePoll(Poll poll) {
		return pollRepository.save(poll);
	}

	public Poll savePoll(Poll poll) {
		return pollRepository.save(poll);
		
	}
	
}

