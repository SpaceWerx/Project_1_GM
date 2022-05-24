package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.User;
import Utilities.ConnectionFactory;

public class UserDAO {

	public List<User> getUsers() throws SQLException {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from users;";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id")				
						);
				userList.add(u);
			}
			return userList;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong while getting users");
			e.printStackTrace();
			return null;
		}
	}

	public void insertUser(User newUser) throws SQLException {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "insert into users (f_name, l_name, role_id) " + "values (?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newUser.getF_name());
			ps.setString(2, newUser.getL_name());
			ps.setInt(3, newUser.getRole_id());
			
			ps.executeUpdate();
			
			System.out.println("User " + newUser.getF_name() + " was created. Welcome to the team!");
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

	public List<User> getUserById(int id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from users where user_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			List<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id")				
						);
				userList.add(u);
			}
			return userList;			
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			return null;
		}		
		
	}

	public List<User> getUsersByRoleTitle(String roleTitle) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from user inner join roles " + "on users.role_id = roles.role_id where roles.role_title = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, roleTitle);
			
			rs = ps.executeQuery();
			
			List<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id")				
						);
				userList.add(u);
			}
			return userList;				
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			return null;
		}
	}
}
