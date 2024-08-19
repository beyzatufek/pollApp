package com.example.voting_sys2.entity;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PollData {
	
	private String question;
	
	private List<String> options;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public List<String> getOptions() {
		  if (options == null) {
	            options = new ArrayList<>();
	        }
		return options;
	}
	
	

}