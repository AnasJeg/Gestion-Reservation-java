/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IHM;

/**
 *
 * @author anace
 */
public class Menu_Inter extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Inter
     */
    Client_Inter clt = new Client_Inter();
    Chambre_Inter chm = new Chambre_Inter();
    Categorie_Inter ctg = new Categorie_Inter();
    Reservastion_Inter rsv = new Reservastion_Inter();
    Statistique_Inter Mchart = new Statistique_Inter();
    User_Inter user = new User_Inter();

    public Menu_Inter() {
        initComponents();
   
    }

    public Menu_Inter(String role) {
     initComponents();
        if(role.equals("admin")){
            userservice.show();
        }else{
            userservice.hide();
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

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        Statistique = new javax.swing.JButton();
        Clients = new javax.swing.JButton();
        Chambres = new javax.swing.JButton();
        Categories = new javax.swing.JButton();
        Reservations = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        userservice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jDesktopPane1.setEnabled(false);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 997, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
        );

        Statistique.setBackground(new java.awt.Color(0, 0, 0));
        Statistique.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        Statistique.setForeground(new java.awt.Color(204, 204, 0));
        Statistique.setText("Statistique");
        Statistique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatistiqueActionPerformed(evt);
            }
        });

        Clients.setBackground(new java.awt.Color(0, 0, 0));
        Clients.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        Clients.setForeground(new java.awt.Color(204, 204, 0));
        Clients.setText(" Clients");
        Clients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientsActionPerformed(evt);
            }
        });

        Chambres.setBackground(new java.awt.Color(0, 0, 0));
        Chambres.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        Chambres.setForeground(new java.awt.Color(204, 204, 0));
        Chambres.setText("Chambres");
        Chambres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChambresActionPerformed(evt);
            }
        });

        Categories.setBackground(new java.awt.Color(0, 0, 0));
        Categories.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        Categories.setForeground(new java.awt.Color(204, 204, 0));
        Categories.setText("Categories");
        Categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriesActionPerformed(evt);
            }
        });

        Reservations.setBackground(new java.awt.Color(0, 0, 0));
        Reservations.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        Reservations.setForeground(new java.awt.Color(204, 204, 0));
        Reservations.setText("Reservations");
        Reservations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservationsActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lg.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/statistics.png"))); // NOI18N

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit (1).png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        userservice.setBackground(new java.awt.Color(0, 0, 0));
        userservice.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        userservice.setForeground(new java.awt.Color(204, 204, 0));
        userservice.setText("UserService");
        userservice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userserviceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Reservations, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Categories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Chambres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Clients, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Statistique, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userservice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(Statistique, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(Clients, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(Chambres, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Categories, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Reservations, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userservice, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StatistiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatistiqueActionPerformed

        jDesktopPane1.removeAll();
        jDesktopPane1.add(Mchart);
        jDesktopPane1.remove(rsv);
        jDesktopPane1.remove(ctg);
        jDesktopPane1.remove(chm);
        jDesktopPane1.remove(clt);
        jDesktopPane1.remove(user);
        Mchart.show();
    }//GEN-LAST:event_StatistiqueActionPerformed

    private void ClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientsActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.add(clt);
        rsv.hide();
        ctg.hide();
        chm.hide();
        Mchart.hide();
        user.hide();
        clt.show();
    }//GEN-LAST:event_ClientsActionPerformed

    private void ChambresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChambresActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.add(chm);
        clt.hide();
        rsv.hide();
        ctg.hide();
        Mchart.hide();
        user.hide();
        chm.show();
    }//GEN-LAST:event_ChambresActionPerformed

    private void CategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriesActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.add(ctg);
        clt.hide();
        rsv.hide();
        chm.hide();
        Mchart.hide();
        user.hide();
        ctg.show();
    }//GEN-LAST:event_CategoriesActionPerformed

    private void ReservationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservationsActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.add(rsv);
        clt.hide();
        ctg.hide();
        chm.hide();
        Mchart.hide();
        user.hide();
        rsv.show();

    }//GEN-LAST:event_ReservationsActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        Login_Inter lg = new Login_Inter();
        this.hide();
        lg.show();
    }//GEN-LAST:event_exitActionPerformed

    private void userserviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userserviceActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.add(user);
        jDesktopPane1.remove(rsv);
        jDesktopPane1.remove(ctg);
        jDesktopPane1.remove(chm);
        jDesktopPane1.remove(clt);
        jDesktopPane1.remove(Mchart);
        user.show();
    }//GEN-LAST:event_userserviceActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Categories;
    private javax.swing.JButton Chambres;
    private javax.swing.JButton Clients;
    private javax.swing.JButton Reservations;
    private javax.swing.JButton Statistique;
    private javax.swing.JButton exit;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton userservice;
    // End of variables declaration//GEN-END:variables
}
