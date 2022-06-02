package com.revature;


	import java.sql.Connection;
//import java.sql.Connection;
	import java.sql.SQLException;

import controller.AuthController;
import controller.ReimbursementController;
import controller.UserController;
import io.javalin.Javalin;
import utilities.ConnectionFactory;

	public class Driver {
	public static void main(String[] args) {
	AuthController ac = new AuthController();
	UserController uc = new UserController();
	ReimbursementController rc = new ReimbursementController();
	//DELETE IF NECESSARY
	try(Connection conn = ConnectionFactory.getConnection()){
	System.out.println("Connection Successful!");
	} catch(SQLException e) {
	System.out.println("Connection Failed");
	e.printStackTrace();
	}


	//CLI_Menu_Service options = new CLI_Menu_Service();
	//options.displayLoginMenu();


	//LEAVE IT JUST IN CASE
	Javalin app = Javalin.create(
	config -> {
	config.enableCorsForAllOrigins(); //This is what allows the server to process JS
	}
	).start(3000);

	app.get("/employee", uc.getEmployeesHandler);

	app.post("/employee", uc.insertEmployeesHandler);

	app.post("/login", ac.loginHandler);

	app.get("/status", rc.handleGetReimbursmentByStatus);

	app.get("/reimbursement", rc.handleGetReimbursements);

	app.get("/reimbursement/{id}", rc.handleGetReimbursementById);

	app.post("/submit", rc.handleSubmit);

	app.put("/approved", rc.handleApproved);

	app.put("/denied", rc.handleDenied);

	app.get("/author/{author}", rc.handleGetReimbursementByAuthor);

	}

}
