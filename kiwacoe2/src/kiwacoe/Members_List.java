/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.awt.Panel;
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
import javax.swing.JScrollPane;
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
public class Members_List extends javax.swing.JFrame {
       public String mx,sql;
        DefaultTableModel testlist = new DefaultTableModel();
 ResultSet rs = null;
        PreparedStatement pst = null;
        public String xuserid,xnam,xpass,xtyp;
        int zc=0;
        int l_int=0;
        String lnam;
    /**
     * Creates new form saccodbList
     */
    public Members_List() {
        initComponents();
       doread();
         ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
                cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        String muserid = null;
                     //   String mtyp = null;
                     //   String mnam = null;

                        int[] selectedRow = jTable1.getSelectedRows();
                        int[] selectedColumns = jTable1.getSelectedColumns();
                            int row = jTable1.getSelectedRow();
	                       int col = 1; // ID is the first Column
                           if (row>-1)
                        {
	                      Members_add.zmembid = jTable1.getValueAt( row, 0 ).toString();
                               Kins.zmembid = jTable1.getValueAt( row, 0 ).toString();
                               lnam = jTable1.getValueAt( row, 1 ).toString();
                        }     
                        
                       //        zmon = jTable1.getValueAt( row, 1 ).toString();
                       //         ztyp = jTable1.getValueAt( row, 3 ).toString();
                       //          zreg = jTable1.getValueAt( row, 2).toString();
                        
      }
                    

    }); 
    jTable1.addMouseListener(new MouseAdapter() { //row double_click event  // doubleclick //double-click
    public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int row = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
            // your valueChanged overridden method 
              MessageBox.infoBox( "<html><b>Member ID: </b>\t"+jTable1.getValueAt( row, 0 ).toString()+"\n"+
                          "<html><b>Name:  </b>\t"+jTable1.getValueAt( row, 1 ).toString()+"\n"+
                      "<html><b>Bank Account: </b>\t "+jTable1.getValueAt( row, 2 ).toString()+"\n"+
                      "<html><b>Branch: </b>\t "+jTable1.getValueAt( row, 3 ).toString()+"\n"+
                      "<html><b>ID NO: </b>\t "+jTable1.getValueAt( row, 4 ).toString()+"\n"+
                      "<html><b>Tel No:  </b>\t"+jTable1.getValueAt( row, 5 ).toString()+"\n"+
                      "<html><b>Postal Address:  </b>\t"+jTable1.getValueAt( row, 6 ).toString()+"\n"+
                      "<html><b>Email Address:  </b>"+jTable1.getValueAt( row, 7 ).toString()+"\n"+
                      "<html><b>Status: </b>\t "+jTable1.getValueAt( row, 8 ).toString()+"\n"+
                      "<html><b>Welfare:  </b>\t"+jTable1.getValueAt( row, 9 ).toString()+"\n"+
                      "<html><b>Monthly Contribution: </b>\t "+jTable1.getValueAt( row, 10 ).toString()+"\n"+
                      "<html><b>Start Date: </b>\t "+jTable1.getValueAt( row, 11 ).toString()+"\n"+
                       "<html><b>Auto Ded: </b>\t "+jTable1.getValueAt( row, 12 ).toString()+"\n"
                 //     "Member ID: "+jTable1.getValueAt( row, 1 ).toString()+"\n"+
                 //     "Member ID: "+jTable1.getValueAt( row, 1 ).toString()+"\n"+
                      , "Selected Record");
        }
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
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search By");

        fld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Customer ID", "ID", "Tel No" }));
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

        jButton1.setText("Add Member");
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton1FocusGained(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit Selected Record");
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton2FocusGained(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Export to Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setGridColor(new java.awt.Color(0, 153, 255));
        jScrollPane1.setViewportView(jTable1);

        jButton6.setText("Next of Kin");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fld, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(val, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(40, 40, 40))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(12, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 514, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(73, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
      //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
          // MessageBox.infoBox("sdffdfsd", "dfdfgg");
       doread();

  //  JScrollPane jp=new JScrollPane(jTable1);
  //  jp.setBounds(10, 0, 457, 103);
 //   jp.setVisible(true);
//    add(jp);
//    this.add(jp);
    }//GEN-LAST:event_jButton5ActionPerformed

    public void doread()
{   
    String sfld = fld.getSelectedItem().toString();
    String sval = val.getText().toString();
      sval = sval.replace("*", "%");
    switch (sfld) {
        case "All":
            sql = " select * from saccodb ";
            break;
        case "Name":
            sql = " select * from saccodb where nam like '%" + sval + "%'";
            break;
        case "Member ID":
            sql = " select * from saccodb where membid like '%" + sval + "%'";
            break;
        case "ID":
            sql = " select * from saccodb where idno like '%" + sval + "%'";
            break;
        case "Tel No":
            sql = " select * from saccodb where telno like '%" + sval + "%'";
    }
    DefaultTableModel model = new DefaultTableModel();
    // jTable1 hh;
    jTable1.setModel(model);
    model.addColumn("Member ID");
    model.addColumn("Name");
    model.addColumn("Bank Acc");
    model.addColumn("Branch");
    model.addColumn("ID No");
    model.addColumn("Tel No");
    model.addColumn("Address");
    model.addColumn("Email");
    model.addColumn("Status");
    model.addColumn("Welfare");
    model.addColumn("M.Shares");
     model.addColumn("Start Date");
      model.addColumn("Auto Deduct");
    // model.
    // Create the first row
    Connection conn = DBconnect.ConnecrDb();

    //  String sql = "SELECT * from users ";
    try {
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();
       
        // rs.first();
        int p = 0;
        while (rs.next()) {
          
          //  String mx=Tcase.toTitleCase(btoe );
        //    String wsql=" update saccodb set bnch='"+mx+"' where membid='"+bmembid+"'";
        //   execute(wsql); 
        //   System.out.print(wsql);
            //  readdata();
            model.insertRow(p, new Object[]{
                rs.getString("membid")
                    , rs.getString("nam")
                    , rs.getString("payid")
                    , rs.getString("bnch")
                    , rs.getString("idno")
                    , rs.getString("telno")
                    , rs.getString("paddr")
                    ,  rs.getString("email")
                    ,  rs.getString("stat")
                    , rs.getString("wel")
                    , Format_amt.format(rs.getString("samt"))
                     , rs.getString("rdate")
                     , rs.getString("auto")
            });
           // if (l_int==0)
           // {
            jTable1.changeSelection(0, 0, false, false);
           // }else
           // {
           //     l_int=0;
           // }
        }

    } catch (SQLException ex) {
        Logger.getLogger(Members_List.class.getName()).log(Level.SEVERE, null, ex);
        return;
    }
   
      jTable1.setShowGrid(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
    //  jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
    jTable1.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
   //  jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
      
      
  //  jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_ALL_COLUMNS);
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
        //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
        Members_add.pind = "Add";
        Members_add dd = new Members_add();
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
         dd.setDefaultCloseOperation(dd.DO_NOTHING_ON_CLOSE);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Add Members");
        dd.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
       
        if (row < 0) {
            MessageBox.infoBox("No Member Selected", "Edit Record");
            return;
        }
         zc=row;
        Members_add.pind = "Edit";
        Members_add dd = new Members_add();
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
         dd.setDefaultCloseOperation(dd.DO_NOTHING_ON_CLOSE);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Edit Members");
        dd.setVisible(true);
        //  refresh_table();
        //  doread();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // UsersLisr.e
        Members_List.this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        // TODO add your handling code here:
        // refresh_table();
        doread();
    }//GEN-LAST:event_jButton1FocusGained

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        // TODO add your handling code here:
        // refresh_table();
         int row = jTable1.getSelectedRow();
         if (row < 0) {
            
            return;
        }else
         {
          //    l_int=1;
         // doread();  
         }
     
         
        //   MessageBox.infoBox("No Member Selected "+Integer.toString(row), "Edit Record");
      //  doread();
       //  jTable1.setRowSelectionInterval(zc, 0);
        
    }//GEN-LAST:event_jButton2FocusGained
 public void execute(String sql4)
    {
        
        Connection conn = DBconnect.ConnecrDb();
        try {
             
              
              pst=conn.prepareStatement(sql4);
              pst.executeUpdate(sql4);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Users_add.class.getName()).log(Level.SEVERE, null, ex);
              MessageBox.infoBox(ex.toString(), "New  Batch");
              return;
         //     msbbox.show(Alert.AlertType.ERROR, ex.toString(),"SQL Error" ,"ffff");
          }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
     
        this.setCursor(cursor_typ.busy());
        //  ExportExcel.preview(jTable1);
        int[] ii = {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ExportExcel.preview(jTable1, ii);

        this.setCursor(cursor_typ.notbusy());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldActionPerformed
        // TODO add your handling code here:
       val.requestFocus();
    }//GEN-LAST:event_fldActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //  Members_add.pind = "Add";
       Kins dd=new Kins(this,true);
          // dd.setModal(true);
              //  dialog.setSize(400, 400);
                dd.setLocationRelativeTo(null);
                 dd.setDefaultCloseOperation(dd.DO_NOTHING_ON_CLOSE);
               // dd.setExtendedState(dd.MAXIMIZED_BOTH);
               dd.setResizable(false);
          dd.setTitle("Next of Kins for : "+lnam);
          dd.setVisible(true);
        //   this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Members_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Members_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Members_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Members_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Members_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> fld;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField val;
    // End of variables declaration//GEN-END:variables
}
