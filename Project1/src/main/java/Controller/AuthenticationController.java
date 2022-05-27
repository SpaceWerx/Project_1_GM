package Controller;

import com.google.gson.Gson;

import Models.User;
import Service.AuthService;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;

public class AuthenticationController {

	AuthService as = new AuthService();
	
	public Handler handleLogin = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		//I recommend you make this an employee object 
		User LDTO = gson.fromJson(body, User.class);

		if(as.login(LDTO.getUsername(), LDTO.getPassword()) == 1) {
			ctx.status(201);
			ctx.result("Login Sucessful!");
		}
		else if(as.login(LDTO.getUsername(), LDTO.getPassword()) == 2) {
			ctx.status(202);
			ctx.result("Login Sucessful!");
		}
		else {
		ctx.result("Login Failed!");
		ctx.status(401);
		}
	};

	public Handler handleRegister = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		User user = gson.fromJson(body, User.class);
		
	try {
	
	String input = ctx.body();
	int id = AuthService.register(user);
	
	if(id == 0) { 
		ctx.status(HttpCode. INTERNAL_SERVER_ERROR);
		ctx.result("Registration unsuccessful.");
		
	} else {
	
		ctx.status (HttpCode.CREATED); 
		ctx.result("Registration successful.");
	}
	} catch (Exception e) {
	
		ctx.status (HttpCode. INTERNAL_SERVER_ERROR);
	
	if(!e.getMessage().isEmpty()) { ctx.result(e.getMessage());
	}
	
		e.printStackTrace();
	}
	
 };
}
