/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static kiwacoe.Payments_capture.zmon;

//import static majiApp.Readings_BList.zyr;


/**
 *
 * @author user
 */
public class Recovceries_bank extends javax.swing.JFrame {
    DefaultTableModel testlist = new DefaultTableModel();
    ResultSet rs = null;
    ResultSet rs2 = null;
    public String mx, sql;
    ResultSet rs22 = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst22 = null;
    PreparedStatement pst32 = null;
    public String xuserid, xnam, xpass, xtyp, filename;
    static String zyr, zmon, ztyp, zstat;
    public Connection connz = null;
    HashMap hm = null;
    //  static String muserid,mnam,mtyp; 
    //   public static  ListSelectionModel cellSelectionModel ;
    /**
     * Creates new form UsersLIst
     *
     *
     */
    static JTable table;
    public Recovceries_bank() {
    //  table=jTable1;
        initComponents();
        jTable1 = SetTable.data(jTable1);
        zmon = Recoveries_List.zmon;
        zyr = Recoveries_List.zyr;
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
                //     zyr = jTable1.getValueAt(row, 0).toString();
                //     zmon = jTable1.getValueAt(row, 1).toString();
                //     ztyp = jTable1.getValueAt(row, 2).toString();
                //     zstat = jTable1.getValueAt(row, 4).toString();
                System.out.println("Selected: " + mtyp);
            }

        });

        doread();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Open Batch");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Print Batch");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Add Month");
        jButton1.setEnabled(false);
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

        jButton5.setText("Post  Batch");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Export to Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jButton2)
                .addGap(14, 14, 14)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            MessageBox.infoBox("No Batch Selected", "Open Batch");
            return;
        }

        Loan_Repay_Capture_old dd = new Loan_Repay_Capture_old(this, true);
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Repayments Capture");
        dd.setVisible(true);
        // dd.setM
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // UsersLisr.e
        Recovceries_bank.this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            MessageBox.infoBox("No Batch Selected", "Open Batch");
            return;
        }
        this.setCursor(cursor_typ.busy());
        hm = new HashMap();
        hm.put("yr", zyr);
        hm.put("mon", zmon);
        hm.put("title", "Loan Repayments For : " + GetMonth.format(zmon) + "  , " + zyr);
        String filename = "reportrepayments.jrxml";
        String title = "Loan Repayments For : " + GetMonth.format(zmon) + "  , " + zyr;
        RunReports.preview(filename, hm, title);
        // Insert a row at position p
        // int p = 1;
        // model.insertRow(p, new Object[] { "r3" });
        this.setCursor(cursor_typ.notbusy());
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
        Recoveries_B_Add dd = new Recoveries_B_Add(this, true);
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Add Repayments Batch");
        dd.setVisible(true);
         

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        // TODO add your handling code here:
          doread();
    }//GEN-LAST:event_jButton1FocusGained

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        String ans=Confirm.YesNo("Are You Sure?", "Post Batch");
          if (ans.equals("N"))
          {
              return;
          }
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            MessageBox.infoBox("No Batch Selected", "Post Batch");
            return;
        }
        
        if(zstat.equals("Posted"))
        {
            MessageBox.infoBox("Batch Already Posted", "Post Batch");
            return;
        }
         try {
            // TODO add your handling code here:
            if (Validate_period.validate(zyr, zmon) < 1) {
                MessageBox.infoBox("Cant Post,Period not open!!", "Post Batch");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Loan_Repay_List.class.getName()).log(Level.SEVERE, null, ex);
        }
          int t = 0;
        try {
           t =Validate_batch.validate(zyr, zmon, "repbatches");
        } catch (SQLException ex) {
            Logger.getLogger(Loan_Repay_List.class.getName()).log(Level.SEVERE, null, ex);
        }
          this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            try {
                 postbatch(zyr,zmon);
             } catch (SQLException ex) {
                 Logger.getLogger(Loan_Repay_List.class.getName()).log(Level.SEVERE, null, ex);
             }
            this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        filename="d:\\tabledata.xls"; 
        try {
               // TODO add your handling code here:
               this.setCursor(cursor_typ.busy());
               int[] ii={1,0,0,1,0,0,0,0,0,0};
               exportTable(jTable1, new File(filename),ii);
               this.setCursor(cursor_typ.notbusy());
           } catch (IOException ex) {
               Logger.getLogger(Query_expenses.class.getName()).log(Level.SEVERE, null, ex);
               MessageBox.infoBox(ex.toString(), filename);
           }
        openfile();
    }//GEN-LAST:event_jButton6ActionPerformed
  public void openfile() {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(filename);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }
    public void exportTable(JTable table, File file,int[] uu) throws IOException {
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                try {     
                    if(j==3 ||  j==0)
                    
                    
                    // if(uu[j]==1)
                    //  {
                        
                    {  
                        out.write("'"+model.getValueAt(i, j).toString() + " \t");
                    }
                   //   }else
                   //   {
                         // int x=0;
                        //   MessageBox.infoBox(Integer.toString(len), filename);
                        else
                    {
                         out.write(model.getValueAt(i, j).toString() + " \t");
                    }
                //    String su =Integer.toString(j);
                //     out.write(model.getValueAt(i, j).toString() +"'"+"=A");
                  //    }
                } catch (IOException ex) {
                    // Logger.getLogger(testfrmae.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            out.write("\n");
        }
        out.close();
        System.out.println("write out to: " + file);
    }
     public void update_batch_stat(String ssql3)
   {
        try {             
              pst32=connz.prepareStatement(ssql3);
              pst32.executeUpdate(ssql3);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Payments_BList.class.getName()).log(Level.SEVERE, null, ex);
               MessageBox.infoBox(ex.toString(),"Update Batch Status Method" );
               return;
          }
   }
   public void update_rec_stat(String ssql3)
   {
       try {
           pst32 = connz.prepareStatement(ssql3);
           pst32.executeUpdate(ssql3);
           //    rs= pst.executeQuery();
       } catch (SQLException ex) {
           Logger.getLogger(Payments_BList.class.getName()).log(Level.SEVERE, null, ex);
           MessageBox.infoBox(ex.toString(), "Update Status Method");
           return;
       }
   }
    public void insert_rec(String wsql)
    {
        try {

            pst32 = connz.prepareStatement(wsql);
            pst32.executeUpdate(wsql);
            //    rs= pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Payments_BList.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.infoBox(ex.toString(), "insert_rec Method");
            return;
        }
    }
    
    public void doread()
{

    sql = " select * from recovered where yr='" + zyr + "' and mon='" + zmon + "' order by  membid desc";
    //    System.
    //   MessageBox.infoBox(sql, "dffd");

    System.out.println(sql);
   // DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public Class getColumnClass(int column) {
         //   MessageBox.infoBox(Integer.toString(column), filename);
            switch (column) {
                case 0:
                    return Integer.class;
                case 1:
                    return String.class;
                case 2:
                    return Integer.class;
                case 6:
                    return Double.class;
                case 7:
                    return Double.class;
                case 8:
                    return Double.class;
                case 9:
                    return Double.class;
                case 10:
                    return Double.class;
                default:
                    return String.class;
            }
        }
    };
   /*
      DefaultTableModel model = new DefaultTableModel() {

// Defining the type of column on your JTable. I wish sort my second column as a numeric (1,2,11), not String (1,11,2). For that I defined the second class as Integer.
            Class[] types = {String.class, Integer.class, String.class,String.class, Integer.class, String.class,String.class, Integer.class, double.class, double.class, double.class};
            boolean[] canEdit = new boolean[]{
                false, false, false,false, false, false,false, false, false, false, false
            };

            // You must add this Override in order to works sorting by numeric.
            @Override
            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            // This override is just for avoid editing the content of my JTable. 
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };   */
    // jTable1 hh;
    jTable1.setModel(model);
    model.addColumn("Member ID");
    model.addColumn("Name");
    model.addColumn("Branch");
    model.addColumn("Account No");
    model.addColumn("Insurance");
    model.addColumn("Welfare");
    model.addColumn("loan");
    model.addColumn("App Fee");
    model.addColumn("Shares");
    model.addColumn("Bank Charge");
    model.addColumn("Total Amount");
  //  model.addColumn("Total To Recover");
  //  model.addColumn("Bal CF");
    // model.
    // Create the first row
    Connection conn = DBconnect.ConnecrDb();

    //  String sql = "SELECT * from users ";
    try {
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();
        // rs.first();
        int p = 0;
        String membid = "";
        String nam = "";
        String bnch = "";
        String bacc = "";
        String ins = "";
        String wel = "";
        String ln = "";
        String sh = "";
        String bch = "";
        String tot = "";
        String fee = "";
        while (rs.next()) {
            //  readdata();
            membid = rs.getString("membid");
            nam = rs.getString("nam");
            bnch = rs.getString("bnch");
            bacc = rs.getString("bacc");
            ins = rs.getString("ins");
            ins = Format_amt.format(ins);
            wel = rs.getString("wel");
            fee = rs.getString("fee");
            wel = Format_amt.format(wel);
            ln = rs.getString("ln");
            ln = Format_amt.format(ln);
            sh = rs.getString("sh");
            sh = Format_amt.format(sh);
            bch = rs.getString("bch");
            bch = Format_amt.format(bch);
            fee = Format_amt.format(fee);
            tot = rs.getString("tot");
            tot = Format_amt.format(tot);
            model.insertRow(p, new Object[]{membid, nam, bnch, bacc, ins, wel, ln,fee, sh, bch, tot});
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
            //  jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(9).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(10).setCellRenderer(rightRenderer);
        }

    } catch (SQLException ex) {
        Logger.getLogger(UsersLIst.class.getName()).log(Level.SEVERE, null, ex);
    }
    
            jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_ALL_COLUMNS);

}
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
            java.util.logging.Logger.getLogger(UsersLIst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersLIst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersLIst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersLIst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersLIst().setVisible(true);
               
            }
        });
    }
   public void postbatch(String zyr,String zmon) throws SQLException
{
    
        
        //String sx = membid.getText().toString();
        sql = "SELECT * from repayments where yr='" + zyr +"' and mon='"+zmon+"'";

        Connection connx = DBconnect.ConnecrDb();

        pst2 = connx.prepareStatement(sql);
        System.out.println(sql);

        rs2 = pst2.executeQuery();
        rs2.first();
      //  readdata();
        // double cnt=0;
        while (rs.next()) {
           
             readbatch(zyr,zmon);

        }
        Close_batch.close(zyr,zmon,"repbatches");
        //searchz();
        
    }

 public void readbatch(String hyr,String hmon) throws SQLException {
        //accno 	loanid 	typ 	yr 	mon 	bf 	intr 	cf 	nam 
      
      
       
     String amt = rs.getString("amt");
     String membid = rs.getString("membid");
     String nam = rs.getString("nam");
     String dat = rs.getString("cdate");
     String pseq = rs.getString("seq");
     String soc = "Repayments";
     String suffix = membid;
     String descr = "Repayments";
     String dr = amt;
     String cr = "0";
     String accno = "0000";
          
     insert_rec(accno, soc, descr, suffix, dr, cr, hyr, hmon, dat, pseq);//post dr
     accno = "000";
     cr = amt;
     dr = "0";
     insert_rec(accno,soc,descr,suffix,dr,cr,hyr,hmon,dat,pseq);//post cr
     
     //====================================================post interest======================================
     
     amt = rs.getString("intramt");
     accno = "0000";  //put interest acco no
     cr = amt;
     dr = "0";
     insert_rec(accno, soc, descr, suffix, dr, cr, hyr, hmon, dat, pseq);//post cr

     amt = rs.getString("intramt");
     accno = "0000";  //put interest acco no
     dr = amt;
     cr = "0";
     insert_rec(accno, soc, descr, suffix, dr, cr, hyr, hmon, dat, pseq);//post cr

     //====================end of interest post===================================================================
     
        
    }
    
    public void insert_rec(String accno,String soc,String descr,String suffix,String dr,String cr,String hyr,String hmon,String dat,String pseq)
    {
       
        sql = "insert into gl (accno,soc,descr,suffix,dr,cr,yr,mon,dat,pseq,pdate,ptime) values("
                + accno
                + ",'" + soc + "'"
                + ",'" + descr + "'"
                + ",'" + suffix + "'"
                + "," + dr + ""
                + "," + cr + ""
                + ",'" + hyr + "'"
                + ",'" + hmon + "'"
                + "," + dat + ""
                + "," + pseq + ""
                + ",,CURDATE(),CURTIME())";
        //     msbbox.show(Alert.AlertType.ERROR, sql, "Save Method", "Database Error");
        Connection conn = DBconnect.ConnecrDb();
        System.out.println(sql);
        try {

            pst22 = conn.prepareStatement(sql);
            pst22.executeUpdate(sql);
            //    rs= pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Loan_Repay_List.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.infoBox(ex.toString(), "Database Error");
            //  return;
        }

       // msbbox.show(Alert.AlertType.ERROR, "New record saved successfully", "New Record", "ffff");
      
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
