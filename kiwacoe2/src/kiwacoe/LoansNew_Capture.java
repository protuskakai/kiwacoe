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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static kiwacoe.Expenses_Capture.zstat;







//import static majiApp.Payments_capture.zyr;
//import static majiApp.Payments_capture.pst2;
//import static majiApp.Payments_BList.zstat;
//import static majiApp.Payments_capture.sql;
//import static majiApp.Payments_capture.zmon;

/**
 *
 * @author user
 */
public class LoansNew_Capture extends javax.swing.JFrame {
 static ResultSet rs = null;
     static ResultSet rs2 = null;
     static ResultSet rs3 = null;
      static ResultSet rs4 = null;
    static String mx, sql,xseq;
    public int x = 0,r=0;
    static PreparedStatement pst = null;
      static PreparedStatement pst2 = null;
       static PreparedStatement pst4 = null;
       static PreparedStatement pst3 = null;
       Connection conn = DBconnect.ConnecrDb();
    //xmembid+"','"+xnam+"',"+xamt+",'"+xtyp+"','"+xcomm+"','"+xyr+"','"+xmon+"
     public String xnam,xamt,xcomm,xtyp,xmembid,xrdate,xdur,xintr,xqid1,xqid2,
             xqid3,xqid4,xqnam1,xqnam2,xqnam3,xqnam4,xfee,xloanid;
     static String zyr,zmon,ztyp,zfind,zstat;
     int ff=0;
    // public Connection conn=DBconnect.ConnecrDb();
    /**
     * Creates new form NewJDialog
     */
    public LoansNew_Capture(java.awt.Frame parent, boolean modal) {
       // super(parent, modal);
        initComponents();
       jTable1=SetTable.data(jTable1);
     try {
         typ=Combos.typs(typ);
     } catch (SQLException ex) {
         Logger.getLogger(LoansNew_Capture.class.getName()).log(Level.SEVERE, null, ex);
         MessageBox.infoBox(ex.toString(), xintr);
     }
         jButton3.setText("Add");
        zmon = LoansNew_List.zmon;
        zyr = LoansNew_List.zyr;
    //    ztyp = LoansNew_List.ztyp;
      //  zreg = Readings_BList.zreg;
        zstat = LoansNew_List.zstat;
    
       doread();
       jLabel7.setText("Year:  " + zyr + "    Month: " + zmon  + "  Status:  "+zstat);
       seq.setVisible(false);
       nam.setEditable(false);
    // try {
         //    MessageBox.infoBox(zstat, "Open Batch");
    //     getdur_intr();
   //  } catch (SQLException ex) {
   //      Logger.getLogger(LoansNew_Capture_old.class.getName()).log(Level.SEVERE, null, ex);
    // }
        if (zstat.equals("Posted"))
        {
           jButton3.setEnabled(false);
            
        }
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
                 typ.setSelectedItem(jTable1.getValueAt(row, 1).toString());
              //  MessageBox.infoBox( jTable1.getValueAt(row, 1).toString(),"sd");
               nam.setText(jTable1.getValueAt(row, 2).toString());
               amt.setText(Format_amt.uformat( jTable1.getValueAt(row, 3).toString()));
               dur.setText(jTable1.getValueAt(row, 4).toString());
               comm.setText(jTable1.getValueAt(row, 5).toString());
                membid.setText(jTable1.getValueAt(row, 6).toString());
                 rdate.setText(Format_date.dmy( jTable1.getValueAt(row, 7).toString()));
                 
              
                 qid1.setText(jTable1.getValueAt(row, 8).toString());
                 
                  qnam1.setText(jTable1.getValueAt(row, 9).toString());
                  
                   qid2.setText(jTable1.getValueAt(row,10).toString());
                  qnam2.setText(jTable1.getValueAt(row, 11).toString());
                  
                   qid3.setText(jTable1.getValueAt(row, 12).toString());
                  qnam3.setText(jTable1.getValueAt(row, 13).toString());
                  
                //   qid4.setText(jTable1.getValueAt(row, 14).toString());
                //  qnam4.setText(jTable1.getValueAt(row, 15).toString());
                 
                
               jButton3.setText("Save");
                               System.out.println("Selected: " + mtyp);
                }
            }

        });
        
          mnam.getDocument().addDocumentListener(new DocumentListener() {   //val listener
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

        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nam = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dur = new javax.swing.JTextField();
        membid = new javax.swing.JTextField();
        rdate = new javax.swing.JTextField();
        amt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comm = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        seq = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        ltot = new javax.swing.JLabel();
        lcnt = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        typ = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        qnam1 = new javax.swing.JTextField();
        qid2 = new javax.swing.JTextField();
        qnam2 = new javax.swing.JTextField();
        qid3 = new javax.swing.JTextField();
        qnam3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        qid1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        mnam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));

        jTabbedPane1.setFocusable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel2.setText("Name");

        jLabel5.setText("Amount");

        nam.setFocusable(false);

        add.setText("New");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

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

        jLabel15.setText("Duration(Months)");

        jLabel8.setText("Date");

        dur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durActionPerformed(evt);
            }
        });

        membid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                membidFocusLost(evt);
            }
        });

        rdate.setEditable(false);

        amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtActionPerformed(evt);
            }
        });

        jLabel1.setText("Member ID");

        jLabel6.setText("Remarks");

        comm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commActionPerformed(evt);
            }
        });

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

        seq.setText("jTextField1");

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

        ltot.setText(" ");

        lcnt.setText(" ");

        jLabel12.setText("Loan Type");

        typ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(rdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jButton6)
                .addGap(19, 19, 19)
                .addComponent(add))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(membid, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jButton5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275)
                .addComponent(lcnt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dur, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(269, 269, 269)
                .addComponent(ltot, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(seq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comm, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(typ, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(rdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6)
                    .addComponent(add))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(membid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lcnt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(ltot, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(typ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(seq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Loan Details", jPanel1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Member ID");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Name");

        qnam1.setFocusable(false);

        qid2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                qid2FocusLost(evt);
            }
        });

        qnam2.setFocusable(false);

        qid3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                qid3FocusLost(evt);
            }
        });

        qnam3.setFocusable(false);

        jLabel3.setText("Guarator 1 ");

        jLabel4.setText("Guarator 2 ");

        jLabel10.setText("Guarator 3");

        qid1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                qid1FocusLost(evt);
            }
        });
        qid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qid1ActionPerformed(evt);
            }
        });

        jButton2.setText("Find");
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

        jButton7.setText("Find");
        jButton7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton7FocusGained(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Find");
        jButton8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton8FocusGained(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(74, 74, 74)
                        .addComponent(qid1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(qnam1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(74, 74, 74)
                        .addComponent(qid2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(qnam2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(77, 77, 77)
                        .addComponent(qid3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(qnam3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)))
                .addContainerGap(518, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(qid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(qnam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(qid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(qnam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(qid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(qnam3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8)))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Guarators", jPanel2);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel16.setText("Search Member By Name");

        mnam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mnamFocusGained(evt);
            }
        });
        mnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnamActionPerformed(evt);
            }
        });

        jButton1.setText("Export To Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 539, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mnam, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(mnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(465, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 229, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
          if(zstat.equals("Posted"))
       {
           MessageBox.infoBox("Batch Alread Posted!!", "Add Record");
           return;
       }
        updatetots();
        x=0;
        membid.setText( "");
        nam.setText( "");
        //   typ.setSelectedItem( "");
        amt.setText("");
        rdate.setText("");
        comm.setText("");
        qid1.setText("");
        qid2.setText("");
        qid3.setText("");
    //    qid4.setText("");
        qnam1.setText("");
        qnam2.setText("");
        qnam3.setText("");
    //    qnam4.setText("");
        dur.setText("");
        jButton3.setText("Add");
        jButton3.setEnabled(true);
        typ.setSelectedItem("");
        rdate.requestFocus();
    }//GEN-LAST:event_addActionPerformed

    private void jButton5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton5FocusGained
        // TODO add your handling code here:
        if  ( ff==0)
        {

        }else
        {
            if (zstat.equals("Open"))
            {
                //  MessageBox.infoBox(Find_Customer.zmembid, zstat);
                membid.setText(Find_Customer.zmembid);
                nam.setText(Find_Customer.znam);
                //dur.requestFocus();
                amt.requestFocus();
                ff=0;
            }
        }
    }//GEN-LAST:event_jButton5FocusGained

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ff=1;
        //   zmembid="";
        //   znam="";
        Find_Customer.zfind="New";
        // Find_Customer.zfind="P";
        Find_Customer dd=new Find_Customer();
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Find Staff");
        dd.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void durActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durActionPerformed

    private void membidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_membidFocusLost
        // TODO add your handling code here:
        
          if(zstat.equals("Posted"))
       {
          // MessageBox.infoBox("Batch Alread Posted!!", "Add Record");
           return;
       }
        
        if (membid.getText().trim().isEmpty())
        {
            jButton3.setEnabled(true);
           // jButton3.setEnabled(false);
        }else
        {
            jButton3.setEnabled(true);
            try {
                populate_data(0);
            } catch (SQLException ex) {
                Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_membidFocusLost

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void commActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int hh=Integer.parseInt(dur.getText().toString());
        if(hh>72 || hh<0)
        {
            MessageBox.infoBox("Invalid Value", "Duration");
            return;
        }
        JTextField nn[] = { membid,nam,amt,comm,rdate,qid1,qid2,qid3,qid3};
        //  JComboBox zz[] = {grp,reg,cat};
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
        doread();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // NewJFrame2 frame = new NewJFrame2();

        // frame.dispose();
        LoansNew_Capture.this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton6FocusGained
        // TODO add your handling code here:
        if (r ==1 && Kalenda.gdat.length()>0) {
            r=0;
            rdate.setText( Kalenda.gdat);
            membid.requestFocus();
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

    private void qid2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qid2FocusLost
        if (qid2.getText().trim().isEmpty())
        {
            //  jButton3.setEnabled(false);
        }else
        {
            //  jButton3.setEnabled(true);
            try {
                populate_data(2);
            } catch (SQLException ex) {
                Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_qid2FocusLost

    private void qid3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qid3FocusLost
        // TODO add your handling code here:
        if (qid3.getText().trim().isEmpty())
        {
            //  jButton3.setEnabled(false);
        }else
        {
            //  jButton3.setEnabled(true);
            try {
                populate_data(3);
            } catch (SQLException ex) {
                Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_qid3FocusLost

    private void qid1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qid1FocusLost
        // TODO add your handling code here:
        if (qid1.getText().trim().isEmpty())
        {
            //  jButton3.setEnabled(false);
        }else
        {
            //  jButton3.setEnabled(true);
            try {
                populate_data(1);
            } catch (SQLException ex) {
                Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_qid1FocusLost

    private void qid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qid1ActionPerformed

    private void typActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typActionPerformed

    private void mnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           this.setCursor(cursor_typ.busy());
               int[] ii={0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0};
       ExportExcel.preview(jTable1,ii);
        this.setCursor(cursor_typ.notbusy());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mnamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mnamFocusGained
        // TODO add your handling code here:
      //   clear_fields();
        // rdate.setText("");
    }//GEN-LAST:event_mnamFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          ff=1;
        //   zmembid="";
        //   znam="";
        Find_Customer.zfind="New";
        // Find_Customer.zfind="P";
        Find_Customer dd=new Find_Customer();
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Find Staff");
        dd.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        // TODO add your handling code here:
            if  ( ff==0)
        {

        }else
        {
            if (zstat.equals("Open"))
            {
                //  MessageBox.infoBox(Find_Customer.zmembid, zstat);
                qid1.setText(Find_Customer.zmembid);
                qnam1.setText(Find_Customer.znam);
                //dur.requestFocus();
                amt.requestFocus();
                ff=0;
            }
        }
    }//GEN-LAST:event_jButton2FocusGained

    private void jButton7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton7FocusGained
        // TODO add your handling code here:
               if  ( ff==0)
        {

        }else
        {
            if (zstat.equals("Open"))
            {
                //  MessageBox.infoBox(Find_Customer.zmembid, zstat);
                qid2.setText(Find_Customer.zmembid);
                qnam2.setText(Find_Customer.znam);
                //dur.requestFocus();
                amt.requestFocus();
                ff=0;
            }
        }
        
    }//GEN-LAST:event_jButton7FocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
             ff=1;
        //   zmembid="";
        //   znam="";
        Find_Customer.zfind="New";
        // Find_Customer.zfind="P";
        Find_Customer dd=new Find_Customer();
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Find Staff");
        dd.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton8FocusGained
        // TODO add your handling code here:
               if  ( ff==0)
        {

        }else
        {
            if (zstat.equals("Open"))
            {
                //  MessageBox.infoBox(Find_Customer.zmembid, zstat);
                qid3.setText(Find_Customer.zmembid);
                qnam3.setText(Find_Customer.znam);
                //dur.requestFocus();
                amt.requestFocus();
                ff=0;
            }
        }
    }//GEN-LAST:event_jButton8FocusGained

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
             ff=1;
        //   zmembid="";
        //   znam="";
        Find_Customer.zfind="New";
        // Find_Customer.zfind="P";
        Find_Customer dd=new Find_Customer();
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Find Staff");
        dd.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed
 public void doread()
{
    // String = mon.getSelectedItem().toString();
  //  String syr = yr.getSelectedItem().toString();
  //  String smon = String.format("%02d", mon.getSelectedIndex() + 1);
  
    sql = " select * from loans where CONCAT( yr,mon)='"+zyr+zmon+"' and nam like '%"+mnam.getText().toString()+"%'";
    //    System.
    //   MessageBox.infoBox(sql, "dffd");

    System.out.println(sql);
    DefaultTableModel model = new DefaultTableModel();
    // jTable1 hh;
    jTable1.setModel(model);
   
    model.addColumn("Acc No");
     model.addColumn("Type");
    model.addColumn("Name");
    model.addColumn("Amount");
    model.addColumn("Duration");
    model.addColumn("Remarks");
    model.addColumn("Member ID");
    model.addColumn("Date");
    model.addColumn("Q1 ID");
    model.addColumn("Name");
    model.addColumn("Q2 ID");
    model.addColumn("Name");
    model.addColumn("Q3 ID");
    model.addColumn("Name");
    model.addColumn("Q4 ID");
    model.addColumn("Name");
     model.addColumn("Fees");
      model.addColumn("Interest");
    //   model.addColumn("2 Name");
    jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(11).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(12).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(13).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(14).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(15).setMaxWidth(0);
      jTable1.getColumnModel().getColumn(16).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(17).setMaxWidth(0);
    
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
                rs.getString("accno"),
                rs.getString("typ"),
                rs.getString("nam"),
               Format_amt.format(rs.getString("amt")),
                rs.getString("dur"),
                rs.getString("comm"),
                rs.getString("membid"),
                rs.getString("rdate"),
                rs.getString("qid1"),
                rs.getString("qnam1"),
                rs.getString("qid2"),
                rs.getString("qnam2"),
                rs.getString("qid3"),
                rs.getString("qnam3"),
                rs.getString("qid4"),
                rs.getString("qnam4"),
                rs.getString("fee"),
                rs.getString("intr"),
               
            });
        //     jTable1.changeSelection(0, 0, false, false);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UsersLIst.class.getName()).log(Level.SEVERE, null, ex);
    }
    lcnt.setText("Record Count = "+ Integer.toString(cnt));
     ltot.setText("Total Amount = "+  Format_amt.format( Double.toString(tamt)));
    jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_ALL_COLUMNS);
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
    
     DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    //  jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
    jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
     jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
}
 public void updatetots()
{
        try { 
        String[] qq= BatchTotals.yrmon(zyr, zmon,  "nwlbatches", "loans");
       //  cmt.setText(" Records="+qq[0]+"    Total Amount="+qq[1]);
     } catch (SQLException ex) {
         Logger.getLogger(LoansNew_Capture_old.class.getName()).log(Level.SEVERE, null, ex);
     }
}    
   public void populate_data(int m) throws SQLException
{
    String fmembid="";
    switch (m) {
        case 1:
           fmembid= qid1.getText().toString();
            break;
        case 2:
            fmembid= qid2.getText().toString();
            break;
        case 3:
             fmembid= qid3.getText().toString();
            break;
   //   case 4:
   //          fmembid= qid4.getText().toString();
    //        break;
    }
     String sql = "SELECT *  from saccodb where membid='"+fmembid+"'";
    //Connection conn = DBconnect.ConnecrDb();
    System.out.println(sql);
    pst2 = conn.prepareStatement(sql);
    rs2 = pst2.executeQuery();
   // metno="Nil";
   // metsz="Nil";
    while(rs2.next())
    {
     //   MessageBox.infoBox(rs2.getString("nam"), fmembid);
        switch (m) {
            case (0):

                nam.setText(rs2.getString("nam"));
                amt.requestFocus();
                break;
           

            case (1):

                qnam1.setText(rs2.getString("nam"));
                qid2.requestFocus();
                break;
            case (2):

                 qnam2.setText(rs2.getString("nam"));
                qid3.requestFocus();
                break;
            case (3):

               qnam3.setText(rs2.getString("nam"));
 //               qid4.requestFocus();
                break;
            case (4):

   //             qnam4.setText(rs2.getString("nam"));
              //  amt.requestFocus();
                break;
        }
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
    String        sql = "SELECT * from loans where yr='" + zyr + "' and mon='" + zmon + "' ";
  //  Connection conn = DBconnect.ConnecrDb();
    pst3 = conn.prepareStatement(sql);
    rs3 = pst3.executeQuery();
    x = 1;    
    int cnt= cntt();
   //  cmt.setText(Integer.toString( cnt));
}
public void loaddata()
{
     try {

        membid.setText(rs3.getString("membid"));
        typ.setSelectedItem(rs3.getString("membid"));
        nam.setText(rs3.getString("nam"));
        //  rdate.setText(rs3.getString("rdate"));
        rdate.setText(Format_date.dmy(rs3.getString("rdate")));
        amt.setText(rs3.getString("amt"));
        //  pread.setText(rs3.getString("pread"));
        //  cread.setText(rs3.getString("cread"));
        comm.setText(rs3.getString("comm"));
        seq.setText(rs3.getString("accno"));
        qid1.setText(rs3.getString("qid1"));
        qid2.setText(rs3.getString("qid2"));
        qid3.setText(rs3.getString("qid3"));
   //     qid4.setText(rs3.getString("qid4"));
        qnam1.setText(rs3.getString("qnam1"));
        qnam2.setText(rs3.getString("qnam2"));
        qnam3.setText(rs3.getString("qnam3"));
        dur.setText(rs3.getString("dur"));
    //    qnam4.setText(rs3.getString("qnam4"));
        jButton3.setText("Save");

    } catch (SQLException ex) {
        Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
        MessageBox.infoBox(ex.toString(), "dd");
    }

}
public void performAdd()
{
    
     double mons=Double.parseDouble(dur.getText().toString());
      double samt=Double.parseDouble(amt.getText().toString());
      double ramtt=Math.round(samt/mons);
      String sramtt=Double.toString(ramtt);
      sramtt=Format_amt.format(sramtt);
       sramtt=Format_amt.uformat(sramtt);
    sql = "insert into  loans (membid,nam,typ,amt,comm,yr,mon,rdate,cdate,ctime,stat,dur,intr,status,qid1,qid2,qid3,qnam1,qnam2,qnam3,fee,edate,stime,loanid,ramtt,qid4,qnam4)"
            + " values('" + xmembid + "','" + xnam + "','" + typ.getSelectedItem().toString() + "'," + xamt + ",'" + xcomm + "','" + zyr + "','" + zmon + "','" + xrdate + "',CURDATE(),CURTIME(),'U'," + xdur + "," + xintr + ",'Active'"
            + ",'" + xqid1 + "'"
            + ",'" + xqid2 + "'"
            + ",'" + xqid3 + "'"
        //    + ",'" + xqid4 + "'"
            + ",'" + xqnam1 + "'"
            + ",'" + xqnam2 + "'"
            + ",'" + xqnam3 + "'"
         //   + ",'" + xqnam4 + "'"
            + "," + xfee + ""
            + ",CURDATE(),CURTIME(),'"+xloanid+"',"+sramtt+",'n/a','n/a')";
    //   Connection conn=DBconnect.ConnecrDb();
    System.out.println(sql);
    try {

        pst2 = conn.prepareStatement(sql);
        pst2.executeUpdate(sql);
        //    rs= pst.executeQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
        //  msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
        MessageBox.infoBox(ex.toString(), "Update Error");
        return;
    }
    updatetots();
    clear_fields();
    rdate.requestFocus();
    
}
public void clear_fields()
{
     nam.setText("");
    membid.setText("");
    //  grp.setText("");
    //    cat.setText("");
 //   rdate.setText("");
    amt.setText("");
    comm.setText("");
     typ.setSelectedItem("");
    qid1.setText("");
    qid2.setText("");
    qid3.setText("");
  //  qid4.setText("");
    qnam1.setText("");
    qnam2.setText("");
    dur.setText("");
    qnam3.setText("");
  //  qnam4.setText("");
}
public String getloanid() throws SQLException
{
       sql = "SELECT * from loantypes where nam='" + ztyp + "'";

       
            pst4 = conn.prepareStatement(sql);

            rs4 = pst4.executeQuery();
            rs4.first();
        
    return rs4.getString("loanid");
}
 public void poputate_fields() {
     //   Connection conn = DBconnect.ConnecrDb();

        sql = "SELECT * from loans where yr='" + zyr + "' and mon='" + zmon  + "' ";

        try {
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();
          //  rdate.setText(rs.getString("rdate"));
              rdate.setText(Format_date.dmy(rs.getString("rdate")));
            membid.setText(rs.getString("membid"));
            nam.setText(rs.getString("nam"));
            dur.setText(rs.getString("dur"));
            amt.setText(rs.getString("amt"));

        } catch (SQLException ex) {
            Logger.getLogger(UsersLIst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void performSave()
{
  //  xrdate=rdate.getText().toString();
  //  String dd=xrdate.substring(0,2);
 //    String ddx=xrdate.substring(0,5);
 //    String mm=ddx.substring(3);
    
 //    String yy=xrdate.substring(6);
  //   xrdate=yy+"/"+ mm+"/"+dd;
    
    double mons=Double.parseDouble(dur.getText().toString());
      double samt=Double.parseDouble(amt.getText().toString());
      double ramtt=Math.round(samt/mons);
      String sramtt=Double.toString(ramtt);
      sramtt=Format_amt.format(sramtt);
       sramtt=Format_amt.uformat(sramtt);
    
     sql = " update loans set "
            + "rdate='" + xrdate + "'"
            + ",nam='" + nam.getText().toString() + "'"
         //    + ",typ='" + nam.getText().toString() + "'"
           + ",membid='" + membid.getText().toString() + "'"
               + ",comm='" + comm.getText().toString() + "'"
                + ",dur=" + dur.getText().toString() + ""
              + ",intr=" + xintr + ""
               + ",loanid='" + xloanid + "'"
                + ",typ='" +  typ.getSelectedItem().toString()  + "'"
               + ",qid1='" + qid1.getText().toString() + "'"
             
               + ",qid2='" + qid2.getText().toString() + "'"
              + ",dur='" + dur.getText().toString() + "'"
               + ",qid3='" + qid3.getText().toString() + "'"
   //            + ",qid4='" + qid4.getText().toString() + "'"
               + ",qnam1='" + qnam1.getText().toString() + "'"
               + ",qnam2='" + qnam2.getText().toString() + "'"
               + ",qnam3='" + qnam3.getText().toString() + "'"
     //          + ",qnam4='" + qnam4.getText().toString() + "'"
              + ",ramtt=" + sramtt + ""
            //,CURDATE(),CURTIME()
              + ",edate=CURDATE(),stime=CURTIME()"
            + ",amt=" + amt.getText().toString()  + ""
     
            + //  ",paddr='" + xpaddr +"'"+
            "  where accno=" + seq.getText().toString() + "";
       
    System.out.println(sql);
     
   //   msbbox.show(Alert.AlertType.ERROR, sql,"insertrec Method" ,"Database Error");
       
         System.out.println(sql);
          try {
              pst2=conn.prepareStatement(sql);
              pst2.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
              // msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
               MessageBox.infoBox(ex.toString(), "Update Error");
              return;
          }
       
     try {  
         refresh_recordset();
     } catch (SQLException ex) {
         Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
         // msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
           MessageBox.infoBox(ex.toString(), "Update Error");
     }
}
public void refresh_recordset() throws SQLException 
{
    /*
    int zz=rs3.getRow();
     String        sql = "SELECT * from loans where yr='" + zyr + "' and mon='" + zmon + "' and typ='" + ztyp + "'";
  //  Connection conn = DBconnect.ConnecrDb();
    pst3 = conn.prepareStatement(sql);
    rs3 = pst3.executeQuery();
    x = 1;    
    int cnt= cntt();
 //  cmt.setText(Integer.toString( cnt));
   
  rs3.absolute(zz);
  loaddata();
  */
}
public void getdata()
{
     try {
         getdur_intr() ;
     } catch (SQLException ex) {
         Logger.getLogger(LoansNew_Capture.class.getName()).log(Level.SEVERE, null, ex);
     }
    xmembid = membid.getText().toString();
    xnam = nam.getText().toString();
     xtyp = typ.getSelectedItem().toString();
    xrdate = rdate.getText().toString();
    xamt = amt.getText().toString();
    xcomm = comm.getText().toString();
    xqid1 = qid1.getText().toString();
    xqid2 = qid2.getText().toString();
    xqid3 = qid3.getText().toString();
    xdur = dur.getText().toString();
   // xqid4 = qid4.getText().toString();
    xqnam1 = qnam1.getText().toString();
    xqnam2 = qnam2.getText().toString();
    xqnam3 = qnam3.getText().toString();
  //  xqnam4 = qnam4.getText().toString();
     xrdate = xrdate.replace("-", "/");
    String mdate[] = xrdate.split("/");
    String d = mdate[0];
    String m = mdate[1];
    String y = mdate[2];
    xrdate = y + "-" + m + "-" + d;
    
    double fee = Double.parseDouble(amt.getText().toString()) * 0.03;
    xfee = Double.toString(fee);
    //  xtyp = typ.getSelectedItem().toString();
}
public int cntt() throws SQLException
{
    
    String sql = "SELECT count(*) as cnt from loans where yr='" + zyr + "' and mon='" + zmon + "' ";
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
public void getdur_intr() throws SQLException
{
      sql = "SELECT * from loantypes where nam='" + typ.getSelectedItem().toString() + "'";

       
            pst4 = conn.prepareStatement(sql);

            rs4 = pst4.executeQuery();
            rs4.first();
         //   xdur=rs4.getString("dur");
            xintr=rs4.getString("intr");
            xloanid=rs4.getString("loanid");
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField amt;
    private javax.swing.JTextField comm;
    private javax.swing.JTextField dur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lcnt;
    private javax.swing.JLabel ltot;
    private javax.swing.JTextField membid;
    private javax.swing.JTextField mnam;
    private javax.swing.JTextField nam;
    private javax.swing.JTextField qid1;
    private javax.swing.JTextField qid2;
    private javax.swing.JTextField qid3;
    private javax.swing.JTextField qnam1;
    private javax.swing.JTextField qnam2;
    private javax.swing.JTextField qnam3;
    private javax.swing.JTextField rdate;
    private javax.swing.JTextField seq;
    private javax.swing.JComboBox<String> typ;
    // End of variables declaration//GEN-END:variables
}
