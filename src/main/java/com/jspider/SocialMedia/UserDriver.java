package com.jspider.SocialMedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDriver {
	private static final ResultSet Resultsets = null;
	public static Connection getTheConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia","root","root");
		return connection;
		
	}
	public void saveUser(User user) throws Exception{
		Connection con=getTheConnection();
		PreparedStatement ps= con.prepareStatement("INSERT INTO USER(id,name,email,password,mediatype,phoneno)values(default,?,?,?,?,?)");
		//ps.setInt(1, user.getId());
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getMediaType());
		ps.setString(5, user.getPhoneno());
		ps.execute();
		System.out.println("user inserted successfull");
		ps.close();
		con.close();
	}
	public void updateUser(User user) throws Exception {
		Connection con=getTheConnection();
		PreparedStatement ps= con.prepareStatement("UPDATE USER SET name=?,email=?,password=?,mediatype=?,phoneno=? where id=?");	
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getMediaType());
		ps.setString(5, user.getPhoneno());
		ps.setInt(6, user.getId());
		ps.executeUpdate();
		System.out.println("user update sussfully");
		ps.close();
		con.close();		
	}
	public void deleteUser(int id) throws Exception {
		Connection con=getTheConnection();
		PreparedStatement ps=con.prepareStatement("delete from user where id=?");
		ps.setInt(1,id);
		ps.execute();
		System.out.println("delete");
		ps.close();
		con.close();
	}
	
	public void getAllUser() throws Exception {
		Connection con=getTheConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM USER");
		ResultSet  sets=ps.executeQuery();
		while(sets.next()) {
			System.out.println("user id is:"+sets.getInt(1));
			System.out.println("user name is:"+sets.getString(2));
			System.out.println("user email is:"+sets.getString(3));
			System.out.println("user password is:"+sets.getString(4));
			System.out.println("user mediatype is:"+sets.getString(5));
			System.out.println("user phoneno is:"+sets.getString(6));
		}
		ps.close();
		con.close();
	}
	public void getUserById(int id, String email,String password) throws Exception {
		Connection con=getTheConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM USER WHERE ID=?");
		ps.setInt(1, id);
		ResultSet resultSet=ps.executeQuery();
		try {
			while(resultSet.next()) {
				if(resultSet.getString(3).equals(email) && resultSet.getString(4).equals(password)) {
					
					System.out.println("user id is:"+resultSet.getInt(1));
					System.out.println("user name is:"+resultSet.getString(2));
					System.out.println("user email is:"+resultSet.getString(3));
					System.out.println("user password is:"+resultSet.getString(4));
					System.out.println("user mediatype is:"+resultSet.getString(5));
					System.out.println("user phoneno is:"+resultSet.getString(6));
				}
				else {
					throw new UserNotFoundException();
				}
			}
		}
		catch(UserNotFoundException e) {
			System.out.println("ENTER THE VALID EMAIL AND PASSWORD");
		}
	}
	/* public static void main(String[] args) throws Exception {
		
	      UserDriver driver = new UserDriver();
	      User user = new User();
	      user.setId(1);
	      user.setName("papu");
	      user.setEmail("papu@gmail.com");
	      user.setPassword("P@pu2000");
	      user.setMediaType("instagram");
	      user.setPhoneno("9998090587");
	     // driver.saveUser(user);
	      //driver.updateUser(user);
	      //driver.deleteUser(1);
	}*/
}
