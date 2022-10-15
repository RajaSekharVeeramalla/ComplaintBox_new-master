package com.abc_telecom_Ltd.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintModel {

	private String name;
	private String userName;
	private String address;
	private String pinCode;
	private Long contact;
	private String ticket;
	
	private String complaint;
	private String feedback;
	private String status;
	private Long engineer;
	private Long customer;
	
}
