package com.abc_telecom_Ltd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc_telecom_Ltd.entity.Engineer;
import com.abc_telecom_Ltd.repository.EngineerRepository;

@Service
public class EngineerServiceImp implements EngineerService{
	
	@Autowired
	private EngineerRepository engineerRepository;

	@Override
	public Engineer addEngineer(Engineer engineer) {
		return engineerRepository.save(engineer);
	}

	@Override
	public void deleteEngineer(Long id) {
		engineerRepository.deleteById(id);
		
	}
	@Override
	public List<Engineer> viewEngineersForAdmin() {
		return engineerRepository.findAll();
	}

	@Override
	public List<Engineer> viewEngineers(String pin_code) {
		return engineerRepository.findByPinCode(pin_code);
	}




	

}
