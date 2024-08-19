package com.example.voting_sys2.controller;

import java.util.ArrayList;

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
import com.example.voting_sys2.service.AdminService;
import com.example.voting_sys2.service.OptionService;
import com.example.voting_sys2.service.PollService;

@Controller
public class AdminController {
	
	/*
	 * @Autowired private PollService pollService;
	 * 
	 * @Autowired private OptionService optionService;
	 * 
	 * @Autowired private UserService userService;
	 * 
	 * @Autowired private AdminService adminService;
	 * 
	 * 
	 * @PostMapping("/users/{id}") public String updateUser(@PathVariable int id,
	 * 
	 * @ModelAttribute("user") User user, Model model) {
	 * 
	 * // get user from database by id User existingUser =
	 * userService.getUserById(id); existingUser.setId(id);
	 * existingUser.setFirstName(user.getFirstName());
	 * existingUser.setLastName(user.getLastName());
	 * existingUser.setEmail(user.getEmail());
	 * 
	 * // save updated user object userService.updateUser(existingUser); return
	 * "redirect:/users"; }
	 * 
	 * @GetMapping("/users/{id}") public String deleteUser(@PathVariable int id) {
	 * userService.deleteUserById(id); return "redirect:/users"; }
	 * 
	 * 
	 * @PostMapping("/poll") public String createPoll(@ModelAttribute PollData
	 * pollData) { Poll poll = new Poll(); poll.setQuestion(pollData.getQuestion());
	 * 
	 * List<Option> optionList = new ArrayList<>(); for(String optionStr:
	 * pollData.getOptions()) { Option option = new Option();
	 * option.setChoice_text(optionStr); option.setPoll(poll);
	 * optionList.add(option); }
	 * 
	 * poll.setOptionList(optionList); pollService.createPoll(poll);
	 * 
	 * return "redirect:/"; }
	 * 
	 * 
	 * @PostMapping("/vote") public String createVote(int optionId) {
	 * optionService.createVote(optionId);
	 * 
	 * return "redirect:/";
	 * 
	 * }
	 * 
	 * @GetMapping("/poll/{id}/results") public String pollResults(@PathVariable int
	 * id, Model model) { model.addAttribute("poll", pollService.getPollById(id));
	 * return "results"; }
	 */
}
