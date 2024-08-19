package com.example.voting_sys2.config;

import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests((authorize) -> authorize
		/*
		 * .requestMatchers("/users/new**").permitAll()
		 * .requestMatchers("/").permitAll() .requestMatchers("/profile**").permitAll()
		 * .requestMatchers("/users").permitAll()
		 * .requestMatchers("/poll/new**").permitAll()
		 */
				.anyRequest().permitAll()
				).formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/")
						.permitAll())
				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll())

		;
		return http.build();
	}

	// http.formLogin(Customizer.withDefaults());
	/*
	 * formLogin(form -> form.defaultSuccessUrl("/") .loginPage("/users/login")
	 * .failureUrl("/users/login?error=true")).
	 */

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.builder().username("admin").password("{noop}password").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(admin);
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);

		return provider;
	}

}