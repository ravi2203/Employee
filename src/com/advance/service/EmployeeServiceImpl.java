package com.advance.service;

import com.advance.dao.EmployeeDAO;
import com.advance.dao.EmployeeDAOImpl;
import com.advance.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO dao=null;
	
	public EmployeeServiceImpl(){
		
		dao=new EmployeeDAOImpl();
	}

	@Override
	public int save(Employee e) {
		
		int status=0;
		status=dao.save(e);
		return status;
	}

	@Override
	public int update(Employee e) {
		int status=0;
		status=dao.update(e);
		return status;
	}

	@Override
	public int delete(Employee e) {
		int status=0;
		status=dao.delete(e);
		return status;
	}

	@Override
	public Employee get(int id) {
	
		return dao.get(id);
	}

	@Override
	public Employee[] getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
