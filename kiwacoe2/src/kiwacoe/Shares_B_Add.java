/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import static kiwacoe.Login.user;

/**
 *
 * @author user
 */
public class Shares_B_Add extends javax.swing.JDialog {

     ResultSet rs = null;
          public String mx,sql;

        PreparedStatement pst = null;
        public String xuserid,xyr,xmon,xtyp; 
    /**
     * Creates new form Users_add
     */
    public Shares_B_Add(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
      initComponents();
      String qym[]=  GetMonth.set_yr_mon();
      mon.setSelectedItem(qym[0]);
      yr.setSelectedItem(qym[1]);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        mon = new javax.swing.JComboBox<>();
        yr = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        typ = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Month");

        jLabel2.setText("Year");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        mon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Feburuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        yr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));

        jLabel3.setText("Shares Type");

        typ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deposit", "Share Capital", "Withdrawals", "Adjustiments" }));
        typ.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typ, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(97, 97, 97)
                        .addComponent(jButton2)))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int ind=0;
        getdata(); 
         try {
             if (Validate_period.validate(xyr, xmon) > 0)//check if period is open
             {
                 
                 //  MessageBox.infoBox("Period Closed Successfully", "Close Period");
                 
             } else {  //if period is not open
                 MessageBox.infoBox("Period Not Open!!", "Close Period");
                 return;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Shares_B_Add.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
           ind=  ifexists();
         } catch (SQLException ex) {
             Logger.getLogger(Payments_B_add.class.getName()).log(Level.SEVERE, null, ex);
         }
         if (ind>0)
         {
           MessageBox.infoBox("Batch Already Exists", "Create Batch");
           return;
         }
       Connection conn =DBconnect.ConnecrDb();   
               sql = "insert into  shbatches (yr,mon,recs,stat,bdate,tot,typ) "
                       + "values('"+xyr+"','"+xmon+"',0,'Open',CURDATE(),0,'"+xtyp+"')";
                
         
         System.out.println(sql);
          try {
             
              
              pst=conn.prepareStatement(sql);
              pst.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Users_add.class.getName()).log(Level.SEVERE, null, ex);
              MessageBox.infoBox(ex.toString(), "New Expenses Batch");
              return;
         //     msbbox.show(Alert.AlertType.ERROR, ex.toString(),"SQL Error" ,"ffff");
          }

 //  msbbox.show(Alert.AlertType.ERROR, "New record saved successfully","New Record" ,"ffff");       
   // Members_listController zn = new Members_listController();
   MessageBox.infoBox("Batch Created Successfully", "New Expenses Batch");
   
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          Shares_B_Add.this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Users_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Users_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Users_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Users_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Users_add dialog = new Users_add(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    public void getdata()
{
    
    xyr=yr.getSelectedItem().toString();
    xmon = String.format("%02d", mon.getSelectedIndex() + 1);
    xtyp=typ.getSelectedItem().toString();

   
}

 public int ifexists() throws SQLException 
 {
     int x = 0;
     String sql = "SELECT yr,mon,typ,COUNT(*) as count FROM shbatches  where yr='" + xyr + "' and mon='" + xmon + "' and typ='"+xtyp+"'   group by yr,mon,typ";
     Connection connx = DBconnect.ConnecrDb();
     pst = connx.prepareStatement(sql);

     rs = pst.executeQuery();
     //rs.first();
     while (rs.next()) {
        // user = rs.getString("userid");
       //  pwd = rs.getString("pass");
      //   typ = rs.getString("typ");
         x = Integer.valueOf(rs.getString("count"));
     }

     return x;
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> mon;
    private javax.swing.JComboBox<String> typ;
    private javax.swing.JComboBox<String> yr;
    // End of variables declaration//GEN-END:variables
}
