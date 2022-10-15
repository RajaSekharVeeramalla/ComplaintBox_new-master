package com.abc_telecom_Ltd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc_telecom_Ltd.entity.AppUser;
import com.abc_telecom_Ltd.repository.AppUserDetailRepository;

@RestController
public class RegisterController {
	
	@Autowired
	private AppUserDetailRepository aUserDetailRepository;
	
	@Autowired
	private BCryptPasswordEncoder eBCryptPasswordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<AppUser> registerAppUser(@RequestBody AppUser appUser){
		AppUser user = 	new AppUser();
		user.setUsername(appUser.getPassword());
		String password = eBCryptPasswordEncoder.encode(appUser.getPassword());
		System.err.println("Password: "+ password);
		user.setPassword(password);
		user.setRole(appUser.getRole());
		AppUser savedUser = aUserDetailRepository.save(appUser);
		return new ResponseEntity<AppUser>(savedUser, HttpStatus.OK);
	}

}
