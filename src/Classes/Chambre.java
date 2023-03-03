/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author anace
 */
public class Chambre {
	private int id;
		private String tell;
		private Categorie ct;
		private static int cnt=0;
		
		public Chambre(String tell,Categorie id_ct) {
			super();
			this.id = ++cnt;
			this.tell = tell;
			this.ct = id_ct;
		}

		public Chambre(int id, String tell, Categorie ct) {
			super();
			this.id = id;
			this.tell = tell;
			this.ct = ct;
		}

		public int getId() {
			return id;
		}
		
		public String getTell() {
			return tell;
		}

		public void setTell(String tell) {
			this.tell = tell;
		}

		public Categorie getCt() {
			return ct;
		}

		public void setCt(Categorie ct) {
			this.ct = ct;
		}

		

@Override
public String toString() {
	return id +" "+ct.toString() ;
}

}
