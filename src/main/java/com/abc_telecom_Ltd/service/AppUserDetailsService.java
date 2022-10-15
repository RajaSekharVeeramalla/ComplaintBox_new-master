package com.abc_telecom_Ltd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abc_telecom_Ltd.entity.AppUser;
import com.abc_telecom_Ltd.model.CustomerUserDetails;
import com.abc_telecom_Ltd.repository.AppUserDetailRepository;



@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserDetailRepository appUserDetailRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = appUserDetailRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("AppUser Not Found");
		}
		/*
		we must return the object of UserDetails: since it is an interface, thus we have to create 
		a class CustomeUserDetails which implements UserDetails.
		We will instantiate CustomerUserDetails and pass the AppUser object to it
		*/
		return new CustomerUserDetails(user);
	}

}
