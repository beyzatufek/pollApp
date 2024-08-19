package com.example.voting_sys2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.voting_sys2.entity.User;
import com.example.voting_sys2.entity.Vote;
import com.example.voting_sys2.service.UserService;
import com.example.voting_sys2.service.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;
    
    @Autowired
    private UserService userService;

	/*
	 * @PostMapping public ResponseEntity<String> vote(@RequestParam String
	 * userId, @RequestParam Integer optionId) { try { voteService.vote(userId,
	 * optionId); return ResponseEntity.ok("Vote recorded successfully."); } catch
	 * (RuntimeException e) { return
	 * ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage()); } }
	 */
    

    
    @PostMapping
    public ResponseEntity<String> vote(@RequestParam Long optionId) {
        return ResponseEntity.ok("Vote recorded successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVote(@PathVariable int id, Model model) {
    	model.addAttribute("user", userService.getUserById(id));
        return ResponseEntity.ok(new Vote());
    }
    
    
}