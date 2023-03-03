/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Classes.Client;
import Classes.Connect;
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
public class ClientService implements IDAO<Client>{
	Connection con;
	@Override
	public boolean create(Client o) {
		con=Connect.getCon();
		String req="INSERT INTO client VALUES (null,?,?,?,?);";
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setString(1, o.getNom());
			st.setString(2, o.getPrenom());
			st.setString(3, o.getTell());
			st.setString(4, o.getEmail());
			st.executeUpdate();
		}catch(SQLException e) {
			System.out.println("add Client !!");
                        e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Client o) {
		con=Connect.getCon();
		String rq="UPDATE client SET nom=?,prenom=?,tell=?,email=? WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			st.setString(1, o.getNom());
			st.setString(2, o.getPrenom());
			st.setString(3, o.getTell());
			st.setString(4, o.getEmail());
			st.setInt(5, o.getId());
			st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("update Client !!");
                        e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Client o) {
		con=Connect.getCon();
		
		String req="DELETE FROM client WHERE id=?";
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setInt(1, o.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			System.err.println("delete Client !!!");
                        e.printStackTrace();
		}
		return false;
	}

	@Override
	public Client findById(int id) {
		con=Connect.getCon();
		String rq="SELECT * FROM client WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			//	Client c=new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			return new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
					
			//	return c;
			}
		}catch(SQLException e) {
			System.err.println("findById client !!");
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
	/*	
            List<Client> lisC=new ArrayList<Client>();
		con=Connect.getCon();
		String rq="SELECT * FROM client ;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Client c=new Client(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			lisC.add(c);
			}
		}catch(SQLException e) {
			System.err.println("findById client !!");
		}
		return lisC;
                */
                List<Client> listClient=new ArrayList<>();
		String all="select * from client";
		con=Connect.getCon();
		try {
			PreparedStatement ps=con.prepareStatement(all);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Client client=new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				listClient.add(client);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}

}
