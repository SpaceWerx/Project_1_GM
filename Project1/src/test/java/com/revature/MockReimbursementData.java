package com.revature;

import java.util.ArrayList;
import java.util.List;
import Models.Reimbursement;
import Models.Status;
import Models.Type;

public class MockReimbursementData {

	
	private final List<Reimbursement> reimbursements = new ArrayList<>();
	
	public MockReimbursementData() {
		
	
		MockUserData userData = new MockUserData();
		
		Reimbursement REIMBURSEMENT_TO_PROCESS_1 = new Reimbursement(1, 1,  0, "Oracle Java Certification", Type.Other, Status.Pending, 250.00);
		Reimbursement REIMBURSEMENT_TO_PROCESS_2 = new Reimbursement(2, 2,  0, "Travel to Reston HQ", Type.Travel, Status.Pending,  600.00);
		Reimbursement REIMBURSEMENT_Approved_1 = new Reimbursement(3, 1, 3,  "Free lunch offer from Sean", Type.Food, Status.Approved,  25.00);
		Reimbursement REIMBURSEMENT_Approved_2 = new Reimbursement(4, 2, 4,  "2-night hotel stay near Orlando Office for visit", Type.Lodging, Status.Approved,  300.00);
		Reimbursement REIMBURSEMENT_Denied_1 = new Reimbursement(5, 1, 3, "Rental Car to drive from Reston to Orlando", Type.Travel, Status.Denied, 2500.00);
	
	
		
		reimbursements.add(REIMBURSEMENT_TO_PROCESS_1);
		reimbursements.add(REIMBURSEMENT_TO_PROCESS_2);
		reimbursements.add(REIMBURSEMENT_Approved_1);
		reimbursements.add(REIMBURSEMENT_Approved_2);
		reimbursements.add(REIMBURSEMENT_Denied_1);
				
		
	}

public List<Reimbursement> getReimbursements() {return reimbursements;}



}
