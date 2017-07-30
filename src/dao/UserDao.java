package dao;

import java.sql.*;
import java.util.*;

import dbconnection.ConnectionProvider;
import bean.UserBean;

public class UserDao	{
	private Connection con;
	
	public UserDao() { 
		this.con = ConnectionProvider.getConnection(); 
		System.out.println("Value of conn is  " +con);  
	}
	
/*	public UserDao()	{
		this.conn = ConnectionProvider.getConnection();
	}
*/	
	
// Insert Data	
	public void addUser(UserBean userBean) {
		try {
			String sql = "INSERT INTO student (name, rollno, class, mobileno) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.setString(1, userBean.getName());
			ps.setInt(2, userBean.getRollno());
			ps.setString(3, userBean.getClas());
			ps.setLong(4, userBean.getMono());
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

// Delete Data
	public void removeUser(int rollno) {
		try {
			String sql = "DELETE FROM student WHERE rollno=?";
			
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.setInt(1, rollno);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

// Edit Data	
	public void editUser(UserBean userBean) {
		try {
			String sql = "UPDATE student SET rollno=?, class=?, mobileno=? WHERE name=?";
//			String sql = "UPDATE student SET rollno=?, class=?, mobileno=? WHERE rollno=?";
//			String sql = "UPDATE student SET rollno=?, class=?, mobileno=? WHERE name=?";
//			String sql = "UPDATE student SET name=?, rollno=?, class=?, mobileno=? WHERE rollno=?";
			
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.setInt(1, userBean.getRollno());
			ps.setString(2, userBean.getClas());
			ps.setLong(3, userBean.getMono());
			ps.setString(4, userBean.getName());
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
// Viewing Data
	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> student = new ArrayList<UserBean>();
		try {
			if(this.con.isClosed())	{
				System.out.println("Connection closed");
			}
			else	{
				String sql = "SELECT * FROM student ORDER BY name";
			
				PreparedStatement ps = this.con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
			
				while (rs.next()) {
					UserBean userBean = new UserBean();
					userBean.setName(rs.getString("name"));
					userBean.setRollno(rs.getInt("rollno"));
					userBean.setClas(rs.getString("class"));
					userBean.setMono(rs.getLong("mobileno"));
					student.add(userBean);
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	return student;
	}
	
	

	public UserBean getUserById(int rollno) {
		UserBean userBean = new UserBean();
		try {
			String sql = "SELECT * FROM student WHERE rollno=?";
			
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.setInt(1, rollno);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				userBean.setName(rs.getString("name"));
				userBean.setRollno(rs.getInt("rollno"));
				userBean.setClas(rs.getString("class"));
				userBean.setMono(rs.getLong("mobileno"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	return userBean;
	}
}