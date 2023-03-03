/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Classes.Client;
import Classes.Connect;
import Classes.User;
import DAO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anace
 */
public class UserService implements IDAO<User>{
	
			Connection con;
			public int log(User u) {
				String req="SELECT * FROM user where email=? AND password=? ;";
				con=Connect.getCon();
				try {
					PreparedStatement st=con.prepareStatement(req);
					st.setString(1, u.getEmail());
					st.setString(2, u.getPassword());
					ResultSet rs= st.executeQuery();
					if(rs.next()) {
						return 1;
					}
					
				}catch(SQLException e) {
					System.out.println("login !!");
				}
				return 0;
			}
                        public boolean register(User o){
                            con=Connect.getCon();
				String req="INSERT INTO user VALUES (null,?,?,?,?,?);";
				try {
					PreparedStatement st=con.prepareStatement(req);
					st.setString(1, o.getNom());
					st.setString(2, o.getPrenom());
					st.setString(3, o.getEmail());
					st.setString(4, o.getPassword());
                                        st.setString(5, "user");
					st.executeUpdate();
				}catch(SQLException e) {
					System.out.println("register user !!");
					e.printStackTrace();
				}
				return false;
				
                        }
                        
			@Override
			public boolean create(User o) {
				con=Connect.getCon();
				String req="INSERT INTO user VALUES (null,?,?,?,?,?);";
				try {
					PreparedStatement st=con.prepareStatement(req);
					st.setString(1, o.getNom());
					st.setString(2, o.getPrenom());
					st.setString(3, o.getEmail());
					st.setString(4, o.getPassword());
                                        st.setString(5, o.getRole());
					st.executeUpdate();
				}catch(SQLException e) {
					System.out.println("add user !!");
					e.printStackTrace();
				}
				return false;
				
			}
			@Override
			public boolean update(User o) {
				con=Connect.getCon();
		String rq="UPDATE user SET nom=?,prenom=?,email=?,password=?,Role=? WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			st.setString(1, o.getNom());
			st.setString(2, o.getPrenom());
			st.setString(3, o.getEmail());
                        st.setString(4, o.getPassword());
                        st.setString(5, o.getRole());
			st.setInt(6, o.getId());
			st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("update user !!");
                        e.printStackTrace();
		}
		
		return false;
		}
			@Override
			public boolean delete(User o) {
				con=Connect.getCon();
		
		String req="DELETE FROM user WHERE id=?";
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setInt(1, o.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			System.err.println("delete user !!!");
                        e.printStackTrace();
		}
		
				return false;
			}
                        
			@Override
			public User findById(int id) {
				con=Connect.getCon();
		String rq="SELECT * FROM user WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(5));

			}
		}catch(SQLException e) {
			System.err.println("findById user !!");
		}
	
				return null;
			}
                        
			@Override
			public List<User> findAll() {
				List<User> lisUser=new ArrayList<>();
		String all="select * from user";
		con=Connect.getCon();
		try {
			PreparedStatement ps=con.prepareStatement(all);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				lisUser.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
                        System.err.println("findall user !!");
		}
				return lisUser;
			}
                        
                        	public String findRole(User u) {
				List<User> lisUser=new ArrayList<>();
		String all="SELECT Role from user where email=? ;";
		con=Connect.getCon();
		try {
			PreparedStatement ps=con.prepareStatement(all);
                        ps.setString(1, u.getEmail());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
                        System.err.println("findall user !!");
		}
				return null;
			}
                        
                        
			
			
}