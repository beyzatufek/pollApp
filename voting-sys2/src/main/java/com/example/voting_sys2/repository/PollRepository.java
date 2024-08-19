package com.example.voting_sys2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voting_sys2.entity.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll,Integer>{

	void deleteById(Poll poll);

}
