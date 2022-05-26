package com.revature;
import java.sql.Connection;
import java.sql.SQLException;

import Controller.AuthController;
import Controller.ReimbursementController;
import Controller.UserController;
import Utilities.ConnectionFactory;
import io.javalin.Javalin;

public class DriverClass {
	public static void main (String[] args) throws SQLException{
			UserController uc = new UserController();
			AuthController ac = new AuthController();
			ReimbursementController rc = new ReimbursementController();
			
			try(Connection conn = ConnectionFactory.getConnection()){
				System.out.println("Connection Successful :");
			} catch(SQLException e) {
				System.out.println("Connection Failed");
			e.printStackTrace();
			}
		
		
//		Make the menu run, its only 2 lines of code
//		Menu menu = new Menu();
	//	
//		menu.displayMenu();
		
		
		//This is our Javalin object (which creates the connection, done)
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
		).start(3000);

		//Now we need our endpoints
		
		app.post("/login", ac.handleLogin);
		
		app.post("/register", ac.handleRegister);
		
		app.get("/user", uc.getUserHandler);
		
		app.post("/user", uc.insertUserHandler);
		
		app.get("/user/{id}", uc.getUserByID);
		
		app.post("/submit", rc.handleSubmit);
		
		app.put("/process", rc.handleProcess);
		
		app.get("/reimbursement", rc.handleGetReimbursements);
		
		
		
		
		
//		app.post("/login", ac.loginHandler);
//		need to register user
//		need to login
//		need to submit reimbursements
//		need to get reimbursments
//		need to get reimbursements by status
//		need to process reimbursements
//		need to register

	

		}
}
