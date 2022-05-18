package Service;

import java.util.List;

import Models.Reimbursement;
import Models.Role;
import Models.User;

public class UserService {
	List<User> users;
	
	public User getUserByUsername(String username) {
		
			for (User user : users) {
			if (user.getUsername() == username) {
				return user;
			}
			}
				return null;
	
 }
	
	
	
	public User getUserById(int id) {
		
			for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
			}
				return null;
			
	}
	
	
	
	public User getUserByRole(Role role) {
		
			for (User user : users) {
			if (user.getRole() == role) {
				return user;
			}
			}
				return null;
	}
}
