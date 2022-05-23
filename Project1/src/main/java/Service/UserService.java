package Service;

import java.sql.SQLException;
import java.util.List;

import DAO.UserDAO;
import Models.User;

public class UserService {
	
	UserDAO uDAO = new UserDAO();
	
	public List<User> getUsers() throws SQLException{
		
			List<User> users = uDAO.getUsers();
			
			return users;
	}
	public void addUser(User newUser) throws SQLException{
		
		uDAO.insertUser(newUser);
	}
	public List<User> getUserById(int id){
		
		List<User> user = uDAO.getUserById(id);
		
		return user;
	}
	public List<User> getUsersByRoleTitle(String roleTitle){
		
		List<User> users = uDAO.getUsersByRoleTitle(roleTitle);
		
		return users;
	}
}
