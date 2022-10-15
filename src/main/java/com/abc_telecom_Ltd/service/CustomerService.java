package com.abc_telecom_Ltd.service;

import java.util.List;

import com.abc_telecom_Ltd.entity.Customer;

public interface CustomerService {

	Customer addCutomer(Customer cutomer);

	void deleteCutomer(Long id);

	List<Customer> viewCustomers();

	Customer getCustomer(String userName);

}
