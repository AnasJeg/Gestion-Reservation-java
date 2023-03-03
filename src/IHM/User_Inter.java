/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package IHM;

import Card.component.Model_Card;
import Classes.Client;
import Classes.Connect;
import Classes.Model_LineCH;
import Classes.User;
import Curve_Line.chart.ModelChart;
import Implements.*;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author anace
 */
public class User_Inter extends javax.swing.JInternalFrame {
        java.sql.Connection con;
    private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
	 private static final String regexT= "^[0-9]*$" ;
	  private static final String regexN= "^[a-zA-Z]*$" ;
	UserService sc=new UserService();
        private DefaultTableModel model;
       private static int id;
     CardService cds=new CardService();
     
     
    public User_Inter() {
        initComponents();
         model =(DefaultTableModel) jTable1.getModel();
         Table();
 
           curveLineChart1.setTitle("Nombre des utilisateurs :");
        curveLineChart1.addLegend("NB user", Color.YELLOW, Color.black);
       showCurveLine();
    
    }
 public void Table(){
      model.setRowCount(0);
     for(User us: sc.findAll()) {
            model.addRow(new Object[]{
            us.getId(),
            us.getNom(),
            us.getPrenom(),
            us.getEmail(),
            us.getPassword(),
            us.getRole(),
            });
     } 
   }
 
  
 
