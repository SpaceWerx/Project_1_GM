package Controller;

import java.util.Objects;

import com.google.gson.Gson;

import Models.User;
import Service.AuthService;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;

public class AuthController {
	
	public Handler handleLogin = (ctx) ->{
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
	String username = ctx. formParam(  "username");
	String password = ctx.formParam( "password");
	
	User user = gson.fromJson(body, User.class);
	
	String un = user.getUsername();
	
	String ps = user.getPassword();
	
	
	if (AuthService.login(user.getUsername(), user.getPassword()) == 1) {
	
		ctx.status(HttpCode.BAD_REQUEST);
		ctx.result("Invalid Credentials");
		
	} else {
	
	int user = AuthService.login (username, password);
	
	if (user != null) {
		
	

		ctx.status(HttpCode.ACCEPTED);
		ctx.header("Access-Control-Expose-Headers", "Current-user"); 
		ctx.header("Current-User", "" +user.getId()); 
		ctx.result(user.getRole().toString());
	
	} else {
		
	
	ctx.status (HttpCode.BAD_REQUEST);
	ctx.result("Invalid Credentials");
	
	}
	}
};
	
	public Handler handleRegister = (ctx) ->{
		
		
		
		try {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User user =gson.fromJson(body, User.class);
			
	 int id= AuthService.register(user);
	
	if(id == 0) { 
		
		ctx.status(HttpCode. INTERNAL_SERVER_ERROR);
		ctx.result("Registration unsuccessful.");
		
	} else {
		
	
	ctx.status (HttpCode.CREATED); 
	ctx.result("Registration successful.");
	
	}
	 } catch (Exception e) {
	
		 ctx.status (HttpCode. INTERNAL_SERVER_ERROR);
	
	if(!e.getMessage().isEmpty()) { 
	
		ctx.result(e.getMessage());
	}
	
	e.printStackTrace();
	}
	}
}
