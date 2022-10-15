package com.abc_telecom_Ltd.service;

import java.util.List;

import com.abc_telecom_Ltd.entity.Engineer;

public interface EngineerService {

	Engineer addEngineer(Engineer engineer);

	void deleteEngineer(Long id);

	List<Engineer> viewEngineers(String pin_code);

	List<Engineer> viewEngineersForAdmin();

}
