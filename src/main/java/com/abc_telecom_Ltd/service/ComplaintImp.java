package com.abc_telecom_Ltd.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc_telecom_Ltd.entity.Complaint;
import com.abc_telecom_Ltd.entity.Customer;
import com.abc_telecom_Ltd.exceptions.ComplaintNotPresentException;
import com.abc_telecom_Ltd.model.AssingEngineerToComplaintModel;
import com.abc_telecom_Ltd.model.ComplaintModel;
import com.abc_telecom_Ltd.model.FeedbackModel;
import com.abc_telecom_Ltd.model.UpdateStatusModel;
import com.abc_telecom_Ltd.repository.ComplaintRepository;


@Service
public class ComplaintImp implements ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;


	@Override
	public Complaint raiseComplaint(ComplaintModel complaintModel) {
		Complaint complaint2 = new Complaint();
		complaint2.setComplaint(complaintModel.getComplaint());
		complaint2.setPinCode(complaintModel.getPinCode());
		
		Customer customer = new Customer();
		customer.setName(complaintModel.getName());
		customer.setUserName(complaintModel.getUserName());		
		customer.setAddress(complaintModel.getAddress());
		customer.setPinCode(complaintModel.getPinCode());
		customer.setContact(complaintModel.getContact());
		customer.setTicket(UUID.randomUUID().toString());
		
		complaint2.setCustomer(customer);
		complaint2.setStatus("RAISED");
		complaint2.setEngineer(null);
		complaint2.setFeedback("NA");
		return complaintRepository.save(complaint2);
	}

	
	@Override
	public Complaint viewComplaint(Long cust_id) throws Exception {
		Complaint complaint = complaintRepository.findByCustomer_Custid(cust_id);
		if(Objects.isNull(complaint)) {
			throw new ComplaintNotPresentException();
		}
		return complaint;
	}

	//PROVIDE FEEDBACK
	@Override
	public Complaint provideFeedback(FeedbackModel feedback, Long compId) throws Exception {
		// get complaint from DB byCustomerId
		Complaint complaint = complaintRepository.findById(compId).get();
		System.err.println("Compaltin: "+ complaint);
		//the issue is: as now you updated the code, from customerId as property in Complaint to Customer object
		//thus, you can not a have a method, findByCustomer.
		if (Objects.nonNull(complaint)) {
			// update feedback and save
			complaint.setFeedback(feedback.getFeedback());
			return complaintRepository.save(complaint);
		} else {
			throw new ComplaintNotPresentException();
		}

	}
	
	//VIEW COMPLAINTS BY PINCODE
	@Override
	public List<Complaint> viewComplaints(String pin_code) {
		return complaintRepository.findAllByPinCode(pin_code);
	}

	@Override
	public Complaint assignEngineer(AssingEngineerToComplaintModel assing) throws Exception {
		//get complaint from DB
		Complaint complaint = complaintRepository.findById(assing.getComplaintId()).get();
		if(Objects.isNull(complaint)) {
			throw new ComplaintNotPresentException();
		}
		//Assign Engineer only if, status is raised
		if(complaint.getStatus().equalsIgnoreCase("Raised")) {	
			complaint.setEngineer(assing.getEngineerId());
			return complaintRepository.save(complaint);
		}
		return complaint;
	}

	@Override
	public List<Complaint> viewAllComplaints(Long eng_id) {
		return complaintRepository.findByEngineer(eng_id);
	}

	@Override
	public Complaint updateStatus(UpdateStatusModel status) {
		//get complaint
		Complaint complaint = complaintRepository.findById(status.getComplaintId()).get();
		//update complaint
		complaint.setStatus(status.getStatus().toUpperCase());
		return complaintRepository.save(complaint);
	}


}
