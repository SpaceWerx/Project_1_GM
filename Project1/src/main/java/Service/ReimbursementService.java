package Service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import DAO.ReimbursementDAO;
import Models.Reimbursement;
import Models.Role;
import Models.Status;
import Models.User;

public class ReimbursementService {

	static ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
	UserService us = new UserService();

	public List<Reimbursement> getPendingReimbursements() { return reimbursementDAO.getByStatus (Status.Pending); }

	public List<Reimbursement> getResolvedReimbursements() { 
		List<Reimbursement> resolvedReimbursements = new ArrayList<>(); 

		resolvedReimbursements.addAll(reimbursementDAO.getByStatus (Status. Approved)); 
		resolvedReimbursements.addAll(reimbursementDAO.getByStatus (Status. Denied));

		return resolvedReimbursements;
}



	public static int submitReimbursement (Reimbursement reimbursementToBeSubmitted) {

		reimbursementToBeSubmitted.setStatus (Status.Pending);
		
		return reimbursementDAO.create(reimbursementToBeSubmitted);
	}

	public static Reimbursement update(Reimbursement unprocessedReimbursement) {
		
	reimbursementDAO.update(unprocessedReimbursement);
	return unprocessedReimbursement;
	}
	
	public Reimbursement getReimbursementById (int id) {return ReimbursementDAO.getReimbursementById(id); }
	
	public static List<Reimbursement> getReimbursementByAuthor(int userId) {
	    return reimbursementDAO.getReimbursementsByUser(userId);
	}
	
//	public Handler handleProcess = (ctx) =>{
//		String body = ctx.body();
//		Gson gson = new Gson();
//		Reimbursement reimbursement =gson.fromJson(body,  Reimbursement.class);
//		int id = reimbursement.getResolver();
//		Status statusInput = 
	}
