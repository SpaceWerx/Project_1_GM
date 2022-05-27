package com.revature;
import java.sql.Connection;
import java.sql.SQLException;

import Controller.AuthenticationController;
import Controller.ReimbursementController;
import Controller.UserController;
import Service.CLIMenuService;
import Utilities.ConnectionFactory;
import io.javalin.Javalin;

public class DriverClass {
	public static void main (String[] args) throws SQLException{
			UserController uc = new UserController();
			AuthenticationController ac = new AuthenticationController();
			ReimbursementController rc = new ReimbursementController();
			
			try(Connection conn = ConnectionFactory.getConnection()){
				System.out.println("Connection Successful :");
			} catch(SQLException e) {
				System.out.println("Connection Failed");
			e.printStackTrace();
			}
		
		
//		Make the menu run, its only 2 lines of code
		CLIMenuService menu = new CLIMenuService();
	//	
		menu.displayMenu();
		
	}
		//This is our Javalin object (which creates the connection, done)
//		Javalin app = Javalin.create(
//				config -> {
//					config.enableCorsForAllOrigins();
//				}
//		).start(3000);
//
//		//Now we need our endpoints
//		
//		app.post("/login", ac.handleLogin);
//				
//		app.get("/user", uc.getUserHandler);
//		
//		app.post("/insert", uc.insertUserHandler);
//				
//		app.post("/submit", rc.handleSubmit);
//		
//		app.put("/process", rc.handleProcess);
//		
//		app.get("/reimbursement", rc.handleGetReimbursements);
		
		
		
		
		
//		app.post("/login", ac.loginHandler);
//		need to register user
//		need to login
//		need to submit reimbursements
//		need to get reimbursments
//		need to get reimbursements by status
//		need to process reimbursements
//		need to register

	

		}
