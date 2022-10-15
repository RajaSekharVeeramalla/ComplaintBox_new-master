package com.abc_telecom_Ltd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc_telecom_Ltd.entity.Manager;
import com.abc_telecom_Ltd.repository.ManagerRepository;

@Service
public class ManagerServiceImp implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public Manager addManager(Manager manager) {
		return managerRepository.save(manager);
	}

	@Override
	public void deleteManager(Long id) {
		managerRepository.deleteById(id);
	}

	@Override
	public List<Manager> viewManagers() {
		return managerRepository.findAll();
	}



}
