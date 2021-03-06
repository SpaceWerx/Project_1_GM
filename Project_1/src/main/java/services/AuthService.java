package services;

	import models.Role;
	import models.User;

	import DAO.UserDAO;

	public class AuthService {

	public static int register(User userToBeRegistered) {

	if(UserDAO.getByUsername(userToBeRegistered.getUsername()) != null) {

	throw new NullPointerException("Username is already taken");
	}

	return UserDAO.create(userToBeRegistered);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static int login(String username, String password) {



	try {

	User user = UserDAO.getByUsername(username);

	if(user!=null && password.equals(user.getPassword()) && user.getRole()== Role.Manager) {

	System.out.println("Manager Logged In Successfully!");
	return 1;
	} else if (user!=null && password.equals(user.getPassword()) && user.getRole()== Role.Employee) {

	System.out.println("Employee Logged In Successfully!");
	return 2;
	} else {

	System.out.println("Username or Password Does Not Exist!");
	// return 0;
	}
	} catch (Exception e) {
	System.out.println("Login Unsuccessful");
	e.printStackTrace();
	}
	return 0;



	}

	public static Object login(int anyInt) {
	// TODO Auto-generated method stub
	return null;
	}

	public static Object update(String string) {
	// TODO Auto-generated method stub
	return null;
	}
	}
	//;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
