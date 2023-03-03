/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IHM;

import Classes.Connect;
import Classes.Model_LineCH;
import Curve_Line.chart.ModelChart;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anace
 */
public class Test extends javax.swing.JFrame {

     java.sql.Connection con;
    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
           curveLineChart1.setTitle("nombre :");
        curveLineChart1.addLegend("NB Chambre", Color.YELLOW, Color.black);
      //  curveLineChart1.addLegend("categorie", Color.black, Color.black);
        showCurveLine();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new Curve_Line.panel.PanelShadow();
        curveLineChart1 = new Curve_Line.chart.CurveLineChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(204, 255, 204));

        curveLineChart1.setBackground(new java.awt.Color(204, 255, 204));
        curveLineChart1.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 11, 11));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

       public void showCurveLine(){
        con= Connect.getCon();
		// String req="select DISTINCT(c.nom),count(rs.id) from reservation rs,client c where c.id=rs.id_cl group by rs.id_cl;";
                String req="select DISTINCT(c.libelle),count(ch.id) from chambre ch,categorie c where c.id=ch.ct group by ch.ct;";
		List<Model_LineCH> lis=new ArrayList<>();
                try {
                  //  pieChart2.clearData();
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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Curve_Line.chart.CurveLineChart curveLineChart1;
    private Curve_Line.panel.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}