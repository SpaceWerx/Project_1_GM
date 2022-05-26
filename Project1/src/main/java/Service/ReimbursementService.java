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

	ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
	UserService userService = new UserService();

	public List<Reimbursement> getPendingReimbursements() { return reimbursementDAO.getByStatus (Status.Pending); }

	public List<Reimbursement> getResolvedReimbursements() { 
		List<Reimbursement> resolvedReimbursements = new ArrayList<>(); 

		resolvedReimbursements.addAll(reimbursementDAO.getByStatus (Status. Approved)); 
		resolvedReimbursements.addAll(reimbursementDAO.getByStatus (Status. Denied));

		return resolvedReimbursements;
}



	public int submitReimbursement (Reimbursement reimbursementToBeSubmitted) {

	User employee = userService.getUserById(reimbursementToBeSubmitted.getAuthor());

	if(employee.getRole () != Role. Employee) {

			throw new IllegalArgumentException ("Managers cannot submit reimbursement requests.");
	} 	else {

		reimbursementToBeSubmitted.setStatus (Status. Pending);
		
		return reimbursementDAO.create(reimbursementToBeSubmitted);
	}
  }

	public Reimbursement update(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {
		User manager = userService.getUserById(resolverId);
	
	if(manager.getRole () != Role. Manager) {
	
		throw new IllegalArgumentException ("An Employee cannot process reimbursement requests.");
	} else {

	unprocessedReimbursement.setResolver (resolverId); 
	unprocessedReimbursement.setStatus(updatedStatus); 
	
		   }
	}
	
	public Reimbursement getReimbursementById (int id) {return reimbursementDAO.getReimbursementById(id); }
	
	public List<Reimbursement> getReimbursementsByAuthor(int userId) { 
		return reimbursementDAO.getReimbursementsByUser (userId);
	}
	
//	public Handler handleProcess = (ctx) =>{
//		String body = ctx.body();
//		Gson gson = new Gson();
//		Reimbursement reimbursement =gson.fromJson(body,  Reimbursement.class);
//		int id = reimbursement.getResolver();
//		Status statusInput = 
	}
}
