package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	
	private int user_id;
	private String f_name;
	private String l_name;
	private int role_id;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String f_name, String l_name, int role_id) {
		super();
		this.user_id = user_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.role_id = role_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(f_name, l_name, role_id, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(f_name, other.f_name) && Objects.equals(l_name, other.l_name) && role_id == other.role_id
				&& user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", f_name=" + f_name + ", l_name=" + l_name + ", role_id=" + role_id + "]";
	}
	
	
}