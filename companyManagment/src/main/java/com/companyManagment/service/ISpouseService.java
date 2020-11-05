package com.companyManagment.service;

import com.companyManagment.beans.Spouse;
import com.companyManagment.exception.CannotFindEntity;

public interface ISpouseService {

	Spouse getOneSpouse(int id) throws CannotFindEntity;

	void updateSpouseName(int spouseID,String spouseNewName) throws CannotFindEntity;

	Spouse getSpouseByCitizenID(long citizenID) throws CannotFindEntity;

	
}
