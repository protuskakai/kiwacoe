/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Cursor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author user
 */
public class Statements_Combined_Print extends javax.swing.JFrame {
     HashMap hm = null;
    ResultSet rs = null;
     ResultSet rs6 = null;
    public String mx, sql;
    int ff = 0;
    int recs=0;
    int mnt=0;
    String combfile="";
     File dir=FileSystemView.getFileSystemView().getHomeDirectory();
           List<InputStream> list = new ArrayList<InputStream>();
    PreparedStatement pst = null;
    PreparedStatement pst6 = null;
  //  String host = "mail.nzoiawater.or.ke";
  //  String from = "kiwacoe@nzoiawater.or.ke";
   String filename2 = "";
  //              String to = "kiwacoe@nzoiawater.or.ke";
    Connection conn = DBconnect.ConnecrDb();
    Properties props = new Properties();
    String zmembid="";
     Multipart multipart2 = new MimeMultipart();

    // Get the Session object.
    javax.mail.Session session = javax.mail.Session.getInstance(props,
            new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("kiwacoe@nzoiawater.or.ke", "kiwacoe@2018");
        }
    });

    /**
     * Creates new form Meter_Reading_List
     */
    public Statements_Combined_Print(java.awt.Frame parent, boolean modal) {
       // super(parent, modal);
        initComponents();
      
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        membid = new javax.swing.JTextField();
        nam = new javax.swing.JTextField();
        sss = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Preview");
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

        jLabel3.setText("Staff ID");

        jButton3.setText("Find");
        jButton3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton3FocusGained(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        membid.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sss, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(membid, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nam))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(membid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(sss, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Statements_Combined_Print.this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ff=1;
        //  zmembid="";
        //  znam="";
        Find_Customer.zfind="Shares";
        Find_Customer dd=new Find_Customer();
        // dd.setModal(true);
        //  dialog.setSize(400, 400);
        dd.setLocationRelativeTo(null);
        // dd.setExtendedState(dd.MAXIMIZED_BOTH);
        dd.setResizable(false);
        dd.setTitle("Find Staff");
        dd.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusGained
        // TODO add your handling code here:
        if  ( ff==0)
        {

        }else
        {

            //  MessageBox.infoBox(Find_Customer.zmembid, zstat);
            membid.setText(Find_Customer.zmembid);
            nam.setText(Find_Customer.znam);
          //  typ.requestFocus();
            ff=0;

        }
    }//GEN-LAST:event_jButton3FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     
        // "d:\\Loan_" + rs6.getString("accno") + ".pdf"
        zmembid = membid.getText().toString();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        sql = " select * from saccodb where membid like '%" + membid.getText().toString() + "%' and email<>'n@a.com' order by membid ";
        //    System.
        //   MessageBox.infoBox(sql, "dffd");
        String sql14 = "";
        // if (membid.getText().trim().isEmpty()) {
        sql14 = "select count(*) as cnt from saccodb where membid like '%" + membid.getText().toString() + "%' and email<>'n@a.com' ";
        //  } else {
        //      sql14 = " select count(*) cnt from loans,paid where loans.accno=paid.accno  and loans.accno=" + membid.getText().toString() + " ";
        // }
        try {
            recs = GetRecs.cnt(sql14);
            jProgressBar1.setValue(0);
            jProgressBar1.setMaximum(recs);
        } catch (SQLException ex) {
            Logger.getLogger(Statements_email_loans.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);

        Connection conn = DBconnect.ConnecrDb();

        //  String sql = "SELECT * from users ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                //    String xnam = nam.getText().toString();
                //    String xmembid = membid.getText().toString();
                //  String xtyp = typ.getSelectedItem().toString();
                HashMap hm = new HashMap();
                hm.put("membid", rs.getString("membid"));
                // hm.put("typ", xtyp);
                hm.put("title", "Shares Statement  : " + rs.getString("nam"));
                String filename = "reportEmail_shares.jrxml";
                String title = "Shares Statement  : " + rs.getString("nam");
                //  MessageBox.infoBox("d:\\"+rs.getString("membid"+".pdf"), title);
                // RunReports.preview2(filename, hm, title);
                filename2 = "d:\\Shares_" + rs.getString("membid") + ".pdf";
                // to = "kiwacoe@nzoiawater.or.ke";
           //     to = rs.getString("email");
               RunReports.preview2(filename, hm, title, filename2);
                try {
                    addAttachment(multipart2, "d:\\Shares_" + rs.getString("membid") + ".pdf", "Shares.pdf");
                } catch (MessagingException ex) {
                    Logger.getLogger(Statements_Combined_Print.class.getName()).log(Level.SEVERE, null, ex);
                       MessageBox.infoBox(ex.toString(), "addAttachment");
                       this.setCursor(cursor_typ.notbusy());
                       return;
                }
                try {
                    list.add(new FileInputStream(new File(filename2)));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Statements_Combined_Print.class.getName()).log(Level.SEVERE, null, ex);
                     MessageBox.infoBox(ex.toString(), "List Error");
                       this.setCursor(cursor_typ.notbusy());
                       return;
                
                }
                try {
                    do_loans(rs.getString("membid"));
                } catch (SQLException ex) {
                    Logger.getLogger(Statements_Combined_Print.class.getName()).log(Level.SEVERE, null, ex);
                    MessageBox.infoBox(ex.toString(), "Do Loans Error");
                       this.setCursor(cursor_typ.notbusy());
                       return;
                }
                    merge(rs.getString("membid"));
         //       to = rs.getString("email");
           //     ss(rs.getString("membid"));  //sends email thru swing multithread worker/loader

            }
        } catch (SQLException ex) {
            Logger.getLogger(Statements_Combined_Print.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.infoBox(ex.toString(), "Error");
              this.setCursor(cursor_typ.notbusy());
                       return;
        }
            this.setCursor(cursor_typ.notbusy());
           MessageBox.infoBox("Done", "Report Sending");  
     
        //   System.out.println(nam + " " + xtyp + " " );
        //   msbbox.show(Alert.AlertType.ERROR,"Done", "SQL Error", "ffff");
      

this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));        //    msbbox.show(Alert.AlertType.ERROR,"Done", "SQL Error", "ffff");
    }//GEN-LAST:event_jButton1ActionPerformed
