package com.abc_telecom_Ltd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Engineer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long engineer_id;
	private String name;
	private String pinCode;

}
