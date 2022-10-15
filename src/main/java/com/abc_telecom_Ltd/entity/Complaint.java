package com.abc_telecom_Ltd.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Complaint { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long complaint_id;
	private String complaint;
	private String feedback;
	private String status;
	private String pinCode;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer", referencedColumnName = "custid")
	private Customer customer;		
	private Long engineer;
}
