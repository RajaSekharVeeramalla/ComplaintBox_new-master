package com.abc_telecom_Ltd.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
	
	private String name;
	private String address;
	private Long contact;
	private String ticket;

}
