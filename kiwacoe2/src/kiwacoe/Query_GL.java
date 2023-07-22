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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author user
 */
public class Query_GL extends javax.swing.JFrame {
       public String mx,sql;
        DefaultTableModel testlist = new DefaultTableModel();
 ResultSet rs = null;
        PreparedStatement pst = null;
        public String xuserid,xnam,xpass,xtyp;
        static String zfind;
    /**
     * Creates new form saccodbList
     */
    public Query_GL() {
        initComponents();
        String qym[] = GetMonth.set_yr_mon();
        mon.setSelectedItem(qym[0]);
        yr.setSelectedItem(qym[1]);
        jTable1=SetTable.data(jTable1); 
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
        jButton2 = new javax.swing.JButton();
        yr = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mon = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search By");

        fld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acc no", "Name", "Doc Type", "Doc Ref" }));
        fld.setToolTipText("");
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

        jButton1.setText("Print");
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

        jTable1.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Export to Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        yr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
        yr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                yrFocusGained(evt);
            }
        });
        yr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yrActionPerformed(evt);
            }
        });

        jLabel2.setText("Year");

        jLabel3.setText("Month");

        mon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Feburuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        mon.setToolTipText("");
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(yr, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fld, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(val, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton5))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButton1)
                .addGap(381, 381, 381)
                .addComponent(jButton2)
                .addGap(378, 378, 378)
                .addComponent(jButton3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(val, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton1))
                    .addComponent(jButton2)
                    .addComponent(jButton3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
      //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
      //    MessageBox.infoBox(zfind, "dfdfgg");
     doread();
    }//GEN-LAST:event_jButton5ActionPerformed
public void doread()
{
        String sfld = fld.getSelectedItem().toString();
        String sval = val.getText().toString();
        sval = sval.replace("*", "%");
        // String typp= typ.getSelectedItem().toString();
        String mt1 = "";
        String mt2 = "";
        String kyr = yr.getSelectedItem().toString();
        //   String kmon=mon.getSelectedItem().toString();
        String kmon = String.format("%02d", mon.getSelectedIndex() + 1);
        if (sfld == "Acc no") {

            sql = " select a.*,nam from gl a,accounts b where a.accno=b.accno and  a.accno ='" + sval + "' and CONCAT(yr,mon)='" + kyr + kmon + "' order by a.seq desc";

        }
        if (sfld == "Name") {
            sql = " select  a.*,nam from gl a,accounts b where a.accno=b.accno and nam like '%" + sval + "%' and CONCAT(yr,mon)='" + kyr + kmon + "' order by a.seq desc";
        }
        if (sfld == "Doc Type") {
            sql = " select  a.*,nam from gl a,accounts b where a.accno=b.accno and soc like '%" + sval + "%' and CONCAT(yr,mon)='" + kyr + kmon + "' order by a.seq desc";
        }

        if (sfld == "Doc Ref") {
            sql = " select  a.*,nam from gl a,accounts b where a.accno=b.accno and docno like '%" + sval + "%' and CONCAT(yr,mon)='" + kyr + kmon + "' order by a.seq desc";
        }

        DefaultTableModel model = new DefaultTableModel();
        // jTable1 hh;
        jTable1.setModel(model);

        model.addColumn("Year/Month");
        model.addColumn("Acc No.");
        model.addColumn("Acc Name");
        model.addColumn("Doc Type");
        model.addColumn("Doc No");
        model.addColumn("Doc Date");

        model.addColumn("Description");
        model.addColumn("Dr Amount");
        model.addColumn("Cr Amount");
        model.addColumn("Post Date");
        //   model.addColumn("Post Time");

        //    model.addColumn("Consumption");
        // model.
        // Create the first row
        Connection conn = DBconnect.ConnecrDb();
        System.out.println(sql);
        //  String sql = "SELECT * from users ";

        try {
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            // rs.first();
            int p = 0;
            while (rs.next()) {
                //  readdata();

                //    String cs=    rs.getString("cons");
                model.insertRow(p, new Object[]{
                    rs.getString("yr") + "/" + rs.getString("mon"),
                    rs.getString("accno"),
                    rs.getString("nam"),
                    rs.getString("soc"),
                    rs.getString("docno"),
                    rs.getString("dat"),
                    rs.getString("descr"),
                    //   rs.getString("typ"),
                    Format_amt.format(rs.getString("dr")),
                    Format_amt.format(rs.getString("cr")),
                    rs.getString("pdate")
                //   rs.getString("ptime")
                //    rs.getString("comm")
                });
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersLIst.class.getName()).log(Level.SEVERE, null, ex);
        }
        // JLabel 
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        //   jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);

//    DefaultTableCellRenderer right = new DefaultTableCellRenderer();
//    right.setHorizontalAlignment(JLabel.RIGHT);
        //   jTable1.getColumnModel().getColumn(6).setCellRenderer(right);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
        //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
        Members_add dd=new Members_add();
          // dd.setModal(true);
              //  dialog.setSize(400, 400);
                dd.setLocationRelativeTo(null);
               // dd.setExtendedState(dd.MAXIMIZED_BOTH);
               dd.setResizable(false);
          dd.setTitle("Add saccodb");
          dd.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // UsersLisr.e
        Query_GL.this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldActionPerformed
        // TODO add your handling code here:
        val.requestFocus();
    }//GEN-LAST:event_fldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setCursor(cursor_typ.busy());
               int[] ii={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
       ExportExcel.preview(jTable1,ii);
        this.setCursor(cursor_typ.notbusy());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void yrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yrFocusGained
        // TODO add your handling code here:
        doread();
    }//GEN-LAST:event_yrFocusGained

    private void yrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yrActionPerformed
        // TODO add your handling code here:
        doread();
    }//GEN-LAST:event_yrActionPerformed

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed
        // TODO add your handling code here:
        doread();
    }//GEN-LAST:event_monActionPerformed

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
            java.util.logging.Logger.getLogger(Query_expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Query_expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Query_expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Query_expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new Query_expenses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> fld;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> mon;
    private javax.swing.JTextField val;
    private javax.swing.JComboBox<String> yr;
    // End of variables declaration//GEN-END:variables
}
