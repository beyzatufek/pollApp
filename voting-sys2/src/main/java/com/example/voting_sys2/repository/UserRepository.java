package com.example.voting_sys2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voting_sys2.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

	 User findByUsername(String username);
	 
	 Optional<User> findByEmail(String email);

	 User findByEmailAndPassword(String email,String password);
	void deleteById(int id);

	User getById(int id);

	


	


	
	
}
