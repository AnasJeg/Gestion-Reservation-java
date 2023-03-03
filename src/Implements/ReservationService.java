/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Classes.Chambre;
import Classes.Client;
import Classes.Connect;
import Classes.Reservation;
import DAO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javas.chart.ModelPieChart;

/**
 *
 * @author anace
 */
public class ReservationService implements IDAO<Reservation>{
	ClientService csl=new ClientService();
	ChambreService csh=new ChambreService();
	Connection con;
	@Override
	public boolean create(Reservation o) {
		
		con=(Connection) Connect.getCon();
		String req="INSERT INTO reservation VALUES (null,?,?,?,?);";
		try {
			PreparedStatement st=con.prepareStatement(req);
                        java.sql.Date dd= new java.sql.Date(o.getDateDebut().getTime());
			java.sql.Date df= new java.sql.Date(o.getDateFin().getTime());
		st.setInt(1,o.getId_client().getId());
		st.setInt(2, o.getId_chambre().getId());
		// st.setDate(3, (java.sql.Date) new Date(o.getDateDebut().getTime()));
		// st.setDate(4, (java.sql.Date) new Date(o.getDateFin().getTime()));
                st.setDate(3,dd );
		st.setDate(4,df );
                
			st.executeUpdate();
		}catch(SQLException e) {
			System.out.println("add Reservation !!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Reservation o) {
		con=(Connection) Connect.getCon();
		String rq="UPDATE reservation SET id_cl=?,id_ch=?,date_debut=? ,date_fin=? WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
                                java.sql.Date dd= new java.sql.Date(o.getDateDebut().getTime());
			java.sql.Date df= new java.sql.Date(o.getDateFin().getTime());
		st.setInt(1, o.getId_client().getId());
		st.setInt(2, o.getId_chambre().getId());
		// st.setDate(3, (java.sql.Date) new Date(o.getDateDebut().getTime()));
		// st.setDate(4, (java.sql.Date) new Date(o.getDateFin().getTime()));
                st.setDate(3,dd );
		st.setDate(4,df );
		st.setInt(5, o.getId());
		st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("update Reservation !!");
		}
		
		return false;
	}

	@Override
	public boolean delete(Reservation o) {
            con=(Connection) Connect.getCon();
		
		String req="DELETE FROM reservation WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setInt(1, o.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			System.err.println("delete Reservation !!!");
		}
		return false;
	}

	@Override
	public Reservation findById(int id) {
		con=(Connection) Connect.getCon();
		String rq="SELECT * FROM reservation WHERE id=?;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			return new Reservation(rs.getInt(1),csl.findById(rs.getInt(2)),csh.findById(rs.getInt(3)),rs.getDate(4),rs.getDate(5));
			}
		}catch(SQLException e) {
			System.err.println("findById Reservation !!");
		}
		return null;
	}

	@Override
	public List<Reservation> findAll() {
		List<Reservation> lisC=new ArrayList<Reservation>();
		con=(Connection) Connect.getCon();
		String rq="SELECT * FROM reservation ;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Reservation c=new Reservation(rs.getInt(1),csl.findById(rs.getInt(2)),csh.findById(rs.getInt(3)),rs.getDate(4),rs.getDate(5));
			lisC.add(c);
			}
		}catch(SQLException e) {
			System.err.println("findAll Reservation !!");
		}
		return lisC;
	}
	
        public List<Client> findClient() {
		List<Client> lisC=new ArrayList<Client>();
		con=(Connection) Connect.getCon();
		String rq="SELECT distinct id_cl FROM reservation;";
		try {
			PreparedStatement st=con.prepareStatement(rq);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Client c=csl.findById(rs.getInt(1));          
			lisC.add(c);
			}
		}catch(SQLException e) {
			System.err.println("findAll Reservation Client !!");
		}
		return lisC;
	}
        
	public List<Chambre> findChambreBetweenDates(Client c,Date dateDebut,Date dateFin){
		con=(Connection) Connect.getCon();
		List<Chambre> lisRCH=new ArrayList<Chambre>();
		String req="SELECT * FROM reservation WHERE id_cl=? AND ( date_debut > ? AND date_fin < ? );";
                    java.sql.Date dd= new java.sql.Date(dateDebut.getTime());
			java.sql.Date df= new java.sql.Date(dateFin.getTime());
		try {
			PreparedStatement st=con.prepareStatement(req);
			st.setInt(1, c.getId());
			st.setDate(2,dd);
			st.setDate(3, df);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Chambre ch=new Chambre(csh.findById(rs.getInt(3)).getId(),csh.findById(rs.getInt(3)).getTell(),csh.findById(rs.getInt(3)).getCt());
				lisRCH.add(ch);
			}
		}catch(SQLException e) {
			System.err.println("err findChambreBetweenDates !!");
		}
			/* for(Reservation res: this.findAll()) {
		
				if(c.getId()==res.getId_client().getId()) {
				if(res.getDateDebut().after(dateDebut) && res.getDateFin().before(dateFin)) {
					Chambre ch=new Chambre(res.getId_chambre().getTell(),res.getId_chambre().getCt());
					lisRCH.add(ch);
				}else {
					System.err.println("findChambreBetweenDates!!!!");
				}
				
				}
			} */
				return lisRCH;	
}

        
               public boolean checkRes(Chambre c,Date dateDebut,Date dateFin){
          
           con= Connect.getCon();
		  String req="select * from reservation r  where ( (r.date_debut>=? and r.date_fin<=?) or (? between r.date_debut and r.date_fin) or (? between r.date_debut and r.date_fin) )and r.id_ch=?";
                 java.sql.Date dd= new java.sql.Date(dateDebut.getTime());
			java.sql.Date df= new java.sql.Date(dateFin.getTime());
                try {
                 
			PreparedStatement st=con.prepareStatement(req);
                       // st.setInt(1, c.getId());
                        st.setDate(1, dd);
                        st.setDate(2,  df);
                        st.setDate(3, dd);
                        st.setDate(4, df);
                        st.setInt(5, c.getId());
                        
                      //  st.setDate(2, (java.sql.Date) new Date(dateDebut.getTime()));
                      //  st.setDate(3, (java.sql.Date) new Date(dateFin.getTime()));
                        
			ResultSet res=st.executeQuery();
		while(res.next()){
                    return true;
                }
             
		}catch(SQLException e) {
			System.out.println("checkRes !!");
                        e.printStackTrace();
		}
        return false;
       }
               
            
               
             
}

