package Service;

import java.sql.SQLException;

import DAO.UserDAO;
import Models.Role;
import Models.User;

public class AuthService {

	public static int register(User userToBeRegistered) throws SQLException {
		
//		if(UserDAO.getByUsername(userToBeRegistered.getUsername())!= null) {
//			
//		}
				
		return UserDAO.create(userToBeRegistered);
	}
	
	public int login(String username, String password) {
		User user = null;
		
		try {
						
			if (username.equals("manager")  && password.equals(user.getPassword()) && user.getRole() == Role.Manager) {
				
				System.out.println("Manager logged In Successfully!");
				return 1;
				
			} else if (username.equals("employee") && !password.equals(user.getPassword()) && user.getRole() == Role.Employee) {
				
				System.out.println("Employee logged in Successfully");
				return 2;
				
			} else {
				
				System.out.println("User Does Not Exist!");
				return 0;
			}
		}catch (Exception e) {
			System.out.println("Login Unsuccessful");
			e.printStackTrace();
		}
		return 0;
		}
	}

