package com.revature;

import java.util.List;

import DAO.ReimbursementDAO;
import Models.Reimbursement;
import Models.User;
import Service.UserService;

public class ReimbursementServiceTest {

	private static Reimbursement Service reimbursement Service;
	private static UserService userService;
	private static ReimbursementDAO reimbursementDAO
	private Reimbursement REIMBURSEMENT_TO_PROCESS: private List<Reimbursement» mockPendingReimbursements:
	private List<Reimbursement> mockApprovedReimbursements:
	private List<Reimbursement» mockDeniedReimbursements;
	private User GENERIC EMPLOYEE 1;
	private User GENERIC_MANAGER 1;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	// Instantiating a new reimbursement service that is being tested reimbursement Service = new Reimbursement Service():
	// This method will be called before each test is initiated
	Before
	public void setup() throws Exception {
	// Mocking the user service and reisbursesentDAO because they are not being directly tested here
	UserService = mock (UserService.class); reimbursementDAO - mock (ReimbursementDAO.class);
	// Retrieving the mock data we made in week 1 to leverage in our tests
	MockReimbursementData nockReimbursementData= new MockReimbursementData(): // We must assign the mocks to the instantiated reimbursement service to ensure it's not using the real ones
	reimbursement Service.reimbursementDAO reimbursementOAO; reimbursement Service.userService = userService;
	// Generic mock users to use in our tests
	GENERIC_EMPLOYEE_1= new User( 1, semame "genericEmployeel", password "generic Password", Role. Employee); GENERIC_MANAGER 1 = new User( = 1, emane "generichanager1", "genericPassword", Role.Manager);
	// sock reimbursement that can be tested by processing
	REIMBURSEMENT TO PROCESS= new Reimbursement(2, GENERIC_EMPLOYEE_1.getId(), description "Dracle Certification ReimbursementType.Other, Status.Pending, amount 150.00);
	// Creating lists of reimbursements from the mockReimbursementlata W These lists will be used in various tests of the Reimbursement Service
	List<Reimbursement> mockReimbursements sockReimbursementData.getReimbursements(): mockPendingReisbursesents new Arraylist>();
	mockApprovedReimbursements = new
	BockDeniecReimbursements = new ArrayListo();
	If Iterating through the mock reimbursements and adding them to their respective lists by status
	for (Reimbursement reimbursement: mockReimbursements) {
	if(reimbursement.getStatus()== Status.Pending) 1
	mockPendingReimbursements.add (reimbursement);
	}else if (reimbursement.getStatus() == Status. Approved) {
	BockApprovedReimbursements.add(reimbursement);
	} else {
	BockDeniedReimbursements.add(reimbursement);
}
