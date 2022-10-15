package com.abc_telecom_Ltd.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc_telecom_Ltd.entity.Customer;

@Repository
public interface CustomerReposisoty extends JpaRepository<Customer, Long>{

	void deleteByName(String name);

	Customer findByUserName(String userName);

	Customer findByuserName(String userName);

}
