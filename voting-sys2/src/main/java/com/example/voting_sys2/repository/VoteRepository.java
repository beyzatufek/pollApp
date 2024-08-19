package com.example.voting_sys2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.voting_sys2.entity.Vote;
import com.example.voting_sys2.entity.User;
import com.example.voting_sys2.entity.Option;

public interface VoteRepository extends JpaRepository<Vote, Long> {
	
    boolean existsByUserAndOption(User user, Option option);
    
}