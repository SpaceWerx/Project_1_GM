package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Employee;
import Models.User;
import Utilities.ConnectionFactory;

public class UserDAO {

		public List<User> getUsers() throws SQLException{
			try(Connection conn = ConnectionFactory.getconnection()){
				ResultSet rs = null;
				
				String sql = "select * from employees;";
				
				Statement s = conn.createStatement();
				
				rs = s.executeQuery(sql);
				
				List<User> userList = new ArrayList<>();
				
				while(rs.next()) {
					Employee e = new Employee(
							rs.getInt("employee_id")),
							rs.getString("f_name"),
							rs.getString("l_name"),
							rs.getInt("role_id")
							);
							employeeList.add(e);
				}
				return employeeList;
			}
		}
}