public void merge(String jmemb)
{
   
        
                  OutputStream out;
                try {
                    out = new FileOutputStream(new File("d:\\Combined" + jmemb+ ".pdf"));
                    combfile="d:\\Combined" + jmemb+ ".pdf";
                    try {
                        doMerge(list,out );
                        out.close();
                    } catch (DocumentException ex) {
                        Logger.getLogger(Statements_Combined_Print.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Statements_Combined_Print.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Statements_Combined_Print.class.getName()).log(Level.SEVERE, null, ex);
                }
}
    public static void doMerge(List<InputStream> list, OutputStream outputStream)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        
        for (InputStream in : list) {
            PdfReader reader = new PdfReader(in);
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                //import the page from source pdf
                PdfImportedPage page = writer.getImportedPage(reader, i);
                //add the page to the destination pdf
                cb.addTemplate(page, 0, 0);
            }
        }
        
        outputStream.flush();
        document.close();
        outputStream.close();
    }
    public void do_loans(String kmembid) throws SQLException
{
   
     //   String    sql6 = " select loans.*,xamt from loans,paid where loans.accno=paid.accno  and loans.membid=" + kmembid + " order by loans.accno ";
       String    sql6 = " select * from loans where membid='" + kmembid + "' order by membid";
      System.out.print(sql6);
     pst6 = conn.prepareStatement(sql6);

            rs6 = pst6.executeQuery();
            String qmail="";
           
            while (rs6.next()) {
              
                String xnam = rs6.getString("nam").toString(); // nam.getText().toString();
                String xmembid = rs6.getString("accno").toString();
              
             //   String xtyp = rs6.getString("typ").toString();
              //  qmail=get_email(rs.getString("membid").toString());
             //   if (!qmail.equals("n@a.com")) {
                    //  jtyp = xtyp;
                    HashMap hm = new HashMap();
                    hm.put("membid", xmembid);
               //     hm.put("typ", xtyp);
                    hm.put("title", "Loan Statement  : " + xnam + "  : " );
                    String filename = "reportEmail_loans_1.jrxml";
                    String title = "Loan Statement  : " + xnam + "  : " ;
                  //   RunReports.preview(filename, hm, title);
                    // System.out.println(nam + " " + xtyp + " " );
                    // msbbox.show(Alert.AlertType.ERROR,"Done", "SQL Error", "ffff");
                    // MessageBox.infoBox("d:\\"+rs.getString("membid"+".pdf"), title);
                    // RunReports.preview2(filename, hm, title);
                    filename2 = "d:\\Loan_" + rs6.getString("membid") + ".pdf";
                    System.out.println(filename2);
                    //to = "kiwacoe@nzoiawater.or.ke";
    //                to=qmail;
                    RunReports.preview2(filename, hm, title, filename2);
                    try {
                        addAttachment(multipart2, "d:\\Loan_" + rs6.getString("membid") + ".pdf","Loan Statement_"+rs6.getString("accno")+".pdf");
                        
                    } catch (MessagingException ex) {
                        Logger.getLogger(Statements_Combined.class.getName()).log(Level.SEVERE, null, ex);
                        MessageBox.infoBox(ex.toString(), "addAttachment");
                       this.setCursor(cursor_typ.notbusy());
                       return;
                    }
                    try {
                    list.add(new FileInputStream(new File(filename2)));
                    
                   
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Statements_Combined.class.getName()).log(Level.SEVERE, null, ex);
                    MessageBox.infoBox(ex.toString(), title);
                    return;
               // }
                //    ss(xmembid);
                   // sendemail3();
                }
            }
}
    public void ss(String accno) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {

            @Override

            protected Boolean doInBackground() throws Exception {

                // Simulate doing something useful.
               // for (int i = 0; i <= 100; i++) {

               //     Thread.sleep(1000);
                //     sss.setText("Running " + i);
                        sss.setText("Sending Email for Member ID: "+accno+" ");
                    //    sendemail3();
               // }

                // Here we can return some object of whatever type
                // we specified for the first template parameter.
                // (in this case we're auto-boxing 'true').
                return true;

            }

            // Can safely update the GUI from this method.
            protected void done() {

                boolean status;

                try {

                    // Retrieve the return value of doInBackground.
                    status = get();

                    sss.setText("Completed with status: " + status);
                     MessageBox.infoBox("Done!!", "Send Emails");
                       jProgressBar1.setValue(0);
                       sss.setText("");

                } catch (InterruptedException e) {

                    // This is thrown if the thread's interrupted.
                } catch (ExecutionException e) {

                    // This is thrown if we throw an exception
                    // from doInBackground.
                }

            }

        };

        worker.execute();
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
            java.util.logging.Logger.getLogger(Meter_Reading_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Meter_Reading_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Meter_Reading_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Meter_Reading_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Meter_Reading_List dialog = new Meter_Reading_List(new javax.swing.JFrame(), true);
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
private static void addAttachment(Multipart multipart, String filename,String nam) throws MessagingException
{
    DataSource source = new FileDataSource(filename);
    BodyPart messageBodyPart = new MimeBodyPart();        
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(nam);
    multipart.addBodyPart(messageBodyPart);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField membid;
    private javax.swing.JTextField nam;
    private javax.swing.JLabel sss;
    // End of variables declaration//GEN-END:variables
}
