/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

//import static examples.NewJFrame2.pst;
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
import javax.swing.JTextField;



//import static majiApp.Payments_capture.zyr;
//import static majiApp.Payments_capture.pst2;
//import static majiApp.Payments_BList.zstat;
//import static majiApp.Payments_capture.sql;
//import static majiApp.Payments_capture.zmon;

/**
 *
 * @author user
 */
public class Shares_Capture_old extends javax.swing.JFrame {
 static ResultSet rs = null;
     static ResultSet rs2 = null;
     static ResultSet rs3 = null;
    static String mx, sql,xseq;
    public int x = 0,r=0;
    static PreparedStatement pst = null;
      static PreparedStatement pst2 = null;
       static PreparedStatement pst3 = null;
    //xmembid+"','"+xnam+"',"+xamt+",'"+xtyp+"','"+xcomm+"','"+xyr+"','"+xmon+"
     public String xnam,xamt,xcomm,xtyp,xmembid,xrdate;
     static String zyr,zmon,ztyp,zfind,zstat;
     public static String zmembid,znam;
     int ff=0;
     public Connection conn=DBconnect.ConnecrDb();
    /**
     * Creates new form NewJDialog
     */
    public Shares_Capture_old(java.awt.Frame parent, boolean modal) {
       // super(parent, modal);
        initComponents();
         jButton3.setText("Add");
        zmon = Shares_List.zmon;
        zyr = Shares_List.zyr;
       ztyp = Shares_List.ztyp;
      //  zreg = Readings_BList.zreg;
        zstat = Shares_List.zstat;
        jLabel7.setText("Year:  " + zyr + "    Month: " + zmon  + "   Type:  " + ztyp+"  Status:  "+zstat);
    //  jLabel7.setText("Year:  " + zyr + "    Month: " + zmon  +"  Status:  "+zstat);
       seq.setVisible(false);
       nam.setEditable(false);
         if (zstat.equals("Posted"))
        {
          jButton3.setEnabled(false);
            
        }
        updatetots();
      
       poputate_fields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        nam = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comm = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        seq = new javax.swing.JTextField();
        membid = new javax.swing.JTextField();
        rdate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtActionPerformed(evt);
            }
        });

        jLabel1.setText("Member ID");

        jLabel2.setText("Name");

        cmt.setFocusable(false);

        jLabel5.setText("Amount");

        jButton1.setText(">>");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<<");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        nam.setFocusable(false);

        add.setText("New");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel6.setText("Remarks");

        comm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commActionPerformed(evt);
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

        jLabel8.setText("Date");

        seq.setText("jTextField1");

        membid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                membidFocusLost(evt);
            }
        });

        rdate.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));

        jButton6.setText("=>");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(jButton2)
                            .addGap(11, 11, 11)
                            .addComponent(cmt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jButton1)
                            .addGap(11, 11, 11)
                            .addComponent(add))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(jButton3)
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(258, 258, 258)
                                    .addComponent(jButton4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(84, 84, 84)
                                    .addComponent(seq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)
                                    .addComponent(rdate, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(membid, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton5)
                                .addComponent(jButton6)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(cmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(add))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(membid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6))
                    .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4)
                    .addComponent(seq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
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
        
           JTextField nn[] = { membid,nam,amt,comm,rdate};
   //    JComboBox zz[] = {typ};
        int jj = Validate_Empty_Fields.validate_textfields(nn);
      //  int yy = Validate_Empty_Fields.validate_comboboxes(zz);
        if (jj == 1 ) {
            return;
        }
        
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
        Shares_Capture_old.this.dispose();

    }//GEN-LAST:event_jButton4ActionPerformed
