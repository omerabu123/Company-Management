package com.companyManagment.service;

import com.companyManagment.beans.Child;
import com.companyManagment.exception.CannotFindEntity;

public interface IChildService {

	Child getOneChild(int id) throws CannotFindEntity;

	Child getChildByCitizenID(long citizenID) throws CannotFindEntity;

}
