package Controller;

import javax.net.ssl.SSLEngineResult.Status;

import com.google.gson.Gson;

import Models.Reimbursement;
import Service.ReimbursementService;
import Service.UserService;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;

public class ReimbursementController {
	
	public Handler handleSubmit = (ctx) ->{
		
		String body = ctx.body();
		
		Gson gson = new Gson();
	try {
		
		String input = ctx.body();
			
		int id = ReimbursementService.submitReimbursement(reimbursement);
		
		if(id != 0) {
	ctx.status (HttpCode.CREATED);
	ctx.result("" + id);
	
	} else {
	
	ctx.status(HttpCode.BAD_REQUEST); 
	ctx.result("Reimbursement submission was unsuccessful. ");
	
	}
	} catch (Exception e) {
	
	if(!e.getMessage().isEmpty()) { ctx.result(e.getMessage());
		ctx.result(e.getMessage());
	}
	
	e.printStackTrace();
	}
 };
	public Handler handleProcess = (ctx) ->{
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		String authHeader = ctx.header("Current-user");
		
		if(authHeader != null) {
		 int userId = Integer.parseInt(authHeader);
		 
	try{
		String reimbursementIdInput = ctx.pathParam( "id"); 
		
		int id= Integer.parseInt(reimbursementIdInput);
		
		
		 String statusInput = ctx.formParam("status");
		 
		Reimbursement reimbursement = ReimbursementService.getReimbursementById(id);
		
		if(reimbursement != null) {
		
		Reimbursement processedReimbursement = ReimbursementService.update(reimbursement, userId, Status.valueOf(statusInput));
		
		ctx.status (HttpCode.ACCEPTED);
		ctx.json (processedReimbursement);
		
		} else {
		 ctx.status(HttpCode.BAD_REQUEST); 
		 ctx.result("Reimbursement processing was not successful");
		 
		 }
		
		} catch (Exception e) {
			
		
		ctx.status(HttpCode. INTERNAL_SERVER_ERROR);
		
		 if(!e.getMessage().isEmpty()) {
			 ctx.result(e.getMessage());
		
		 }
		 e.printStackTrace();
		}
		
		} else {
		
		ctx.result("Missing Current User Header with ID");
		}
 };
	
	public Handler handleGetReimbursementByStatus = (ctx) ->{
		
		String body = ctx.body();
		
		Gson gson = new Gson();
	try {
	
	String statusParam= ctx.queryParam("status");
	
	 Status status = Status.valueOf(statusParam);
	 
	if(status== Status.Pending) { 
		ctx.status(HttpCode.OK); 
		ctx.json(ReimbursementService.getPendingReimbursements());
	
		
	} else {
	ctx.status (HttpCode.OK);
	ctx.json(ReimbursementService.getResolvedReimbursements());
	
	}
	
	} catch(Exception e) { 
	ctx.status(HttpCode. INTERNAL_SERVER_ERROR);
	
	if(!e.getMessage().isEmpty()) { ctx.result(e.getMessage());
	}
	
	e.printStackTrace();
  }
 };
	
	public Handler handleGetReimbursementsByAuthor = (ctx) ->{
		
		String body = ctx.body();
		
		Gson gson = new Gson();
			
	try{
	
		String idParam = ctx.queryParam("author");
	
		if(idParam != null) {
	
	int id = Integer.parseInt(idParam);
	
		if(UserService.checkUserExistsById(id)) { 
			
		
			ctx.status(HttpCode.OK);
			ctx.json(ReimbursementService.getReimbursementsByAuthor(id));
		
		} else {
			ctx.status(HttpCode.NOT_FOUND);
			ctx.result("Unable to retrieve reimbursements, current user is not in the database");
		}
		
	} else {
	
		ctx.status(HttpCode.BAD_REQUEST);
		ctx.result("Missing Current User header");
	}
	
	} catch (Exception e) {
		
	
		ctx.status(HttpCode. INTERNAL_SERVER_ERROR);
		
	  if(!e.getMessage().isEmpty()) {
			
			ctx.result(e.getMessage());
	
	}
	e.printStackTrace();
}
	};
	
public Handler handleGetByIdMethod = (ctx) ->{
		
		String body = ctx.body();
		
		Gson gson = new Gson();
			
	try{
	
		String idParam = ctx.queryParam("id");
	
			
	int id = Integer.parseInt(idParam);
	
		Reimbursement reimbursement = ReimbursementService.getReimbursementById(id);
		
		if(reimbursement != null) { 
			
		
			ctx.status(HttpCode.OK);
			ctx.json(reimbursement);
			
	} else {
	
		ctx.status(HttpCode.BAD_REQUEST);
		ctx.result("Could not retrieve the reimbursement");
	}
	
	} catch (Exception e) {
		
	
		ctx.status(HttpCode. INTERNAL_SERVER_ERROR);
		
	  if(!e.getMessage().isEmpty()) {
			
			ctx.result(e.getMessage());
	
	}
	e.printStackTrace();
}
	};
	public Handler handleGetReimbursements = ctx ->{
		
	
	
		String body = ctx.body();
		Gson gson = new Gson();
		
		Reimbursement reimbursement =gson.fromJson(body, Reimbursement.class);
		
		int id = reimbursement.getResolver();
		
		String statusInput = reimbursement.getStatus().name();
	};
}
//	The basic setup for our handler methods for all controllers

//	public Handler handleProcess = (ctx) =>{
//		
//	
//		
//			String body = ctx.body();
//		Gson gson = new Gson();
//		Reimbursement reimbursement =gson.fromJson(body,  Reimbursement.class);
//		int id = reimbursement.getResolver();
//		String statusInput = reimbursement.getStatus().name();  change this line to setStatus().name("Approved/Denied"); if handleProcess is failing
//		
//		Reimbursement processedReimbursement = ReimbursementService.update(reimbursement, id, Status.valueOf(statusInput));

//		if (processedReimbursement != null) {

//		ctx.status(HttpCode.ACCEPTED);
//		} else {
//			ctx.status(HttpCode.ACCEPTED);
//			ctx.result("Reimbursement processing was not successful!");
//		}
//}
