package com.abc_telecom_Ltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc_telecom_Ltd.entity.AppUser;



@Repository
public interface AppUserDetailRepository extends JpaRepository<AppUser, Long> {

	AppUser findByUsername(String username);

}
