package com.example.voting_sys2.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voting_sys2.entity.Option;
import com.example.voting_sys2.repository.OptionRepository;


@Service
public class OptionService {
	
	
	@Autowired
	private OptionRepository optionRepository;
	
	
	public List<Option> getAllOptions(){
		return optionRepository.findAll();
	}

	public void createVote(int optionId) {
		Option option = optionRepository.findById(optionId).orElseThrow();
		option.setVotes(option.getVotes()+1);
		optionRepository.save(option);
	}
}
