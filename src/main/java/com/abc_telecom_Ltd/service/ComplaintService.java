package com.abc_telecom_Ltd.service;

import java.util.List;

import com.abc_telecom_Ltd.entity.Complaint;
import com.abc_telecom_Ltd.model.AssingEngineerToComplaintModel;
import com.abc_telecom_Ltd.model.ComplaintModel;
import com.abc_telecom_Ltd.model.FeedbackModel;
import com.abc_telecom_Ltd.model.UpdateStatusModel;

public interface ComplaintService {

	Complaint raiseComplaint(ComplaintModel complaintModel);

	Complaint viewComplaint(Long cust_id) throws Exception;

	Complaint provideFeedback(FeedbackModel feedback, Long cust_id) throws Exception;

	List<Complaint> viewComplaints(String pin_code);

	Complaint assignEngineer(AssingEngineerToComplaintModel assing) throws Exception;

	List<Complaint> viewAllComplaints(Long eng_id);

	Complaint updateStatus(UpdateStatusModel status);


}
