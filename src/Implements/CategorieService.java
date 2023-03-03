/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Classes.Categorie;
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
public class CategorieService implements IDAO<Categorie> {

	Connection con;
	@Override
	public boolean create(Categorie o) {
		con=Connect.getCon();
		String req="INSERT INTO categorie VALUES (null,?,?);";
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setString(1, o.getCode());
			st.setString(2, o.getLibelle());
			st.executeUpdate();
		
		}catch(SQLException e) {
			System.out.println("add Categorie !!");
		}
		return false;
	}

	@Override
	public boolean update(Categorie o) {
		con=Connect.getCon();
		String rq="UPDATE categorie SET code=?,libelle=? WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
		st.setString(1, o.getCode());
		st.setString(2, o.getLibelle());
		st.setInt(3, o.getId());
		st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("update Categorie !!");
		}
		
		return false;
	}

	@Override
	public boolean delete(Categorie o) {
		con=Connect.getCon();
		
		String req="DELETE FROM categorie WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setInt(1, o.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			System.err.println("delete Categorie !!!");
		}
		return false;
	}

	@Override
	public Categorie findById(int id) {
		con=Connect.getCon();
		String rq="SELECT * FROM categorie WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			return new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		}catch(SQLException e) {
			System.err.println("findById Categorie !!");
		}
		return null;
	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> lisC=new ArrayList<Categorie>();
		con=Connect.getCon();
		String rq="SELECT * FROM categorie ;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Categorie c=new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3));
			lisC.add(c);
			}
		}catch(SQLException e) {
			System.err.println("findById Categorie !!");
		}
		return lisC;
	}


}

