package com.advance.service;

import com.advance.model.Employee;

public interface EmployeeService {
	
	public int save(Employee e);
	public int update(Employee e);
	public int delete(Employee e);
	public Employee get(int id);
	public Employee[] getAll();


}
