package com.revature;
import java.sql.Connection;
import java.sql.SQLException;

import Controller.EmployeeController;
import Utilities.ConnectionFactory;
import io.javalin.Javalin;

public class DriverClass {

//rename all employee to user
		EmployeeController ec = new EmployeeController();
				
		public void main (String[] args) throws SQLException{
			
			try(Connection conn = ConnectionFactory.getconnection()){
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
		app.get("/employee", ec.getEmployeesHandler);
		
		app.post("/employee", ec.insertEmployeesHandler);

		}
	}
}
