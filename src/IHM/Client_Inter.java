/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package IHM;

import Classes.Client;
import Implements.ClientService;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.util.Arrays.sort;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author anace
 */
public class Client_Inter extends javax.swing.JInternalFrame {

     private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
	 private static final String regexT= "^[0-9]*$" ;
	  private static final String regexN= "^[a-zA-Z]*$" ;
	ClientService sc=new ClientService();
        private DefaultTableModel model;
       private static int id;

    
    public Client_Inter() {
       
        initComponents();
       
        model =(DefaultTableModel) jTable1.getModel();
         Table();
    
        
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        del = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Tn = new javax.swing.JTextField();
        Tp = new javax.swing.JTextField();
        Temail = new javax.swing.JTextField();
        Ttell = new javax.swing.JTextField();
        search = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(998, 726));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nom", "Prenom", "Tell", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        Add.setBackground(new java.awt.Color(0, 255, 153));
        Add.setText("Ajouter");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(0, 204, 255));
        Update.setText("Modifier");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        del.setBackground(new java.awt.Color(255, 51, 51));
        del.setText("Supprimer");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom  : ");

        jLabel2.setText("Prenom :");

        jLabel3.setText("Email : ");

        jLabel4.setText("Tell :");

        Tn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TnFocusLost(evt);
            }
        });
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

        Temail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TemailKeyReleased(evt);
            }
        });

        Ttell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TtellKeyReleased(evt);
            }
        });

        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tp, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Temail, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tn, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Ttell, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Temail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Ttell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(64, 64, 64)
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Tn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Gestion des Clients");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void TemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TemailKeyReleased
        if(!emailvalide(Temail.getText())) {
					Temail.setBorder(new LineBorder(Color.red,2));
				//	jLabel1.setText("mail invalide !!");
                                
				}else {
					Temail.setBorder(new LineBorder(Color.green,1));
				//	jLabel1.setText(null);
				}
    }//GEN-LAST:event_TemailKeyReleased

    private void TtellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TtellKeyReleased
        if(!Tellvalide(Ttell.getText())) {
					Ttell.setBorder(new LineBorder(Color.red,2));
				//	jLabel1.setText("mail invalide !!");
				}else {
					Ttell.setBorder(new LineBorder(Color.green,1));
				//	jLabel1.setText(null);
				}
    }//GEN-LAST:event_TtellKeyReleased

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
       
				String n=Tn.getText();
				String p=Tp.getText();
				String tl=Ttell.getText();
				String tm=Temail.getText();
				
				if(n.equals("") && p.equals("") && tl.equals("") && tm.equals("")){
					JOptionPane.showMessageDialog(null, "les champs sont vides !");
				}else
				if(n.equals("") || !NPvalide(n)){
					JOptionPane.showMessageDialog(null, "nom vide ou invalide !");
				}else if(p.equals("") || !NPvalide(p)){
					JOptionPane.showMessageDialog(null, "prenom vide ou invalide !");
				}else if(tl.equals("") || !Tellvalide(tl)){
					JOptionPane.showMessageDialog(null, "tell vide ou invalide!");
				}else if(tm.equals("")|| !emailvalide(tm)){
					JOptionPane.showMessageDialog(null, "email vide ou invalide !");
				}
				else {
				sc.create(new Client(n,p,tl,tm));
				Table();
				Refresh();
				}
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
                              ClientService sc=new ClientService();
				String n=Tn.getText();
				String p=Tp.getText();
				String tl=Ttell.getText();
				String tm=Temail.getText();
				System.out.println(id);
				if(n.equals("") && p.equals("") && tl.equals("") && tm.equals("")){
					JOptionPane.showMessageDialog(null, "les champs sont vides !");
				}else
				if(n.equals("") || !NPvalide(n)){
					JOptionPane.showMessageDialog(null, "nom vide ou invalide !");
				}else if(p.equals("") || !NPvalide(p)){
					JOptionPane.showMessageDialog(null, "prenom vide ou invalide !");
				}else if(tl.equals("") || !Tellvalide(tl)){
					JOptionPane.showMessageDialog(null, "tell vide ou invalide!");
				}else if(tm.equals("")|| !emailvalide(tm)){
					JOptionPane.showMessageDialog(null, "email vide ou invalide !");
				}
				else {
				sc.update(new Client(id,n,p,tl,tm));
				Table();
				Refresh();
				}
    }//GEN-LAST:event_UpdateActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        	ClientService sc=new ClientService();
				String n=Tn.getText();
				String p=Tp.getText();
				String tl=Ttell.getText();
				String tm=Temail.getText();
			//	Client ccc=new Client(id,n,p,tl,tm);
		
				sc.delete(sc.findById(id));
				Table();
				Refresh();
				
    }//GEN-LAST:event_delActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      //  id=(int) model.getValueAt(jTable1.getSelectedRow(), 0);
      /*
      id = Integer.parseInt(model.getValueAt(jTable1.getSelectedRow(), 0).toString());
        Tn.setText(model.getValueAt(jTable1.getSelectedRow(), 1).toString());
        Tp.setText(model.getValueAt(jTable1.getSelectedRow(), 2).toString());
        Ttell.setText(model.getValueAt(jTable1.getSelectedRow(), 3).toString());
        Temail.setText(model.getValueAt(jTable1.getSelectedRow(),4).toString());
        */
                         int i=jTable1.getSelectedRow();
			    
			     id=(int) model.getValueAt(i, 0);
                             System.out.println("IHM.Client_Inter.jTable1MouseClicked()   "+id);
			    String nom=(String) model.getValueAt(i, 1);
			    Tn.setText(nom);
			    String prenom= (String) model.getValueAt(i, 2);
			    Tp.setText(prenom);
			    String tell= (String) model.getValueAt(i, 3);
			    Ttell.setText(tell);
			    String email= (String) model.getValueAt(i, 4);
			    Temail.setText(email);
   //     JOptionPane.showMessageDialog(null, "id  !"+id);
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        if(search.getText().equals("")){
            search.setText("Nom a chercher...");
            search.setForeground(Color.gray);
        }
        
    }//GEN-LAST:event_searchFocusLost

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
         if(search.getText().equals("Nom a chercher...")){
            search.setText("");
            search.setForeground(Color.black);
        }
        
    }//GEN-LAST:event_searchFocusGained

    private void TnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TnFocusGained

    private void TnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TnFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TnFocusLost

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        SearchTable(search.getText());
    }//GEN-LAST:event_searchKeyReleased

    public void Table(){
      model.setRowCount(0);
     for(Client client : sc.findAll()) {
            model.addRow(new Object[]{
            client.getId(),
            client.getNom(),
            client.getPrenom(),
            client.getTell(),
            client.getEmail(),
            });
     } 
   }
    
     public void SearchTable(String ch){
         TableRowSorter<DefaultTableModel> tb=new TableRowSorter<>(model);
         jTable1.setRowSorter(tb);
         tb.setRowFilter(RowFilter.regexFilter(ch));
     }
     
    public boolean emailvalide(String em) {
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(em);
		return matcher.matches();
	}
    
    public boolean Tellvalide(String tl) {
		Pattern p = Pattern.compile(regexT);
		Matcher matcher = p.matcher(tl);
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
		Ttell.setText("");
		Temail.setText("");
	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField Temail;
    private javax.swing.JTextField Tn;
    private javax.swing.JTextField Tp;
    private javax.swing.JTextField Ttell;
    private javax.swing.JButton Update;
    private javax.swing.JButton del;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