  public void showCurveLine(){
        con= Connect.getCon();
		// String req="select DISTINCT(c.nom),count(rs.id) from reservation rs,client c where c.id=rs.id_cl group by rs.id_cl;";
                String req="SELECT DISTINCT(Role) , COUNT(*) FROM user GROUP BY Role;";
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
			System.out.println("showCurveLine user !!");
		}
    }

    
  public void SearchTable(String ch){
         TableRowSorter<DefaultTableModel> tb=new TableRowSorter<>(model);
         jTable1.setRowSorter(tb);
         tb.setRowFilter(RowFilter.regexFilter(ch));
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        supp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Tn = new javax.swing.JTextField();
        Tp = new javax.swing.JTextField();
        Te = new javax.swing.JTextField();
        Tps = new javax.swing.JTextField();
        comRole = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        panelShadow1 = new Curve_Line.panel.PanelShadow();
        curveLineChart1 = new Curve_Line.chart.CurveLineChart();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        add.setBackground(new java.awt.Color(0, 255, 153));
        add.setText("Ajouter");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 204, 255));
        update.setText("Modifier");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        supp.setBackground(new java.awt.Color(255, 51, 51));
        supp.setText("Supprimer");
        supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom : ");

        jLabel2.setText("Prenom : ");

        jLabel3.setText("Email : ");

        jLabel4.setText("Password : ");

        jLabel5.setText("Role : ");

        Tn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TnKeyReleased(evt);
            }
        });

        Tp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TpKeyReleased(evt);
            }
        });

        Te.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TeKeyReleased(evt);
            }
        });

        Tps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TpsKeyReleased(evt);
            }
        });

        comRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nom", "Prenom", "Email", "Password", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        panelShadow1.setBackground(new java.awt.Color(0, 204, 153));
        panelShadow1.setColorGradient(new java.awt.Color(204, 255, 255));

        curveLineChart1.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 13, 13, 13));
        curveLineChart1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(curveLineChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curveLineChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel6.setText("Gestion des utilisateurs");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tps)
                            .addComponent(comRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Te)
                            .addComponent(Tp)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Tn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(supp, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Tn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Te, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(supp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
                                String n=Tn.getText();
				String p=Tp.getText();
				String te=Te.getText();
				String tps=Tps.getText();
                                String rl=comRole.getSelectedItem().toString();
				
				if(n.equals("") && p.equals("") && te.equals("") && tps.equals("") && rl.equals("")){
					JOptionPane.showMessageDialog(null, "les champs sont vides !");
				}else if(n.equals("") || !NPvalide(n)){
					JOptionPane.showMessageDialog(null, "nom  !");
				}else if(p.equals("") || !NPvalide(p)){
					JOptionPane.showMessageDialog(null, "prenom  !");
				}else if(te.equals("")|| !emailvalide(te)){
					JOptionPane.showMessageDialog(null, "email  !");
				}else if(tps.equals("")){
					JOptionPane.showMessageDialog(null, "password  !");
				}
				else {
				sc.update(new User(id,n,p,te,tps,rl));
				Table();
				Refresh();
                             showCurveLine();
				}
    }//GEN-LAST:event_updateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
                 int i=jTable1.getSelectedRow();
			    
			     id=(int) model.getValueAt(i, 0);
                             System.out.println("IHM.Client_Inter.jTable1MouseClicked()   "+id);
			    String nom=(String) model.getValueAt(i, 1);
			    Tn.setText(nom);
			    String prenom= (String) model.getValueAt(i, 2);
			    Tp.setText(prenom);
			    String email= (String) model.getValueAt(i, 3);
			    Te.setText(email);
			    String pass= (String) model.getValueAt(i, 4);
			    Tps.setText(pass);
                            String rl=(String) model.getValueAt(i, 5);
                            comRole.setSelectedItem(rl);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
                SearchTable(search.getText());
       
    }//GEN-LAST:event_searchKeyReleased

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       
                                String n=Tn.getText();
				String p=Tp.getText();
				String te=Te.getText();
				String tps=Tps.getText();
                                String rl=comRole.getSelectedItem().toString();
				
				if(n.equals("") && p.equals("") && te.equals("") && tps.equals("") && rl.equals("")){
					JOptionPane.showMessageDialog(null, "les champs sont vides !");
				}else if(n.equals("") || !NPvalide(n)){
					JOptionPane.showMessageDialog(null, "nom  !");
				}else if(p.equals("") || !NPvalide(p)){
					JOptionPane.showMessageDialog(null, "prenom  !");
				}else if(te.equals("")|| !emailvalide(te)){
					JOptionPane.showMessageDialog(null, "email  !");
				}else if(tps.equals("")){
					JOptionPane.showMessageDialog(null, "password  !");
				}
				else {
				sc.create(new User(n,p,te,tps,rl));
				Table();
				Refresh();
                         showCurveLine();
                         
                  
				}
    }//GEN-LAST:event_addActionPerformed

    private void suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppActionPerformed
                sc.delete(sc.findById(id));
                Table();
				Refresh();
                               showCurveLine();
                               
                               
    }//GEN-LAST:event_suppActionPerformed

    private void TnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TnKeyReleased
         if(!NPvalide(Tn.getText())) {
					Tn.setBorder(new LineBorder(Color.red,2));
				//	jLabel1.setText("mail invalide !!");
				}else {
					Tn.setBorder(new LineBorder(Color.green,1));
				//	jLabel1.setText(null);
				}
    }//GEN-LAST:event_TnKeyReleased

    private void TpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TpKeyReleased
        if(!NPvalide(Tp.getText())) {
					Tp.setBorder(new LineBorder(Color.red,2));
				//	jLabel1.setText("mail invalide !!");
				}else {
					Tp.setBorder(new LineBorder(Color.green,1));
				//	jLabel1.setText(null);
				}
    }//GEN-LAST:event_TpKeyReleased

    private void TeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeKeyReleased
        if(!emailvalide(Te.getText())) {
					Te.setBorder(new LineBorder(Color.red,2));
				//	jLabel1.setText("mail invalide !!");
				}else {
					Te.setBorder(new LineBorder(Color.green,1));
				//	jLabel1.setText(null);
				}
    }//GEN-LAST:event_TeKeyReleased

    private void TpsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TpsKeyReleased
                
    }//GEN-LAST:event_TpsKeyReleased

     
    /*
     public void showCard1(){
         cardShow1.setData(null);
            String vl=cds.DataClient().getValues();
         cardShow1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/user (1).png")), "Nombres des utilisateur", vl));         
    }
    */
     public boolean emailvalide(String em) {
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(em);
		return matcher.matches();
	}
    
	public boolean NPvalide(String tl) {
		Pattern p = Pattern.compile(regexN);
		Matcher matcher = p.matcher(tl);
		return matcher.matches();
	}
	
	public void Refresh() {
		Tn.setText("");
		Tp.setText("");
		Te.setText("");
		Tps.setText("");
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Te;
    private javax.swing.JTextField Tn;
    private javax.swing.JTextField Tp;
    private javax.swing.JTextField Tps;
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> comRole;
    private Curve_Line.chart.CurveLineChart curveLineChart1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Curve_Line.panel.PanelShadow panelShadow1;
    private javax.swing.JTextField search;
    private javax.swing.JButton supp;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