public void  updatetots()
{
      try {
        String[] qq= BatchTotals.yrmontyp(zyr, zmon, ztyp, "shbatches", "shares");
         cmt.setText(" Records="+qq[0]+"    Total Amount="+qq[1]);
     } catch (SQLException ex) {
         Logger.getLogger(Query_shares.class.getName()).log(Level.SEVERE, null, ex);
     }
}
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
       updatetots();
        x=0;
        membid.setText( "");

        nam.setText( "");
     //   typ.setSelectedItem( "");
        amt.setText( "");
        rdate.setText( "");
         comm.setText( "");
        jButton3.setText("Add");
        rdate.requestFocus();
    }//GEN-LAST:event_addActionPerformed

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void commActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
          //  MessageBox.infoBox("sdffdfsd", "dfdfgg");
          ff=1;
          zmembid="";
          znam="";
          Find_Customer.zfind="Shares";
        Find_Customer dd=new Find_Customer();
          // dd.setModal(true);
              //  dialog.setSize(400, 400);
                dd.setLocationRelativeTo(null);
               // dd.setExtendedState(dd.MAXIMIZED_BOTH);
               dd.setResizable(false);
          dd.setTitle("Find Staff");
          dd.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void membidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_membidFocusLost
        // TODO add your handling code here:
           if (membid.getText().trim().isEmpty())
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
                   
    }//GEN-LAST:event_membidFocusLost

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
            amt.requestFocus();
            ff=0;
        }
      }
    }//GEN-LAST:event_jButton5FocusGained

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
      //  dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setDefaultCloseOperation(dd.DO_NOTHING_ON_CLOSE);
     //   dd.setModal(true);
        dd.setResizable(false);
        dd.setTitle("Calender");
        dd.setVisible(true);

        //  MessageBox.infoBox(Kalenda.gdat, user);
        //  this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

   public void populate_data() throws SQLException
{
    String sql = "SELECT *  from saccodb where membid='" + membid.getText().toString() + "'";
    //Connection conn = DBconnect.ConnecrDb();
    System.out.println(sql);
    pst2 = conn.prepareStatement(sql);
    rs2 = pst2.executeQuery();
    // metno="Nil";
    // metsz="Nil";
    while (rs2.next()) {
        nam.setText(rs2.getString("nam"));

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
    String        sql = "SELECT * from shares where yr='" + zyr + "' and mon='" + zmon + "' and typ='"+ztyp+"' order by seq";
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
          
       
        membid.setText(rs3.getString("membid"));

        nam.setText(rs3.getString("nam"));
        rdate.setText(Format_date.dmy(rs3.getString("rdate")));
        amt.setText(rs3.getString("amt"));
      //  pread.setText(rs3.getString("pread"));
      //  cread.setText(rs3.getString("cread"));
        comm.setText(rs3.getString("comm"));
         seq.setText(rs3.getString("seq"));
         //  typ.setSelectedItem(rs3.getString("typ"));
        jButton3.setText("Save");

    } catch (SQLException ex) {
        Logger.getLogger(Payments_capture.class.getName()).log(Level.SEVERE, null, ex);
       MessageBox.infoBox(ex.toString(), "dd");
    }

}
public void performAdd()  
{
     getdata();    
    
     String dd=xrdate.substring(0,2);
     String ddx=xrdate.substring(0,5);
     String mm=ddx.substring(3);
    
     String yy=xrdate.substring(6);
     xrdate=yy+"/"+ mm+"/"+dd;
 // MessageBox.infoBox(xrdate, "sss");// membid,nam,typ,grp,comm,yr,mon,reg,cread,pread,cdate,ctime                                     
       sql = "insert into  shares (membid,nam,typ,amt,comm,yr,mon,rdate,cdate,ctime,stat)"
               + " values('"+xmembid+"','"+xnam+"','"+ztyp+"',"+xamt+",'"+xcomm+"','"+zyr+"','"+zmon+"','"+xrdate+"',CURDATE(),CURTIME(),'U')";  
    //   Connection conn=DBconnect.ConnecrDb();
         System.out.println(xrdate);
          try {
             
              
              pst2=conn.prepareStatement(sql);
              pst2.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(Query_shares.class.getName()).log(Level.SEVERE, null, ex);
            //   msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
            MessageBox.infoBox(ex.toString(), "Error");   
            return;
          }
       updatetots();
           nam.setText("");
          membid.setText("");
        //  grp.setText("");
       //    cat.setText("");
          rdate.setText("");
          amt.setText("");
          comm.setText("");
          rdate.requestFocus();
    
}
 public void poputate_fields() {
     //   Connection conn = DBconnect.ConnecrDb();

        sql = "SELECT * from shares where yr='" + zyr + "' and mon='" + zmon  + "' and typ='" + ztyp + "'";

        try {
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();
          //  rdate.setText(rs.getString("rdate"));
           rdate.setText(Format_date.dmy(rs.getString("rdate")));
            membid.setText(rs.getString("membid"));
            nam.setText(rs.getString("nam"));

            amt.setText(rs.getString("amt"));
          //   typ.setSelectedItem(rs.getString("typ"));

        } catch (SQLException ex) {
            Logger.getLogger(UsersLIst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void performSave()
{
    xrdate=rdate.getText().toString();
    String dd=xrdate.substring(0,2);
     String ddx=xrdate.substring(0,5);
     String mm=ddx.substring(3);
    
     String yy=xrdate.substring(6);
  //   xrdate=yy+"/"+ mm+"/"+dd;
     sql = " update shares set "
            + "rdate='" + xrdate + "'"
            + ",nam='" + nam.getText().toString() + "'"
         //    + ",typ='" + nam.getText().toString() + "'"
           + ",membid='" + membid.getText().toString() + "'"
               + ",comm='" + comm.getText().toString() + "'"
       //      + ",typ='" + typ.getSelectedItem().toString() + "'"
       
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
    int zz=rs3.getRow();
     String        sql = "SELECT * from shares where yr='" + zyr + "' and mon='" + zmon + "' and typ='" + ztyp + "'";
  //  Connection conn = DBconnect.ConnecrDb();
    pst3 = conn.prepareStatement(sql);
    rs3 = pst3.executeQuery();
    x = 1;    
    int cnt= cntt();
   cmt.setText(Integer.toString( cnt));
   
  rs3.absolute(zz);
  loaddata();
}
public void getdata()
{
    
        xmembid = membid.getText().toString();
        xnam = nam.getText().toString();
         xrdate = rdate.getText().toString();
        xamt = amt.getText().toString();
        xcomm = comm.getText().toString();
     //  xtyp = typ.getSelectedItem().toString();
}
public int cntt() throws SQLException
{
    
    String sql = "SELECT count(*) as cnt from shares where yr='" + zyr + "' and mon='" + zmon + "' and typ='" + ztyp + "'";
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField membid;
    private javax.swing.JTextField nam;
    private javax.swing.JTextField rdate;
    private javax.swing.JTextField seq;
    // End of variables declaration//GEN-END:variables
}
