package com.abc_telecom_Ltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusModel {
	private Long complaintId;
	private String status;

}
