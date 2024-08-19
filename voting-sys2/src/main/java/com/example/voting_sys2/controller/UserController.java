package com.example.voting_sys2.controller;

import java.security.Principal;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.voting_sys2.dto.UserRegistrationDto;
import com.example.voting_sys2.entity.User;
import com.example.voting_sys2.repository.UserRepository;
import com.example.voting_sys2.service.UserService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class UserController {

	@Autowired(required = true)
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	

	public UserController(UserRepository userRepository, UserService userService) {
		super();
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/user/profile")
	public String viewProfile(Principal principal, Model model,@PathVariable int id) {
        
        String username = principal.getName();
        
        
        User user = userService.getUserById(id);

        
        model.addAttribute("user", user);

        return "profile";
    }

	@GetMapping("/users/new") public String createUserForm(Model model) {
	  User user = new User();
	  model.addAttribute("user", user); 
	  return "create_user";
	  
	  }

	@PostMapping("/users/new")
	public String saveUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		
		userService.saveUser(registrationDto);
		return "redirect:/login";
	}

	@GetMapping("/users/edit/{id}")
	public String editUserForm(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_user";
	}

	
	@PostMapping("/users/{id}") 
	public String updateUser(@PathVariable int id,@ModelAttribute("user") User user, Model model) {
	  User existingUser =
	  userService.getUserById(id); existingUser.setId(id);
	  existingUser.setFirstName(user.getFirstName());
	  existingUser.setLastName(user.getLastName());
	  existingUser.setEmail(user.getEmail());
	  userService.updateUser(existingUser); 
	  return "redirect:/users"; }


	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) {
	    userService.deleteUserById(id);
	    return "redirect:/users";
	}

	@GetMapping("/login")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user_login";
	}

	@PostMapping("/users/login")
	public String loginUser(@ModelAttribute("user") User user) {
		String email = user.getEmail();
		Optional<User> userdata = userRepository.findByEmail(email);
		if (user.getPassword().equals(userdata.get().getPassword())) {
			return "redirect:/users";
		} else {
			return "user_login";
		}
	}
	


}
