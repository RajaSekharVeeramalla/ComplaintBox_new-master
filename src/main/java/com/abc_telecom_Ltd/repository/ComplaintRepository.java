package com.abc_telecom_Ltd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc_telecom_Ltd.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long>{

	Complaint findByCustomer(Long cust_id);

	List<Complaint> findAllByPinCode(String pin_code);

	List<Complaint> findByEngineer(Long eng_id);

	Complaint findByCustomerCustid(Long cust_id);

	Complaint findByCustomer_Custid(Long cust_id);

	

}
