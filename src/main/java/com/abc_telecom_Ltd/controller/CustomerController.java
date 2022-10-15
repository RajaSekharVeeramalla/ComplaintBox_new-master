package com.abc_telecom_Ltd.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc_telecom_Ltd.entity.Complaint;
import com.abc_telecom_Ltd.entity.Customer;
import com.abc_telecom_Ltd.exceptions.ComplaintNotPresentException;
import com.abc_telecom_Ltd.model.ComplaintModel;
import com.abc_telecom_Ltd.model.FeedbackModel;
import com.abc_telecom_Ltd.service.ComplaintService;
import com.abc_telecom_Ltd.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private CustomerService customerService;
	

	// LOGIN

	// RAISE COMPLAINT
	
	@PostMapping("/raiseComplaint")
	public ResponseEntity<Complaint> raiseComplaint(@RequestBody ComplaintModel complaintModel) {
		Complaint complaint2 = complaintService.raiseComplaint(complaintModel);
		// Customer_id, complaint, pin code, contact are required to raise complaint
		// Engineer, Feedback can be set 'NA' from UI side.
		return new ResponseEntity<Complaint>(complaint2, HttpStatus.OK);
	}

	// VIEW COMPLAINT
	
	@GetMapping("/viewComplaint/{userName}")
	public ResponseEntity<Complaint> viewComplaint(@PathVariable String userName) throws Exception {
		Customer customer = customerService.getCustomer(userName);
		Long cust_id = customer.getCustid();
		Complaint complaint = complaintService.viewComplaint(cust_id);
		if (Objects.isNull(complaint)) {
			throw new ComplaintNotPresentException();
		}
		return new ResponseEntity<Complaint>(complaint, HttpStatus.OK);
	}

	// PROVIDE FEEDBACK

	@PostMapping("/addFeedback/{compId}")
	public ResponseEntity<Complaint> provideFeedback(@RequestBody FeedbackModel feedback, @PathVariable Long compId) throws Exception {
		System.err.println("AddFeedback");
		Complaint complaint = complaintService.provideFeedback(feedback, compId);
		return new ResponseEntity<Complaint> (complaint, HttpStatus.OK);
	}

}
