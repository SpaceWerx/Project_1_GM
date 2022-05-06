package com.revature;

import java.util.ArrayList;
import java.util.List;

import Models.Roles;
import Models.Users;

public class MockUserData extends Users{
	
	
	
	
	private final List<Users> user = new ArrayList<>();
	
		
	public MockUserData() {
		
		
		Users GENERIC_EMPLOYEE_1 = new Users(1, "genericEmployee1", "genericPassword1", Roles.Employee);
		Users GENERIC_EMPLOYEE_2 = new Users(2, "genericEmployee2", "genericPassword2", Roles.Employee);
		Users GENERIC_EMPLOYEE_3 = new Users( 3, "genericEmployee3",   "genericPassword3", Roles.Employee);
		Users GENERIC_Finance_Manager_1 = new Users(4,  "genericManager1", "genericPassword1", Roles.Manager);
		Users GENERIC_Finance_Manager_2 = new Users(5,  "genericManager2", "genericPassword2", Roles.Manager);
		Users GENERIC_Finance_Manager_3 = new Users(6,  "genericManager3", "genericPassword3", Roles.Manager);
		
		
		
		user.add(GENERIC_EMPLOYEE_1);
		user.add(GENERIC_EMPLOYEE_2);
		user.add(GENERIC_EMPLOYEE_3);
		user.add(GENERIC_Finance_Manager_1);
		user.add(GENERIC_Finance_Manager_2);
		user.add(GENERIC_Finance_Manager_3);
		
		
				
		
	}
	public List<Users> getUsers() {return user;}
}


