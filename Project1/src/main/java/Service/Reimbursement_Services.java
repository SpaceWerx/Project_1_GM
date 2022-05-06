package Service;

import java.util.ArrayList;
import java.util.List;
import Models.Reimbursement;
import Models.Status;

public class Reimbursement_Services {
	List<Reimbursement> reimbursements;
	
	
		public void submitReimbursement (Reimbursement reimbursementToBeSubmitted) {
			
			Reimbursement latestReimbursement = reimbursements.get(reimbursements.size() -1);
			int id = latestReimbursement.getID() + 1; //New ID is 1 higher than the previous highest
			
			reimbursementToBeSubmitted.setID(id);;
			reimbursementToBeSubmitted.setStatus(Status.Pending);
			reimbursements.add(reimbursementToBeSubmitted);
			
		}
		
		public void update(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {
			
			for (Reimbursement reimbursement : reimbursements) {
				if (reimbursement.getID() == unprocessedReimbursement.getID()) {
					reimbursement.setResolver(resolverId);
					reimbursement.setStatus(updatedStatus);
					return;
					
					
				}
			}
			
			throw new RuntimeException("There was an error processing this reimbursement, please try again");
			
		}
		
		public Reimbursement getReimbursementById(int id) {
			
			for (Reimbursement reimbursement : reimbursements) {
				if (reimbursement.getID() == id) {
					return reimbursement;
				}
			}
			return null;
				
		}
		
		public List<Reimbursement> getPendingReimbursements(){
			List<Reimbursement> pendingReimbursements = new ArrayList<>();
		
			
			for (Reimbursement reimbursement : reimbursements) {
				if (reimbursement.getStatus() == Status.Pending) {
					pendingReimbursements.add(reimbursement);		
				
				}
			}
		return pendingReimbursements;
		}
		
		public List<Reimbursement> getResolvedReimbursements(){
			List<Reimbursement> resolvedReimbursements = new ArrayList<>();
		
			
			for (Reimbursement reimbursement : reimbursements) {
				if (reimbursement.getStatus() == Status.Approved || reimbursement.getStatus() == Status.Denied){
					resolvedReimbursements.add(reimbursement);	
				
				}
					
			}
			
				return resolvedReimbursements;
		}
		

		
		public List<Reimbursement> getReimbursementsByAuthor(int userId){
			
			List<Reimbursement> userReimbursement = new ArrayList<>();
		
			for (Reimbursement r : reimbursements) {
				
				if (r.getAuthor() == userId || r.getResolver() == userId) {
					userReimbursement.add(r);
				}
				
			}
			
			return userReimbursement;
		}
}
