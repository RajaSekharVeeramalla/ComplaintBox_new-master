package com.abc_telecom_Ltd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long AppUser_id;
	private String username;
	private String password;
	private String role; //ADMIN, CUSTOMER, MANAGER, ENGINEER

}
