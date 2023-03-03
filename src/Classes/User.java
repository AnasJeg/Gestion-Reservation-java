/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author anace
 */
public class User {
    private int id;
		private String nom;
		private String prenom;
		private String email;
		private String password;
                private String role;
		private static int cnt=0;
		
		public User(int id,String nom, String prenom, String email, String password,String role) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
                        this.role=role;
		}
                
		public User(String nom, String prenom, String email, String password) {
			super();
			this.id = ++cnt;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
		}
                public User(String nom, String prenom, String email, String password,String role) {
			super();
			this.id = ++cnt;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
                        this.role=role;
		}

		public User( String email, String password) {
			this.email = email;
			this.password = password;
                      
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
		
		
}
