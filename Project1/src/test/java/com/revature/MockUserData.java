package com.revature;

import java.util.ArrayList;
import java.util.List;

import Models.Role;
import Models.Roles;
import Models.User;
import Models.Users;

public class MockUserData{
	
	

	
	private final List<User> users = new ArrayList<>();
	
		
	public MockUserData() {
		
		//Change the mock info to personalize
		User GENERIC_EMPLOYEE_1 = new User(1, "Tim", "genericPassword1", Role.Employee);
		User GENERIC_EMPLOYEE_2 = new User(2, "genericEmployee2", "genericPassword2", Role.Employee);
		User GENERIC_EMPLOYEE_3 = new User( 3, "genericEmployee3",   "genericPassword3", Role.Employee);
		User GENERIC_Finance_Manager_1 = new User(4,  "genericManager1", "genericPassword1", Role.Manager);
		User GENERIC_Finance_Manager_2 = new User(5,  "genericManager2", "genericPassword2", Role.Manager);
		User GENERIC_Finance_Manager_3 = new User(6,  "genericManager3", "genericPassword3", Role.Manager);
		
		
		
		users.add(GENERIC_EMPLOYEE_1);
		users.add(GENERIC_EMPLOYEE_2);
		users.add(GENERIC_EMPLOYEE_3);
		users.add(GENERIC_Finance_Manager_1);
		users.add(GENERIC_Finance_Manager_2);
		users.add(GENERIC_Finance_Manager_3);
		
		
				
		
	}
	public List<User> getUsers() {return users;}
}


