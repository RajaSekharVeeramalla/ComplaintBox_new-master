package com.abc_telecom_Ltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedbackModel {
	private Long complaintId;
	private String feedback;

}
