package Utilities;

import Controller.AuthController;
import Controller.ReimbursementController;
import Controller.UserController;
import Models.Reimbursement;
import io.javalin.Javalin;

public class JavalinConfigurationUtility {

		public void start(int port) {
			this.app.start(port);
		}

		
		AuthController authController = new AuthController();
		UserController userController = new UserController();
		ReimbursementController reimbursementController= new ReimbursementController();
		
		Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).routes(()-> {
		
		path("login", () -> {
	
			post(authController::handleLogin);
		});
		
		path("register", () -> {
			
			post(authController::handleRegister);
		
		});
		
		path("users", () →> {
		
			get(userController::handleGetUsers);
		
		path("{id}", () -> { 
			get(userController::handleGetUserById);
		
	});
 });
		
		path("reimbursements", () →> {
		
		get(reimbursementController::handleGetReimbursements);
		
		post(reimbursementController::handleSubmit);
		
		path("{id}", () -> {
		
		get(reimbursementController::handleGetReimbursementById); 
		
		put(reimbursementController::handleProcess);
		
		});
	});
 });
}
