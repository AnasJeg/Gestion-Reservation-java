/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anace
 */
public class Connect {
   static Connection con;
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			//	con=DriverManager.getConnection("jdbc:mysql://localhost/Gestion_reservation","root","");
				con=DriverManager.getConnection("jdbc:mysql://localhost/G_Reservastion","root","");	
                                System.out.println("con");
			}catch(ClassNotFoundException e) {
				System.err.println("Probleme PILOTE !!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("Probleme DB");
			}
		}
		
		public static Connection getCon() {
			return con;
		} 
}
