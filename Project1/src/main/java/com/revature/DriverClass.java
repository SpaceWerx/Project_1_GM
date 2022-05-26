package com.revature;
import java.sql.Connection;
import java.sql.SQLException;

import Controller.UserController;
import Utilities.ConnectionFactory;
import io.javalin.Javalin;

public class DriverClass {
	public static void main (String[] args) throws SQLException{
			UserController uc = new UserController();
			
			
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
		).start(4000);

		//Now we need our endpoints
		app.get("/user", uc.getUserHandler);
		
		app.post("/user", uc.insertUserHandler);
		
//		app.post("/login", ac.loginHandler);
//		
//		app.get("/Reimbursement", )
	

		}
}
