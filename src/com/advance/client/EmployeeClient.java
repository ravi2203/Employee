package com.advance.client;

import com.advance.model.Employee;
import com.advance.service.EmployeeService;
import com.advance.service.EmployeeServiceImpl;

public class EmployeeClient {

	public static void main(String[] args) {
		
		EmployeeService ser=new EmployeeServiceImpl();
		Employee e1[]=ser.getAll();
		for(int i=0;i<e1.length;i++){
		System.out.println(e1[i].getEmpID());
				System.out.println(e1[i].getEmpName());
				System.out.println(e1[i].getEmpSal());
		
		}
	}
		
}
