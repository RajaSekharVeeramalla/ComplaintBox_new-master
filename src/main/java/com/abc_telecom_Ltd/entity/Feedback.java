package com.abc_telecom_Ltd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long feedBack_id;
	private String feedback;

}
