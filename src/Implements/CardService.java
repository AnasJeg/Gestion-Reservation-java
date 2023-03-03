/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Card.component.Model_Card;
import Classes.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author anace
 */
public class CardService {
        Connection con;
    public Model_Card DataClient(){
          con= Connect.getCon();
		String req="select count(*) from client;";
		int cnt=0;
                try {
                    
			PreparedStatement st=con.prepareStatement(req);
			ResultSet res=st.executeQuery();
		while(res.next()){
                    String vl=res.getString(1);
                    return new Model_Card(vl);
               //      card1.add(new Model_Card(nch,nbrch));
                }
		}catch(SQLException e) {
			System.out.println("cardservice client !!");
		}
                return null;
    }
    
     public Model_Card DataChambre(){
          con= Connect.getCon();
		String req="select count(*) from chambre;";
		int cnt=0;
                try {
                    
			PreparedStatement st=con.prepareStatement(req);
			ResultSet res=st.executeQuery();
		while(res.next()){
                    String vl=res.getString(1);
                    return new Model_Card(vl);
               //      card1.add(new Model_Card(nch,nbrch));
                }
		}catch(SQLException e) {
			System.out.println("cardservice chambre !!");
		}
                return null;
    }
     
      
     
       public Model_Card DataCat(){
          con= Connect.getCon();
		String req="select count(*) from categorie;";
		int cnt=0;
                try {
                    
			PreparedStatement st=con.prepareStatement(req);
			ResultSet res=st.executeQuery();
		while(res.next()){
                    String vl=res.getString(1);
                    return new Model_Card(vl);
               //      card1.add(new Model_Card(nch,nbrch));
                }
		}catch(SQLException e) {
			System.out.println("cardservice categorie !!");
		}
                return null;
    }
       
        public Model_Card DataRes(){
          con= Connect.getCon();
		String req="select count(*) from reservation;";
		int cnt=0;
                try {
                    
			PreparedStatement st=con.prepareStatement(req);
			ResultSet res=st.executeQuery();
		while(res.next()){
                    String vl=res.getString(1);
                    return new Model_Card(vl);
               //      card1.add(new Model_Card(nch,nbrch));
                }
		}catch(SQLException e) {
			System.out.println("cardservice reservation !!");
		}
                return null;
    }
        
         public Model_Card DataUser(){
          con= Connect.getCon();
		String req="select count(*) from user;";
		int cnt=0;
                try {
                    
			PreparedStatement st=con.prepareStatement(req);
			ResultSet res=st.executeQuery();
		while(res.next()){
                    String vl=res.getString(1);
                    return new Model_Card(vl);
               //      card1.add(new Model_Card(nch,nbrch));
                }
		}catch(SQLException e) {
			System.out.println("cardservice user !!");
		}
                return null;
    }
}
