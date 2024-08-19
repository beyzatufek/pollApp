package com.example.voting_sys2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.voting_sys2.entity.User;
import com.example.voting_sys2.entity.Option;
import com.example.voting_sys2.entity.Vote;
import com.example.voting_sys2.repository.OptionRepository;
import com.example.voting_sys2.repository.UserRepository;
import com.example.voting_sys2.repository.VoteRepository;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void vote(String userId, Integer optionId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Option option = optionRepository.findById(optionId).orElseThrow(() -> new RuntimeException("Option not found"));

        if (voteRepository.existsByUserAndOption(user, option)) {
            throw new RuntimeException("User has already voted for this option.");
        }

        Vote vote = new Vote();
        vote.setUser(user);
        vote.setOption(option);
        voteRepository.save(vote);
    }
}