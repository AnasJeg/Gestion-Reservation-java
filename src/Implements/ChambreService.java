/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Classes.Categorie;
import Classes.Chambre;
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
public class ChambreService implements IDAO<Chambre>{
	Connection con;
	CategorieService cs=new CategorieService();
	@Override
	public boolean create(Chambre o) {
		con=(Connection) Connect.getCon();
		String req="INSERT INTO chambre VALUES (null,?,?);";
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setString(1, o.getTell());
			st.setInt(2, o.getCt().getId());
		st.executeUpdate();
		}catch(SQLException e) {
			System.out.println("add Chambre !!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Chambre o) {
		con=(Connection) Connect.getCon();
		String rq="UPDATE Chambre SET tell=?,ct=? WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
		st.setString(1, o.getTell());
		st.setInt(2, o.getCt().getId());
		st.setInt(3, o.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			System.out.println("update Chambre !!");
		}
		
		return false;
	}

	@Override
	public boolean delete(Chambre o) {
		con=(Connection) Connect.getCon();
		
		String req="DELETE FROM chambre WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setInt(1, o.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			System.err.println("delete Chambre !!!");
		}
		return false;
	}

	@Override
	public Chambre findById(int id) {
		con=(Connection) Connect.getCon();
		String rq="SELECT * FROM chambre WHERE id=?;";
		
		try {
			PreparedStatement st=con.prepareStatement(rq);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			return new Chambre(rs.getInt(1),rs.getString(2),cs.findById(rs.getInt(3)));
			}
		}catch(SQLException e) {
			System.err.println("findById Chambre !!");
		}
		return null;
	}

	@Override
	public List<Chambre> findAll() {
		List<Chambre> lisC=new ArrayList<Chambre>();
		con=(Connection) Connect.getCon();
		String rq="SELECT * FROM chambre ;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Chambre c=new Chambre(rs.getInt(1),rs.getString(2),cs.findById(rs.getInt(3)));
			lisC.add(c);
			}
		}catch(SQLException e) {
			System.err.println("findById Chambre !!");
		}
		return lisC;
	}
	
	
	
	public List<Chambre> findChambreByCategorie(Categorie c){
		List<Chambre> lisCHB=new ArrayList<Chambre>();
		
		  for(Chambre ch: this.findAll()) { 
			if(c.getId()==ch.getCt().getId()) {
				lisCHB.add(ch);
			}
		}
			
		return lisCHB;
		
	}

}

