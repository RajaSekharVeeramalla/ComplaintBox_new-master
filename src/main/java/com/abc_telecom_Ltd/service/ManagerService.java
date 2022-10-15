package com.abc_telecom_Ltd.service;

import java.util.List;

import com.abc_telecom_Ltd.entity.Manager;

public interface ManagerService {

	Manager addManager(Manager manager);

	void deleteManager(Long id);

	List<Manager> viewManagers();

}
