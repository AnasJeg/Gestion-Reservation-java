/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package IHM;

import Card.component.Model_Card;
import Classes.*;
import Curve_Line.chart.*;
import Implements.CardService;
import Implements.ClientService;
import Implements.ReservationService;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.util.*;
import javas.chart.ModelPieChart;
import javas.chart.ModelPieChart2;
import javas.chart.ModelPieChartALL;

import javax.swing.ImageIcon;
/**
 *
 * @author anace
 */
public class Statistique_Inter extends javax.swing.JInternalFrame {
   
   java.sql.Connection con;
    ReservationService rs=new ReservationService();
    ClientService cs=new ClientService();
    CardService cds=new CardService();
   int idd;
     
    public Statistique_Inter() {
        
        initComponents();
        showCard1();
        showCard2();
        showCard3();
        showCard4();
        getcomC2();
      
        showChart2();
        
        curveLineChart1.setTitle("Nombre de chambre par categorie :");
        curveLineChart1.addLegend("NB Chambre", Color.YELLOW, Color.black);
      //  curveLineChart1.addLegend("categorie", Color.black, Color.black);
        showCurveLine();
      
        
    }
    /*
    public void showChart(){
            con= Connect.getCon();
		String req="select DISTINCT(c.libelle),count(ch.id) from chambre ch,categorie c where c.id=ch.ct group by ch.ct;";
		int cnt=0;
                try {
                    pieChart1.clearData();
			PreparedStatement st=con.prepareStatement(req);
			ResultSet res=st.executeQuery();
		while(res.next()){
                    
                    String nch=res.getString(1);
                    int nbrch=res.getInt(2);
                     pieChart1.addData(new ModelPieChart(nch,nbrch,getC(cnt++)));
                }
		}catch(SQLException e) {
			System.out.println("pieChart1 !!");
		}
                
    }
    */
    
   
     public void showCard1(){
            String vl=cds.DataClient().getValues();
         card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/client (1).png")), "Nombres des Clients", vl));         
    }
      public void showCard2(){
             String vl=cds.DataChambre().getValues();
           
         card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/chambre (1).png")), "Nombres des Chambres", vl));
     
                
    } public void showCard3(){
             String vl=cds.DataCat().getValues();
         card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/categorie (1).png")), "Nombres des Categories", vl));
     
                
    } public void showCard4(){
             String vl=cds.DataRes().getValues();
         card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/reservation (1).png")), "Nombres des Reservations", vl));
     
                
    }
     public void getcomC2() {   
	for(Client cr:cs.findAll()) {
			this.jComboBox1.addItem(cr);
		}
	
	}
     
    
      public void showChart2(){
        //    Client cS=(Client) jComboBox1.getSelectedItem();
      
          System.out.println("showChart2() id Client ==> "+idd);
            con= Connect.getCon();
	//	String req="select DISTINCT(c.nom),count(rs.id) from reservation rs,client c where c.id=rs.id_cl group by rs.id_cl;";
        //select EXTRACT(YEAR FROM date_debut),count(*) from reservation  where id_cl="+idd+" group by EXTRACT(YEAR FROM date_debut)
                String req="select EXTRACT(YEAR FROM date_debut),count(*) from reservation where id_cl =? group by EXTRACT(YEAR FROM date_debut)";
                int cnt=0;
                // java.sql.Date dd= new java.sql.Date(o.getDateDebut().getTime());
                try {
                    pieChart2.clearData();
			PreparedStatement st=con.prepareStatement(req);
                        st.setInt(1, idd);
			ResultSet res=st.executeQuery();
		while(res.next()){
                    String dd=res.getString(1);
                    double nbrch=res.getDouble(2);
                     pieChart2.addData(new ModelPieChart(dd,nbrch,getC2(cnt++)));
                }
		}catch(SQLException e) {
			System.out.println("pieChart2 !!");
		}
    }
    
    public Color getC(int c){
        Color[] col=new Color[]{new Color(51-204-255),new Color(255,255,153),new Color(153,153,153),new Color(255, 51, 51),new Color(1,1,1),new Color(102,255,102),new Color(1,1,1)};
       
        return col[c];
    }
    
   
    public Color getC2(int c){
        Color[] col=new Color[]{new Color(255, 51, 51),new Color(1,1,1),new Color(102,255,102),new Color(1,1,1)};
       
        return col[c];
    }
    

    public void showCurveLine(){
        con= Connect.getCon();
		// String req="select DISTINCT(c.nom),count(rs.id) from reservation rs,client c where c.id=rs.id_cl group by rs.id_cl;";
                String req="select DISTINCT(c.libelle),count(ch.id) from chambre ch,categorie c where c.id=ch.ct group by ch.ct;";
		List<Model_LineCH> lis=new ArrayList<>();
                try {
                    
                    curveLineChart1.clear();
			PreparedStatement st=con.prepareStatement(req);
			ResultSet res=st.executeQuery();
		while(res.next()){
                    String nch=res.getString(1);
                    double nbrch=res.getDouble(2);
                  //   pieChart2.addData(new ModelPieChart(nch,nbrch,getC(cnt++)));
                  lis.add(new Model_LineCH(nch,nbrch));
                }
                
                for(int i=lis.size()-1;i>=0;i--){
                    Model_LineCH md=lis.get(i);
                    curveLineChart1.addData(new ModelChart(md.getNch(),new double[]{md.getNbrch()}));
                }
                curveLineChart1.start();
		}catch(SQLException e) {
			System.out.println("showCurveLine !!");
		}
    }
    
   
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        pieChart2 = new javas.chart.PieChart();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        panelShadow1 = new Curve_Line.panel.PanelShadow();
        curveLineChart1 = new Curve_Line.chart.CurveLineChart();
        card1 = new IHM.CardShow();
        card2 = new IHM.CardShow();
        card3 = new IHM.CardShow();
        card4 = new IHM.CardShow();
        jButton1 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(998, 726));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText(" ");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 12)); // NOI18N
        jLabel2.setText("Les reservations d’un client par année");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        panelShadow1.setBackground(new java.awt.Color(204, 255, 255));

        curveLineChart1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reload.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pieChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(1, 1, 1)))))
                .addGap(13, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pieChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
              Client cS=(Client) jComboBox1.getSelectedItem();
         this.idd= cS.getId();
         showChart2();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showCard1();
        showCard2();
        showCard3();
        showCard4();
        getcomC2();
        showChart2();
        showCurveLine();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private IHM.CardShow card1;
    private IHM.CardShow card2;
    private IHM.CardShow card3;
    private IHM.CardShow card4;
    private Curve_Line.chart.CurveLineChart curveLineChart1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<Object> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private Curve_Line.panel.PanelShadow panelShadow1;
    private javas.chart.PieChart pieChart2;
    // End of variables declaration//GEN-END:variables
}
