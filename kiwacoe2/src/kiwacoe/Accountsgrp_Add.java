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
import javax.swing.JComboBox;
import javax.swing.JTextField;



/**
 *
 * @author user
 */
public class Accountsgrp_Add extends javax.swing.JDialog {

     ResultSet rs = null;
          public String mx,sql;

        PreparedStatement pst = null;
        public String xaccno,xnam,xtyp,xgrp,xintrtyp;
        static String pind,zaccno;
    /**
     * Creates new form Users_add
     */
    public Accountsgrp_Add(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         ok.setText(pind);
        if(pind.equals("Add"))
        {
            
        }else
        {
          poputate_fields();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        accno = new javax.swing.JTextField();
        nam = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        grp = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Group Code");

        jLabel2.setText("Group  Name");

        accno.setEditable(false);

        ok.setText("Save");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Class");

        grp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asset", "Capital", "Expense", "Income", "Liability" }));
        grp.setToolTipText("");
        grp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(grp, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(accno, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(ok)
                        .addGap(166, 166, 166)
                        .addComponent(jButton2)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(grp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(accno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ok)
                    .addComponent(jButton2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
         int mm=accno.getText().toString().length();
         if(mm!=4)
         {
             MessageBox.infoBox("Group Code Must be 4 Characters!!", "Error");
             return;
         }
          JTextField nn[] = { accno,nam};
     JComboBox zz[] = {grp};
        int jj = Validate_Empty_Fields.validate_textfields(nn);
       int yy = Validate_Empty_Fields.validate_comboboxes(zz);
        if (jj == 1  || yy == 1 ) {
            return;
        }
        if (accno.getText().toString().endsWith("00"))
        {
            
        }else
        {
             MessageBox.infoBox("Group Code Must End with '00'  !!", "Error");
             return;
        }
        
        String mclass[]= { " ","Asset", "Liability", "Income",  "Expense","Capital"};
       String  sdd=Character.toString( accno.getText().toString().charAt(0));
      // String ss=Character.toString(sdd);
        int asd=Integer.parseInt(sdd);
        if(mclass[asd].equals(grp.getSelectedItem().toString()))
        {
            
        }else
        {
          MessageBox.infoBox("Wrong group code for the selected class !!", "Error");
             return;  
        }
        
        getdata();   
        if(ok.getText().toString().equals("Add"))
        {
            do_add();
        }else
        {
            do_edit();
        }        
    }//GEN-LAST:event_okActionPerformed
public void do_edit()
{
        Connection conn =DBconnect.ConnecrDb();   
         //      sql = "insert into  saccodb (reg,membid,nam,grp,cat,metno,metsz,idno,telno,paddr,email,sdate,stime) values('"+xreg+"','"+xmembid+"','"+xnam+"','"+xgrp+"','"+
         //                xcat+"','"+xmetno+"','"+xmetsz+"','"+xidno+"','"+xtelno+"','"+
         //              xpaddr+"','"+xemail+"',CURDATE(),CURTIME())";
                
           sql=" update accountsgrp set "+
                    //    "membid='" + xmembid +"'"+
                        "nam='" + xnam +"'"+
                       ",grp='" + xgrp +"'"+
                 //       ",typ='" + xtyp +"'"+
                     //   ",idno='" + xidno +"'"+
                     //   ",telno='" + xtelno +"'"+
                     //   ",email='" + xemail +"'"+
                    //    ",town='" + xtown +"'"+
                   //     ",paddr='" + xpaddr +"'"+
                        "  where accno='"+zaccno+"'";  
         System.out.println(sql);
          try {
             
              
              pst=conn.prepareStatement(sql);
              pst.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Users_add.class.getName()).log(Level.SEVERE, null, ex);
              MessageBox.infoBox(ex.toString(), "Edit Account");
              return;
         //     msbbox.show(Alert.AlertType.ERROR, ex.toString(),"SQL Error" ,"ffff");
          }
           MessageBox.infoBox("Record "+pind+"ed Successfully", pind+" Account");
}
    public void do_add()
{
     Connection conn =DBconnect.ConnecrDb();   
               sql = "insert into  accountsgrp (accno,nam,grp,sdate,stime) values"
                       + "('"+xaccno+"','"+xnam+"','"+xgrp+"',CURDATE(),CURTIME())";
                
         
         System.out.println(sql);
          try {
             
              
              pst=conn.prepareStatement(sql);
              pst.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Users_add.class.getName()).log(Level.SEVERE, null, ex);
              MessageBox.infoBox(ex.toString(), "Add Account");
              return;
         //     msbbox.show(Alert.AlertType.ERROR, ex.toString(),"SQL Error" ,"ffff");
          }
     accno.setText("");
     nam.setText("");
     accno.requestFocus();
  //   typ.setSelectedItem("");
  //   grp.setSelectedItem("");
 //  msbbox.show(Alert.AlertType.ERROR, "New record saved successfully","New Record" ,"ffff");       
   // Members_listController zn = new Members_listController();
   MessageBox.infoBox("Account Created Successfully", "Add Account");
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          Accountsgrp_Add.this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void grpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grpActionPerformed
        // TODO add your handling code here:
          Connection conn =DBconnect.ConnecrDb();   
     
           sql = "SELECT * from accountsgrp where grp='"+grp.getSelectedItem().toString()+"' order by accno desc LIMIT 0,1";
           System.out.print(sql);

        try {
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();
        //    town.setSelectedItem(rs.getString("town"));
    //        accno.setText(rs.getString("accno"));
   //         nam.setText(rs.getString("nam"));
            //.setSelectedItem(rs.getString("grp"));
       int racc=     rs.getInt("accno")+100;
       String s_racc=Integer.toString(racc);
         accno.setText(s_racc);
   ///          typ.setSelectedItem(rs.getString("typ"));
        nam.requestFocus();
         //   plotno.setText(rs.getString("plotno"));

        } catch (SQLException ex) {
            Logger.getLogger(Members_add.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_grpActionPerformed

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
    //membid 	payid 	nam 	toe 	idno 	telno 	email 	paddr 	town 	sdate 	stime 	ldate 	ltime 
    xaccno=accno.getText().toString();
   // xpayid=payid.getText().toString();
    xnam=nam.getText().toString();
  //  xdur=dur.getText().toString();
 //   xtyp=typ.getSelectedItem().toString();
   xgrp=grp.getSelectedItem().toString();
 //   xemail=email.getText().toString();
 //   xtelno=telno.getText().toString();
 //   xpaddr=paddr.getText().toString();
 //   xtown=town.getText().toString();
   // xmembid=membid.getText().toString();
  // ActionEvent event = null;
  
         // zn = new Members_listController;
   
}
    
public void poputate_fields()
    {
         Connection conn =DBconnect.ConnecrDb();   
     
           sql = "SELECT * from accountsgrp where accno='"+zaccno+"'";
           System.out.print(sql);

        try {
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();
        //    town.setSelectedItem(rs.getString("town"));
            accno.setText(rs.getString("accno"));
            nam.setText(rs.getString("nam"));
            //.setSelectedItem(rs.getString("grp"));
         grp.setSelectedItem(rs.getString("grp"));
   ///          typ.setSelectedItem(rs.getString("typ"));
        
         //   plotno.setText(rs.getString("plotno"));

        } catch (SQLException ex) {
            Logger.getLogger(Members_add.class.getName()).log(Level.SEVERE, null, ex);
        }

   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accno;
    private javax.swing.JComboBox<String> grp;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nam;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables
}
