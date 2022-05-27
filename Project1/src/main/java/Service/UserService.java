package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.UserDAO;
import Models.Role;
import Models.User;

public class UserService {
	
	static UserDAO uDAO = new UserDAO();
	
	public List<User> getAllUsers() throws SQLException{
		
			List<User> users = uDAO.getAllUsers();
			
			return users;
	}
	public void addUser(User newUser) throws SQLException{
		
		uDAO.create(newUser);
	}
	public static User getUserById(int id){
		
		return uDAO.getUserById(id);
	}
	public static User getUserByUsername(String username){
		
		return uDAO.getByUsername(username);
		
		
	}

	public List<User> getUserByRole(Role role){
		
	
        List<User> byRole = new ArrayList<>();
        
        for(User user : uDAO.getAllUsers()) {
            if(user.getRole() == role) 
            {
                byRole.add(user);
            }
        }

        return byRole;
    }
}
