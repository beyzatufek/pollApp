package com.example.voting_sys2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.voting_sys2.entity.Role;
import com.example.voting_sys2.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	  Optional<Role> findByName(RoleName roleName);
}
