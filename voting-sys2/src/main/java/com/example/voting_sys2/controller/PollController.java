package com.example.voting_sys2.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.voting_sys2.entity.Option;
import com.example.voting_sys2.entity.Poll;
import com.example.voting_sys2.entity.PollData;
import com.example.voting_sys2.entity.User;
import com.example.voting_sys2.service.OptionService;
import com.example.voting_sys2.service.PollService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PollController {
	@Autowired
	private PollService pollService;

	@Autowired
	private OptionService optionService;
	
	
	
	@GetMapping("/")
	public String homePage(Model model ) {
		model.addAttribute("polls", pollService.getAllPolls());
		return "index";
	}

	
	  @GetMapping("/poll/new") public String listPollForm(Model model) {
	   return "create_poll"; }
	 

	@PostMapping("/poll/new")
	public String createPoll(@ModelAttribute PollData pollData) {
		Poll poll = new Poll();
		poll.setQuestion(pollData.getQuestion());

		List<Option> optionList = new ArrayList<>();
		for (String optionStr : pollData.getOptions()) {
			Option option = new Option();
			option.setChoice_text(optionStr);
			option.setPoll(poll);
			optionList.add(option);
		}

		poll.setOptionList(optionList);
		pollService.createPoll(poll);

		return "redirect:/";
	}
	
	
	@GetMapping("/poll/edit/{id}")
	public String editPoll(@PathVariable int id, Model model) {
		model.addAttribute("poll", pollService.getPollById(id));
		return "edit_poll";
	}
	
	@PostMapping("/poll/edit/{id}")
	public String updatePoll(@PathVariable int id, @ModelAttribute("poll") Poll poll, Model model) {
		Poll existingPoll = pollService.getPollById(id);
		existingPoll.setId(id);
		existingPoll.setQuestion(poll.getQuestion());
		existingPoll.setOptionList(poll.getOptionList());
		pollService.updatePoll(existingPoll);

		return "redirect:/";
	}
 
	

	@PostMapping("/vote/{id}")
	public String createVote(int optionId) {
		optionService.createVote(optionId);

		return "redirect:/";

	}

	@GetMapping("/poll/{id}/results")
	public String pollResults(@PathVariable int id, Model model) {
		model.addAttribute("poll", pollService.getPollById(id));
	
		return "results";
	}


		@GetMapping("/poll/{id}/delete")
		public String deletePollById(@PathVariable int id) {
		pollService.deletePollById(id);
		return "redirect:/";
		}



}
