package com.abc_telecom_Ltd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.abc_telecom_Ltd.filter.JWTFilter;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecutiryConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private JWTFilter jwtFilter;

	// Authentication
	@Bean
	AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
        = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
//		.antMatchers("/customer/**").hasAnyAuthority("CUSTOMER", "ADMIN")
//		.antMatchers("/engineer/**").hasAnyAuthority("ENGINEER", "ADMIN")
//		.antMatchers("/manager/**").hasAnyAuthority("MANAGER", "ADMIN")
//		.antMatchers("/admin/**").hasAuthority("ADMIN")
//		.antMatchers("/authenticate").permitAll()
//		.antMatchers("/register").permitAll()
//		 .antMatchers("/v2/api-docs",
//                 "/configuration/ui",
//                 "/swagger-resources/**",
//                 "/configuration/security",
//                 "/swagger-ui.html",
//                 "/webjars/**")
//         .permitAll()
//		.anyRequest()
//        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}


}
