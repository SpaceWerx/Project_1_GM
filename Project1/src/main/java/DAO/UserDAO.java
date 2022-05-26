package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.Role;
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
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						Role.valueOf(rs.getString("role"))				
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
			String sql = "insert into users (username, password, role) " + "values (?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newUser.getUsername());
			ps.setString(2, newUser.getPassword());
			ps.setrole(3, newUser.getRole());
			
			ps.executeUpdate();
			
			System.out.println("User " + newUser.getUsername() + " was created. Welcome to the team!");
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

	public List<User> getUserById(int id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from users where id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			List<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				User u = new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						Role.valueOf(rs.getString("role"))				
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

	public List<User> getUserByUsername(String username) {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from user inner join roles " + "on users.role_id = roles.role_id where roles.role_title = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			List<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				User u = new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						Role.valueOf(rs.getString("role"))				
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
