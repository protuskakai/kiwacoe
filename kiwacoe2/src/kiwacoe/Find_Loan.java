/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author user
 */
public class Find_Loan extends javax.swing.JFrame {
       public String mx,sql;
        DefaultTableModel testlist = new DefaultTableModel();
 ResultSet rs = null;
        PreparedStatement pst = null;
        public String xuserid,xnam,xpass,xtyp;
        static String zfind,zaccno,znam,ztyp,zramtt;
    /**
     * Creates new form saccodbList
     */
    public Find_Loan() {
        initComponents();
            ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String muserid = null;
                String mtyp = null;
                String mnam = null;
                int[] selectedRow = jTable1.getSelectedRows();
                int[] selectedColumns = jTable1.getSelectedColumns();
                int row = jTable1.getSelectedRow();
                int col = 1; // ID is the first Column
                     if (row>-1)
                        {
                zaccno = jTable1.getValueAt(row, 0).toString();
                znam = jTable1.getValueAt(row, 1).toString();
               ztyp = jTable1.getValueAt(row, 2).toString();
                zramtt = jTable1.getValueAt(row, 4).toString();
                        }
             //   zstat = jTable1.getValueAt(row, 5).toString();
             //   System.out.println("Selected: " + mtyp);
            }

        });
          val.getDocument().addDocumentListener(new DocumentListener() {   //val listener
                      public void changedUpdate(DocumentEvent e) {
                          warn();
                      }

                      public void removeUpdate(DocumentEvent e) {
                          warn();
                      }

                      public void insertUpdate(DocumentEvent e) {
                          warn();
                      }

                      public void warn() {
                          doread();
                      }
});
          jTable1.addMouseListener(new MouseAdapter() { //row double_click event  // doubleclick //double-click
    public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int row = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
            doselect();
            // your valueChanged overridden method 
          //    MessageBox.infoBox(jTable1.getValueAt( row, 1 ).toString(), "Selected Record");
        }
    }
});                   
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
        fld = new javax.swing.JComboBox<>();
        val = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search By");

        fld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Member ID" }));
        fld.setFocusable(false);
        fld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldActionPerformed(evt);
            }
        });

        jButton5.setText("Find");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fld, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(val, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(val, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        doread();
    }//GEN-LAST:event_jButton5ActionPerformed
public void doread()
{
     // TODO add your handling code here:
      //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
      //    MessageBox.infoBox(zfind, "dfdfgg");
       String sfld= fld.getSelectedItem().toString();
       String sval=val.getText().toString();
         sval = sval.replace("*", "%");
       switch (sfld)
       {
           case "All":
               sql=" select a.*,ramtt from balx a,loans b where a.accno=b.accno ";
               break;
             case "Name":
               sql=" select a.*,ramtt from balx a,loans b where a.accno=b.accno and a.nam like '%"+sval+"%'";
               break;   
                case "Acc No":
               sql=" select a.*,ramtt from balx a,loans b where a.accno=b.accno and  a.accno like '%"+sval+"%'";
               break;  
           
       }
          DefaultTableModel model = new DefaultTableModel();
        // jTable1 hh;
         jTable1.setModel(model);
         model.addColumn("Acc No");
     //     model.addColumn("Member ID");
         model.addColumn("Name");
         model.addColumn("Loan Type");
         
          model.addColumn("Balance");
            model.addColumn("Repayment Amoutt");
   // model.
    // Create the first row
     Connection conn =DBconnect.ConnecrDb();   
     
        //  String sql = "SELECT * from users ";

    try {
        pst=conn.prepareStatement(sql);
    

       rs= pst.executeQuery();
          // rs.first();
   int p=0;
           while (rs.next())
            {
              //  readdata();
                String ramtt=Format_amt.format(rs.getString("ramtt"));
                model.insertRow(p, new Object[] {rs.getString("accno"),rs.getString("nam"),rs.getString("typ"),rs.getString("amt"),ramtt});
              jTable1.changeSelection(0, 0, false, false);
            }
           
           } catch (SQLException ex) {
                Logger.getLogger(UsersLIst.class.getName()).log(Level.SEVERE, null, ex);
        
    }
   
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
            //  jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
         
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        doselect();
        
    }//GEN-LAST:event_jButton1ActionPerformed
public void doselect()
{
     int row = jTable1.getSelectedRow();
        if(row<0)
        {
           MessageBox.infoBox("No Record Selected", "Find Loan");
           return;
        }
        switch (zfind)
        {
            case "Loan":
           
                break;
            
        }
       // Find_Customer.this.dispose();
       this.setVisible(false);
}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // UsersLisr.e
        Find_Loan.this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldActionPerformed
        // TODO add your handling code here:
        val.requestFocus();
    }//GEN-LAST:event_fldActionPerformed

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
            java.util.logging.Logger.getLogger(Find_Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Find_Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Find_Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Find_Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Find_Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> fld;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField val;
    // End of variables declaration//GEN-END:variables
}
