/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author anace
 */
public class Client {

    
		private int id;
		private String nom;
		private String prenom;
		private String tell;
		private String email;
		private static int cnt=0;
		
		public Client(String nom, String prenom, String tell, String email) {
			super();
			this.id = ++cnt;
			this.nom = nom;
			this.prenom = prenom;
			this.tell = tell;
			this.email = email;
		}
				//const 2
		public Client(int id, String nom, String prenom, String tell, String email) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.tell = tell;
			this.email = email;
		}



		public int getId() {
			return id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getTell() {
			return tell;
		}

		public void setTell(String tell) {
			this.tell = tell;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return nom;
		}
		
		


}
