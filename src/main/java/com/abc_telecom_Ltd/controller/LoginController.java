package com.abc_telecom_Ltd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc_telecom_Ltd.model.JWTRequest;
import com.abc_telecom_Ltd.model.JWTResponse;
import com.abc_telecom_Ltd.utility.JWTUtility;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JWTUtility jwtUtility;


	@PostMapping("/authenticate")
	public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
		// using try catch: if authentication fails throw exception
		try {

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		// if authentication successful
		// get user details from userDetaislService
		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		// generate token
		final String token = jwtUtility.generateToken(userDetails);
		return new JWTResponse(token);

	}

}
