/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

//import static examples.NewJFrame2.pst;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static kiwacoe.Expenses_Capture.zstat;
import static kiwacoe.Shares_Capture.sql;



//import static majiApp.Payments_capture.zyr;
//import static majiApp.Payments_capture.pst2;
//import static majiApp.Payments_BList.zstat;
//import static majiApp.Payments_capture.sql;
//import static majiApp.Payments_capture.zmon;

/**
 *
 * @author user
 */
public class Loan_Repay_Capture extends javax.swing.JFrame {
 static ResultSet rs = null;
 int ff=0;
     static ResultSet rs2 = null;
     static ResultSet rs3 = null;
    static String mx, sql,xseq;
    int r=0;
    public int x = 0;
    static PreparedStatement pst = null;
      static PreparedStatement pst2 = null;
       static PreparedStatement pst3 = null;
    //xmembid+"','"+xnam+"',"+xamt+",'"+xtyp+"','"+xcomm+"',,'"+xyr+"','"+xmon+"
     public String xnam,xamt,xcomm,xtyp,xaccno,xrdate,xmembid;
     static String zyr,zmon,ztyp,zfind,zstat,xloanid;
     public Connection conn=DBconnect.ConnecrDb();
    /**
     * Creates new form NewJDialog
     */
    public Loan_Repay_Capture(java.awt.Frame parent, boolean modal) {
       // super(parent, modal);
        initComponents();
        jButton3.setVisible(false);
        jButton5.setVisible(false);
         jButton6.setVisible(false);
        add.setVisible(false);
        jTable1=SetTable.data(jTable1);
         jButton3.setText("Add");
        zmon = Loan_Repay_List.zmon;
        zyr = Loan_Repay_List.zyr;
    //    ztyp = Expenses_Capture.ztyp;
      //  zreg = Readings_BList.zreg;
        zstat = Loan_Repay_List.zstat;
      doread();
      jLabel7.setText("Year:  " + zyr + "    Month: " + zmon  +"  Status:  "+zstat);
       seq.setVisible(false);
       nam.setEditable(false);
           typ.setEditable(false);
       
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
                seq.setText(jTable1.getValueAt(row, 0).toString());
                 accno.setText(jTable1.getValueAt(row, 1).toString());
               nam.setText(jTable1.getValueAt(row, 2).toString());
               typ.setText(jTable1.getValueAt(row, 3).toString());
               amt.setText(Format_amt.uformat(   jTable1.getValueAt(row, 4).toString()));
        //       dur.setText(jTable1.getValueAt(row, 3).toString());
               comm.setText(jTable1.getValueAt(row, 5).toString());
               
                 rdate.setText(Format_date.dmy( jTable1.getValueAt(row, 6).toString()));
                  String scomm=comm.getText().toString();
                 String gcom[] = scomm.split(" ");
                 if(gcom[0].equals("Auto"))
                {
                    jButton3.setEnabled(false);
                }else
                {
                     jButton3.setEnabled(true);
                }
              
                
                 
                
               jButton3.setText("Save");
                               System.out.println("Selected: " + mtyp);
                }
            }

        });
          if (zstat.equals("Posted"))
        {
          jButton3.setVisible(false);
            
        }
        jButton1.setVisible(false);
         jButton2.setVisible(false);
          cmt.setVisible(false);
        updatetots();
       // poputate_fields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        amt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        nam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        seq = new javax.swing.JTextField();
        accno = new javax.swing.JTextField();
        rdate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        typ = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lcnt = new javax.swing.JLabel();
        ltot = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtActionPerformed(evt);
            }
        });

        jLabel1.setText("Acc No");

        jLabel2.setText("Name");

        cmt.setEditable(false);
        cmt.setFocusable(false);

        jLabel5.setText("Amount");

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Close");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        nam.setFocusable(false);

        jLabel6.setText("Remarks");

        comm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));

        jButton5.setText("Find");
        jButton5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton5FocusGained(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Date");

        seq.setText("jTextField1");

        accno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                accnoFocusLost(evt);
            }
        });

        rdate.setEditable(false);

        jLabel3.setText("Loan Type");

        typ.setFocusable(false);

        jButton2.setText("<<");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText(">>");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        add.setText("New");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jButton6.setText("#");
        jButton6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton6FocusGained(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        lcnt.setText(" ");

        ltot.setBackground(new java.awt.Color(0, 204, 255));
        ltot.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(rdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jButton6))
                            .addComponent(accno, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton3)
                        .addGap(88, 88, 88)
                        .addComponent(seq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(71, 71, 71)
                .addComponent(jButton2)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton1))
                    .addComponent(cmt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(typ, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(ltot, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lcnt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(cmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(rdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton6)
                                    .addComponent(add))))
                        .addGap(19, 19, 19)
                        .addComponent(accno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lcnt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4)))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(typ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ltot, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(seq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

          try{
            if (x == 0) {
                open();
            }

            if(!rs3.isLast())
            {
                rs3.next();
                int cnt= rs3.getRow();
                int cmm=  cntt();
                cmt.setText(Integer.toString( cnt)+" of "+ Integer.toString( cmm));
                loaddata();
            }else
            {
                rs3.last();
                //   msbbox.show( Alert.AlertType.ERROR,"End of File", "titleBar",  "Header");
                return;
            }
        } catch (SQLException ex) {
            //      Logger.getLogger(NewJFrame2.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed
 public void doread()
{
    // String = mon.getSelectedItem().toString();
  //  String syr = yr.getSelectedItem().toString();
  //  String smon = String.format("%02d", mon.getSelectedIndex() + 1);
  
    sql = " select * from  repayments where CONCAT( yr,mon)='"+zyr+zmon+"'";
    //    System.
    //   MessageBox.infoBox(sql, "dffd");

    System.out.println(sql);
    DefaultTableModel model = new DefaultTableModel();
    // jTable1 hh;
    jTable1.setModel(model);
   
    model.addColumn("Rec ID");
    model.addColumn("Loan Acc");
    model.addColumn("Name");
    model.addColumn("Loan Type");
  model.addColumn("Amount");
    model.addColumn("Remarks");
   
     model.addColumn("Date");
     jTable1.getColumnModel().getColumn(0).setMaxWidth(0);  
    //   model.addColumn("2 Name");
 
    Connection conn = DBconnect.ConnecrDb();
     
  int cnt=0;
     double tamt=0;
    try {
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        // rs.first();
        int p = 0;
        while (rs.next()) {
            //  readdata();
            
  cnt=cnt+1;
            tamt=tamt+ Double.parseDouble(rs.getString("amt"));
            model.insertRow(p, new Object[]{
                 rs.getString("seq"),
                rs.getString("accno"),
                rs.getString("nam"),
                rs.getString("typ"),
               Format_amt.format(  rs.getString("amt")),
       //         rs.getString("dur"),
                rs.getString("comm"),
               
                rs.getString("rdate"),
              
               
            });
        }
    } catch (SQLException ex) {
        Logger.getLogger(UsersLIst.class.getName()).log(Level.SEVERE, null, ex);
    }
    lcnt.setText("Record Count = "+ Integer.toString(cnt));
     ltot.setText("Total Amount = "+  Format_amt.format( Double.toString(tamt)));
    jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_ALL_COLUMNS);
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
            //  jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
             jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
  try {
            if (x == 0) {
                open();
            }

            if (!rs3.isFirst()) {
                rs3.previous();
                int cnt= rs3.getRow();

                int cmm=  cntt();
                cmt.setText(Integer.toString( cnt)+" of "+ Integer.toString( cmm)  );
                // String tmembid = rs.getString("membid");  //+"\n";
                loaddata();
            } else {
                // msbbox.show(Alert.AlertType.ERROR, "End of File", "titleBar", "Header");
                rs3.first();
                loaddata();
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
           JTextField nn[] = { accno,nam,amt,comm,rdate};
     //   JComboBox zz[] = {typ};
        int jj = Validate_Empty_Fields.validate_textfields(nn);
      //  int yy = Validate_Empty_Fields.validate_comboboxes(zz);
        if (jj == 1 ) {
            return;
        }
        getdata();
        String mm=jButton3.getText().toString();
        if (mm.equals("Save"))
        {
            performSave();
        }else
        {
            performAdd();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       // NewJFrame2 frame = new NewJFrame2();

       // frame.dispose();
        Loan_Repay_Capture.this.dispose();

    }//GEN-LAST:event_jButton4ActionPerformed
public void updatetots()
{
     try {
            String[] qq = BatchTotals.yrmon(zyr, zmon, "repbatches", "repayments");
            cmt.setText(" Records=" + qq[0] + "    Total Amount=" + qq[1]);
        } catch (SQLException ex) {
            Logger.getLogger(Loan_Repay_Capture_old.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.infoBox("updatetots method", "Error");
            return;
        }
}
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
          if(zstat.equals("Posted"))
       {
           MessageBox.infoBox("Batch Alread Posted!!", "Add Record");
           return;
       }
        updatetots();
        x=0;
        accno.setText( "");

        nam.setText( "");
     //   typ.setSelectedItem( "");
        amt.setText( "");
        rdate.setText( "");
         comm.setText( "");
        jButton3.setText("Add");
        jButton3.setEnabled(true);
        typ.setText("");
        rdate.requestFocus();
    }//GEN-LAST:event_addActionPerformed

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void commActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           ff=1;
        //  zmembid="";
       //   znam="";
          Find_Loan.zfind="Loan";
        Find_Loan dd=new Find_Loan();
          // dd.setModal(true);
              //  dialog.setSize(400, 400);
                dd.setLocationRelativeTo(null);
               // dd.setExtendedState(dd.MAXIMIZED_BOTH);
               dd.setResizable(false);
          dd.setTitle("Find Loan");
          dd.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void accnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_accnoFocusLost
        // TODO add your handling code here:
          if(zstat.equals("Posted"))
       {
         //  MessageBox.infoBox("Batch Alread Posted!!", "Add Record");
           return;
       }
        
           if (accno.getText().trim().isEmpty())
           {
               jButton3.setEnabled(false);
           }else
           {
                jButton3.setEnabled(true);
               try {
                   populate_data();
               } catch (SQLException ex) {
                   Logger.getLogger(Expenses_Capture.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
                   
    }//GEN-LAST:event_accnoFocusLost

    private void jButton5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton5FocusGained
        // TODO add your handling code here:
          if  ( ff==0)
      {
          
      }else
      {
        if (zstat.equals("Open"))
        {
            //  MessageBox.infoBox(Find_Customer.zmembid, zstat);
            accno.setText(Find_Loan.zaccno);
            nam.setText(Find_Loan.znam);
             typ.setText(Find_Loan.ztyp);
            try {
                xloanid=getloanid(typ.getText().toString());
            } catch (SQLException ex) {
                Logger.getLogger(Loan_Repay_Capture.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                xmembid=getmembid(nam.getText().toString());
            } catch (SQLException ex) {
                Logger.getLogger(Loan_Repay_Capture.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            amt.requestFocus();
            ff=0;
        }
      }
    }//GEN-LAST:event_jButton5FocusGained
public String getloanid(String ss) throws SQLException
{
      String mfee="x";
       
       String sql = "select * from loantypes where nam='"+ss+"'";
       // pst = connx.prepareStatement(sql);
        System.out.print(sql);
   
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {
           
           
               
                 mfee = rs.getString("loanid");
               
        }

      //  return llamt;
      if(mfee==null)
      {
          mfee="000";
      }
    
       
       
       return mfee;
}

public String getmembid(String ss) throws SQLException
{
      String mfee="x";
       
       String sql = "select * from saccodb where nam='"+ss+"'";
       // pst = connx.prepareStatement(sql);
        System.out.print(sql);
   
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {
           
           
               
                 mfee = rs.getString("membid");
               
        }

      //  return llamt;
      if(mfee==null)
      {
          mfee="000";
      }
    
       
       
       return mfee;
}

    private void jButton6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton6FocusGained
        // TODO add your handling code here:
       if (r ==1 && Kalenda.gdat.length()>0) {
            r=0;
            rdate.setText( Kalenda.gdat);
            accno.requestFocus();
        }else
        {
            r=0;
        }
    }//GEN-LAST:event_jButton6FocusGained

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        r=1;
        Kalenda dd=new Kalenda();
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setDefaultCloseOperation(dd.DO_NOTHING_ON_CLOSE);
         dd.getContentPane().setBackground(Color.decode("123130040"));
        dd.setResizable(false);
        dd.setTitle("Calender");
        dd.setVisible(true);

        //  MessageBox.infoBox(Kalenda.gdat, user);
        //  this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

   public void populate_data() throws SQLException
{
     String sql = "SELECT *  from loans where accno='"+accno.getText().toString()+"'";
    //Connection conn = DBconnect.ConnecrDb();
    System.out.println(sql);
    pst2 = conn.prepareStatement(sql);
    rs2 = pst2.executeQuery();
   // metno="Nil";
   // metsz="Nil";
    while(rs2.next())
    {
        nam.setText(rs2.getString("nam"));
        typ.setText(rs2.getString("typ"));
        xmembid=rs2.getString("membid");
    
    amt.requestFocus();
        
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
            java.util.logging.Logger.getLogger(Payments_capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payments_capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payments_capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payments_capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Payments_capture dialog = new Payments_capture(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
               
              //  dialog.setModal(true);
              //  dialog.setSize(400, 400);
                dialog.setLocationRelativeTo(null);
                 dialog.setTitle("Shares");
                 dialog.setResizable(false);
                dialog.setVisible(true);
            }
        });
    }
public void open() throws SQLException
{
    String        sql = "SELECT * from repayments where yr='" + zyr + "' and mon='" + zmon + "' ";
  //  Connection conn = DBconnect.ConnecrDb();
    pst3 = conn.prepareStatement(sql);
    rs3 = pst3.executeQuery();
    x = 1;    
    int cnt= cntt();
   cmt.setText(Integer.toString( cnt));
}
public void loaddata()
{
      try {
          
       String mdate[] = rs3.getString("rdate").split("-");
            String yy = mdate[0];
            String mm = mdate[1];
            String dd = mdate[2];
            rdate.setText(dd + "/" + mm + "/" + yy);
        accno.setText(rs3.getString("accno"));

        nam.setText(rs3.getString("nam"));
       // rdate.setText(rs3.getString("rdate"));
        amt.setText(rs3.getString("amt"));
      //  pread.setText(rs3.getString("pread"));
      //  cread.setText(rs3.getString("cread"));
        comm.setText(rs3.getString("comm"));
         seq.setText(rs3.getString("seq"));
           typ.setText(rs3.getString("typ"));
        jButton3.setText("Save");

    } catch (SQLException ex) {
        Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
       MessageBox.infoBox(ex.toString(), "dd");
    }

}
public void performAdd()
{
      
    
   
  //MessageBox.infoBox(xrdate, "sss");// membid,nam,typ,grp,comm,yr,mon,reg,cread,pread,cdate,ctime                                     
       sql = "insert into  repayments (accno,membid,nam,typ,amt,comm,yr,mon,rdate,cdate,ctime,stat,loanid)"
               + " values('"+xaccno+"','"+xmembid+"','"+xnam+"','"+xtyp+"',"+xamt+",'"+xcomm+"','"+zyr+"','"+zmon+"','"+xrdate+"',CURDATE(),CURTIME(),'U','"+xloanid+"')";  
    //   Connection conn=DBconnect.ConnecrDb();
         System.out.println(sql );
          try {
             
              
              pst2=conn.prepareStatement(sql);
              pst2.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
             //  msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
             MessageBox.infoBox(ex.toString(), "Error");
             return;
          }
          
        
    nam.setText("");
    accno.setText("");
    //  grp.setText("");
    typ.setText("");
    rdate.setText("");
    amt.setText("");
    comm.setText("");
    updatetots();
    rdate.requestFocus();
    
}
 public void poputate_fields() {
     //   Connection conn = DBconnect.ConnecrDb();

        sql = "SELECT * from repayments where yr='" + zyr + "' and mon='" + zmon  + "'";

        try {
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();
            rdate.setText(rs.getString("rdate"));
            accno.setText(rs.getString("accno"));
            nam.setText(rs.getString("nam"));

            amt.setText(rs.getString("amt"));
             typ.setText(rs.getString("typ"));

        } catch (SQLException ex) {
            Logger.getLogger(UsersLIst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void performSave()
{
   
     sql = " update repayments set "
            + "rdate='" + xrdate + "'"
            + ",nam='" + nam.getText().toString() + "'"
         //    + ",typ='" + nam.getText().toString() + "'"
           + ",accno='" + accno.getText().toString() + "'"
               + ",comm='" + comm.getText().toString() + "'"
             + ",typ='" + typ.getText().toString() + "'"
       
            + ",amt=" + amt.getText().toString()  + ""
     
            + //  ",paddr='" + xpaddr +"'"+
            "  where seq=" + seq.getText().toString() + "";
       
    System.out.println(sql);
     
   //   msbbox.show(Alert.AlertType.ERROR, sql,"insertrec Method" ,"Database Error");
       
         System.out.println(sql);
          try {
              pst2=conn.prepareStatement(sql);
              pst2.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
              MessageBox.infoBox("Record Update Error", "Error");
             //msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
              return;
          }
       
     try {
         refresh_recordset(); //msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
     } catch (SQLException ex) {
         Logger.getLogger(Expenses_Capture.class.getName()).log(Level.SEVERE, null, ex);
     }
}
public void refresh_recordset() throws SQLException 
{
    /*
    int zz=rs3.getRow();
     String          sql = "SELECT * from repayments where yr='" + zyr + "' and mon='" + zmon + "'";
  //  Connection conn = DBconnect.ConnecrDb();
    pst3 = conn.prepareStatement(sql);
    rs3 = pst3.executeQuery();
    x = 1;    
    int cnt= cntt();
   cmt.setText(Integer.toString( cnt));
   
  rs3.absolute(zz);
  loaddata();

*/
}
public void getdata()
{
    
        xaccno = accno.getText().toString();
        xnam = nam.getText().toString();
         xrdate = rdate.getText().toString();
        xamt = amt.getText().toString();
        xcomm = comm.getText().toString();
       xtyp = typ.getText().toString();
       String mdate[] = xrdate.split("/");
    String d = mdate[0];
    String m = mdate[1];
    String y = mdate[2];
    xrdate = y + "-" + m + "-" + d;
}
public int cntt() throws SQLException
{
    
    String sql = "SELECT count(*) as cnt from repayments where yr='" + zyr + "' and mon='" + zmon + "' ";
  //  Connection conn = DBconnect.ConnecrDb();
    System.out.println(sql);
    pst2 = conn.prepareStatement(sql);
    rs2 = pst2.executeQuery();
    rs2.next();
    int cnt= rs2.getInt("cnt");
    return cnt;
}
public Date convertToDate(String receivedDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(receivedDate);
        return date;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accno;
    private javax.swing.JButton add;
    private javax.swing.JTextField amt;
    private javax.swing.JTextField cmt;
    private javax.swing.JTextField comm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lcnt;
    private javax.swing.JLabel ltot;
    private javax.swing.JTextField nam;
    private javax.swing.JTextField rdate;
    private javax.swing.JTextField seq;
    private javax.swing.JTextField typ;
    // End of variables declaration//GEN-END:variables
}
