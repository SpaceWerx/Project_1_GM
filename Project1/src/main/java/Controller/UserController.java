package Controller;

import java.util.List;

import com.google.gson.Gson;

import Models.User;
import Service.UserService;
import io.javalin.http.Handler;

	public class UserController {
		UserService us = new UserService();
		
		public Handler getUserHandler = (ctx) ->{
			
	//This does not work anymore like it is intended to, do not use this		
//			if(ctx.req.getSession(false) != null) {
//			
//			}
//			else {
//				
//				ctx.status(401);
//			}
				
			List<User> allUsers = us.getUsers();
			
			Gson gson = new Gson();
			
			String JSONObject = gson.toJson(allUsers);
				
			ctx.result(JSONObject);
			ctx.status(200);
				
		};
			
		public Handler insertUserHandler = ctx ->{
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User user = gson.fromJson(body, User.class);
			
			us.addUser(user);
			
			ctx.result("User successfully added!");
			ctx.status(201);
		};
}