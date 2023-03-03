/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Date;

/**
 *
 * @author anace
 */
public class Reservation {
	
	private int id;
		private Client id_client;
		private Chambre id_chambre;
		private Date dateDebut;
		private Date dateFin;
		private static int cnt=0;

    public Reservation(Client id_client, Chambre id_chambre, Date dateDebut, Date dateFin) {
        this.id = ++cnt;
        this.id_client = id_client;
        this.id_chambre = id_chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Reservation(int id, Client id_client, Chambre id_chambre, Date dateDebut, Date dateFin) {
        this.id = id;
        this.id_client = id_client;
        this.id_chambre = id_chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

		public int getId() {
			return id;
		}


		
		public Client getId_client() {
			return id_client;
		}


		public void setId_client(Client id_client) {
			this.id_client = id_client;
		}


		public Chambre getId_chambre() {
			return id_chambre;
		}


		public void setId_chambre(Chambre id_chambre) {
			this.id_chambre = id_chambre;
		}

		public Date getDateDebut() {
			return dateDebut;
		}
		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}
		public Date getDateFin() {
			return dateFin;
		}
		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}

                
		@Override
		public String toString() {
			return ""+id_client;
		}

}
