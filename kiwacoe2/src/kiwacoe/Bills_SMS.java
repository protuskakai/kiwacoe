/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import static com.itextpdf.text.FontFactory.COURIER;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Stream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static org.apache.poi.hssf.usermodel.HeaderFooter.page;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Chunk;
import java.awt.Cursor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JComboBox;
 



/**
 *
 * @author user
 */
public class Bills_SMS extends javax.swing.JFrame {
      HashMap hm =null;
       ResultSet rs = null;
        ResultSet rs9 = null;
         ResultSet rs6 = null;
        ResultSet rs22 = null;
        ResultSet rs22p = null;
          public String mx,sql;
  //    Font font14pt = new Font(FontFamily.TIMES_ROMAN, 14);
            Font font11 = new Font(Font.FontFamily.TIMES_ROMAN, 11);
               Font font10 = new Font(Font.FontFamily.TIMES_ROMAN, 10);
        PreparedStatement pst = null;
        PreparedStatement pst9 = null;
        PreparedStatement pst6 = null;
        PreparedStatement pst22 = null;
         PreparedStatement pst22p = null;
         Document document =null;
        public String xyr, xxmon, xmon, xreg,mamt;
        //footer_table
         PdfPTable detailline_table = new PdfPTable(2);
         PdfPTable footer_table = new PdfPTable(1);
           Connection connz = DBconnect.ConnecrDb();
            String kmembid = "";
        String membid = "";
        String nam = "";
        String paddr = "";
        String metno = "";
         String invno = "";
          String plotno = "";
       public    String amt = "";
        public    String samt = "";
         int xcnt=0;
      //  String kamt = "";
      //  String kdrcr = "";
      //  String ksoc = "";
      //  String kseq = "";
    /**
     * Creates new form Meter_Reading_List
     */
    public Bills_SMS(java.awt.Frame parent, boolean modal) {
       // super(parent, modal);
        initComponents();
             String qym[]=  GetMonth.set_yr_mon();
      yr.setSelectedItem(qym[1]);
      mon.setSelectedItem(qym[0]);
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
        jLabel1 = new javax.swing.JLabel();
        reg = new javax.swing.JComboBox<>();
        mon = new javax.swing.JComboBox<>();
        yr = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        bal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Send");
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

        jLabel1.setText("Region");

        reg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Rongai", "Sabaki" }));
        reg.setToolTipText("");

        mon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Feburuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        mon.setToolTipText("");

        yr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
        yr.setToolTipText("");

        jLabel2.setText("Month");

        jLabel3.setText("Year");

        jButton3.setText("View sms Balance");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(70, 70, 70)
                        .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(yr, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(111, 111, 111)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(reg, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Bills_SMS.this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         boolean mm =  false;
          try {
            mm =   Check_Internet.isInternetAvailable();
           
          } catch (IOException ex) {
              Logger.getLogger(Sms_customized.class.getName()).log(Level.SEVERE, null, ex);
          }
          if (mm==true)
          {
             
          }else
          {
              MessageBox.infoBox("Npo Internet", "Check SMS Balance");
              return;
          }
        JComboBox zz[] = {yr,reg,mon};
      //  int jj = Validate_Empty_Fields.validate_textfields(nn);
        int yy = Validate_Empty_Fields.validate_comboboxes(zz);
        if ( yy == 1) {
            return;
        }
        this.setCursor(cursor_typ.busy());
        xyr = yr.getSelectedItem().toString();
        xreg = reg.getSelectedItem().toString();
        xxmon = mon.getSelectedItem().toString();
        xmon = String.format("%02d", mon.getSelectedIndex() + 1);
          try {
              http();
          } catch (IOException ex) {
              Logger.getLogger(Bills_SMS.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           this.setCursor(cursor_typ.notbusy());
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean mm =  false;
          try {
            mm =   Check_Internet.isInternetAvailable();
           
          } catch (IOException ex) {
              Logger.getLogger(Sms_customized.class.getName()).log(Level.SEVERE, null, ex);
          }
          if (mm==true)
          {
             
          }else
          {
              MessageBox.infoBox("Npo Internet", "Check SMS Balance");
              return;
          }
        this.setCursor(cursor_typ.busy());
        try {
              // TODO add your handling code here:
              http_bal();
          } catch (IOException ex) {
              Logger.getLogger(Bills_SMS.class.getName()).log(Level.SEVERE, null, ex);
          }
         this.setCursor(cursor_typ.notbusy());
    }//GEN-LAST:event_jButton3ActionPerformed

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
public void makepdf() throws DocumentException
  {
         
         
      
      add_header0();
      PdfPTable table = new PdfPTable(6);
      PdfPTable table2 = new PdfPTable(3);
      addTableHeader(table);

      try {
          add_readings(table);

      } catch (SQLException ex) {
          Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
      }

      document.add(header1());
      document.add(new Paragraph("\n"));
      document.add(table);
      document.add(new Paragraph("\n\n"));
      //  addTableHeader(table2);
      try {
          add_readings(table2);
      } catch (SQLException ex) {
          Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
      }
      //  document.add(table2);

      detailline();
       document.add(detailline_table);
       footer_add();
     document.add(footer_table);

  }
public void footer_add()
         
{   
   // Font brown=new Font(Font.NORMAL,9F);
    footer_table.deleteBodyRows();
    PdfPCell cell3 = new PdfPCell();
    cell3.addElement(new Phrase("\t\t\t\t LIPA NA MPESA TILL NO: 331794",font11));
    cell3.addElement(new Phrase("\n"));  
     cell3.addElement(new Phrase("NB: WATER BILLS ARE PAYABLE THROUGH THE SOCIETY'S BANK ACCOUNTS",font11));
    // cell3.setf
    cell3.addElement(new Phrase("\n"));
      PdfPTable table11 = new PdfPTable(new float[] { 65, 35 });
      PdfPCell cell21 = new PdfPCell();
      PdfPCell cell22= new PdfPCell();
      
   //   PdfPCell cell23= new PdfPCell();
       cell21.addElement(new Phrase("RAILWAYS HOUSING CO=OPERATIVE SOCIETY LTD",font11));
        cell21.addElement(new Phrase("BARCLAYS BANK  ",font11));
         cell21.addElement(new Phrase("HAILE SELASSIE AVENUE BRANCH",font11));
          cell21.addElement(new Phrase("A/C NO. 1210305",font11));
           cell22.addElement(new Phrase("CO-OPERATIVE BANK",font11));
         cell22.addElement(new Phrase("CO-OP HSE BRANCH",font11));
          cell22.addElement(new Phrase("A/C NO. 01120000593500",font11));
          cell21.setBorderColor(BaseColor.WHITE);
                   cell22.setBorderColor(BaseColor.WHITE);
          table11.addCell(cell21);
           table11.addCell(cell22);
   // footer_table.sets
    footer_table.addCell(cell3);
    footer_table.addCell(table11);
}
public void open_document() throws DocumentException
{
    
   

     // MessageBox.infoBox("d:\\Bill"+yr+mon+".pdf", "File name");
    //  document = new Document();
   //  Rectangle rect = new Rectangle(85, 200);
     Rectangle rect = new Rectangle(0, 0, 1000, 1200);
    //  Document document = new Document(rect, 0, 0, 0, 0);
   // document.addTemplate(page, 0.1,topMarginOffset);
      document = new Document();
           //  PdfWriter.getInstance(document, new FileOutputStream("d:\\iTextHelloWorld.pdf"));
           PdfWriter writer=null;
          try {
              writer = PdfWriter.getInstance(document, new FileOutputStream("d:\\Bills_"+xreg+"_"+xyr+"_"+xmon+".pdf"));
            
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
          }
            //image1.setAbsolutePosition(1f, 50f);
         //  Rectangle rect = new Rectangle(30, 30, 850, 1200);
           
           document.setPageSize(PageSize.A4);
           document.setMargins(1, 1, 1, 1);
          // document.setMargins(36, 72, 108, 180);
           
      //     writer.setBoxSize("art", rect);
           pdfClass event = new pdfClass();
           writer.setPageEvent(event);
           document.open();
}
public void add_logo()
{
    //cell3.setBorderColor(BaseColor.WHITE);
      Image image1=null;
          try {
               image1 = Image.getInstance("logo22.jpg");
               
               
       

          } catch (BadElementException ex) {
              Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              document.add(image1);
          } catch (DocumentException ex) {
              Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
          }
   /*       
         PdfPCell cell1 = new PdfPCell();
    PdfPTable table1 = new PdfPTable(2);
    cell1.addElement(image1);
    cell1.addElement(new Phrase(xxmon + "  " + xyr));
    table1.addCell(cell1);
    try {
        document.add(table1);
    } catch (DocumentException ex) {
        Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
    }
*/
}
public void add_header0() throws DocumentException
{
  //  add_logo(); 
    
    Image image1=null;
          try {
               image1 = Image.getInstance("logo22.jpg");
               
               
       

          } catch (BadElementException ex) {
              Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
          }
    PdfPTable table11 = new PdfPTable(new float[] { 20, 80 });
    
      PdfPCell cell21 = new PdfPCell();
      PdfPCell cell22= new PdfPCell();
      
   //   PdfPCell cell23= new PdfPCell();
       cell21.addElement(image1);
        cell22.addElement(new Phrase ("\t\t\t"));
    cell22.addElement(new Phrase ("RAILWAYS HOUSING CO-OPERATIVE SOCIETY"));
   cell22.setPadding(30);
 cell22.setVerticalAlignment(Element.ALIGN_RIGHT);
//   cell22.setHorizontalAlignment(cell22.ALIGN_CENTER);
   cell21.setBorderColor(BaseColor.WHITE);
   cell22.setBorderColor(BaseColor.WHITE);
//    document.add(preface);
   table11.addCell(cell21);
    table11.addCell(cell22);
     //table11.getDefaultCell().setBorderWidth(0);
     
    document.add(table11);
    document.add(new Paragraph("\n"));
    // document.add(preface2);
    PdfPCell cell1 = new PdfPCell();
    PdfPTable table1 = new PdfPTable(3);
    cell1.addElement(new Phrase("WATER BILL FOR"));
    cell1.addElement(new Phrase(xxmon + "  " + xyr));

    PdfPCell cell2 = new PdfPCell();
    cell2.addElement(new Phrase("INVOICE NO"));
    cell2.addElement(new Phrase(invno));

    PdfPCell cell3 = new PdfPCell();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
   LocalDateTime now = LocalDateTime.now();  
   // LocalDate tomorrow = LocalDate.now().plusDays(1);
    cell3.addElement(new Phrase("DATE OF ISSUE"));
    cell3.addElement(new Phrase(dtf.format(now)));

    table1.addCell(cell1);
    table1.addCell(cell2);
    table1.addCell(cell3);
  //  PdfPTable ss=createTable1();
   // document.add(ss);
    document.add(table1);

    document.add(new Paragraph("\n\n"));

}
public void detailline()
{
    
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
   LocalDateTime now = LocalDateTime.now().plusDays(14);  
 //  Date dd = new Date().plusDays(14);
   // LocalDate tomorrow = LocalDate.now().plusDays(1);
   // cell3.addElement(new Phrase("DATE OF ISSUE"));
  //  cell3.addElement(new Phrase(dtf.format(now)));
    String ddat=dtf.format(now);
     PdfPCell cell1 = new PdfPCell();
   //  PdfPTable detailline_table = new PdfPTable(3);
    cell1.addElement(new Phrase("PLEASE PAY THIS BILL ON OR BEFORE "+ddat+" TO AVOID DISCONNECTION",font11));
   // cell1.addElement(new Phrase("ON OR BEFORE"));
  //  cell1.addElement(new Phrase("TO AVOID DISCONNECTION"));

     //PdfPCell cells[]=cell2_cell3();
   
    detailline_table.deleteBodyRows();
    detailline_table.addCell(cell1);
          try {
              cell2_cell3();
          } catch (SQLException ex) {
              Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
          }
         
}

public void  cell2_cell3() throws SQLException
{
    // PdfPCell cells[]=null;
    PdfPTable gt=new PdfPTable(2);
   // gt.setp
   gt.setWidthPercentage(100);
    PdfPCell cell2 = new PdfPCell();
    PdfPCell cell3 = new PdfPCell();
     PdfPCell bfcell = new PdfPCell();
     
   //setHorizontalAlignment(Element.ALIGN_RIGHT);
          bfcell.addElement(new Phrase("BALANCE B/F"));
       //   bfcell.setHorizontalAlignment(HIDE_ON_CLOSE); = Element.ALIGN_RIGHT;
        bfcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
          gt.addCell(bfcell);
         
          gt.addCell(get_bal());
          gt.addCell("Payment");
          gt.addCell(get_payment());
            gt.addCell("Monthly Bill");
          gt.addCell(get_amt());
            gt.addCell("Standing Charge");
          gt.addCell(get_samt());
       
    
   
    //  MessageBox.infoBox(get_samt(), get_amt());
    //  for (int i = 1; i < 15; ++i) {
    Connection connx = DBconnect.ConnecrDb();
    String sqlx = "SELECT * from debits where CONCAT(yr,mon)='" + xyr + xmon + "' and membid='" + membid + "' ";
    System.out.println(sqlx);
    pst6 = connx.prepareStatement(sqlx);
    rs6 = pst6.executeQuery();
    //rs.first();
    xcnt = 0;
    while (rs6.next()) {

        // String n =rs6.getString("descr");
        xcnt = xcnt + 1;
        gt.addCell(rs6.getString("comm"));

        gt.addCell(rs6.getString("amt"));

    }
    // gt.addCell(get_samt());
  
    int mcnt = 10 - xcnt;
    String scnt = Integer.toString(mcnt);
     // MessageBox.infoBox(scnt, sqlx);
      for (int i = 1; i < mcnt; ++i) {
          gt.addCell(new Phrase("\n"));

         // cell3.addElement(new Phrase("\n"));
      }
      cell2.addElement(gt);
    detailline_table.addCell(cell2);
  //  detailline_table.addCell(cell3);
    detailline_table.getDefaultCell().setBorderWidth(0);
    // end loop  
    // return cells;
}
public String get_payment() throws SQLException
{
    String pay = "0";
    
    String sql = "SELECT count(*) as cnt,sum(amt) as pay from payments where CONCAT(yr,mon)='" + xyr + xmon + "' and membid='" + membid + "'";
    Connection connz = DBconnect.ConnecrDb();
    System.out.println(sql+"dddddddddddddddddddddddddddddddd");
    pst22p = connz.prepareStatement(sql);
    rs22p = pst22p.executeQuery();

    while (rs22p.next()) {

        pay = rs22p.getString("pay");

    }
    if(pay==null)
    {
        pay = "0";
    }
    return pay;
}


public String get_bal() throws SQLException
{
    String pay = "0";
    String sql = "SELECT count(*) as cnt,sum(amt) as pay from billbal  where CONCAT(yr,mon)<'" + xyr + xmon + "' and membid='" + membid + "'";
    Connection connz = DBconnect.ConnecrDb();
    System.out.println(sql);
    pst22p = connz.prepareStatement(sql);
    rs22p = pst22p.executeQuery();
    while (rs22p.next()) {
        pay = rs22p.getString("pay");
    }
     if(pay==null)
    {
        pay = "0";
    }
    return pay;
}
public String get_amt() throws SQLException
{
  //String tamt= rs.getString("amt");
   return amt;
}
public String get_samt() throws SQLException
{
  //String tamt= rs.getString("samt");
   return samt;
}
public PdfPTable header1()
{
      PdfPCell cell1 = new PdfPCell();
    cell1.addElement(new Phrase("TO: "));
    cell1.addElement(new Phrase(nam));
    cell1.addElement(new Phrase(paddr));
    cell1.addElement(new Phrase("Plot No:"+plotno));
    PdfPCell cell2 = new PdfPCell();
    cell2.addElement(new Phrase("Account No : "+membid));
    cell2.addElement(new Phrase("Meter No : "+metno));
   // cell1.addElement(new Phrase("sdfddsdfd"));
    PdfPTable table1 = new PdfPTable(2);;
    table1.addCell(cell1);
    table1.addCell(cell2);
    return table1;
}

public void add_readings(PdfPTable table) throws SQLException
  {       
      //table.set
      Connection connq = DBconnect.ConnecrDb();
      String sql = "SELECT * from readings where CONCAT(yr,mon)='"+xyr+xmon+"' and membid='"+membid+"' limit 0,1";
      System.out.println(sql);
      pst = connq.prepareStatement(sql);
      rs = pst.executeQuery();
      //rs.first();

      while (rs.next()) {
          //  table.set
           mamt=rs.getString("bamt");
            amt=rs.getString("amt");
             samt=rs.getString("samt");
             
          table.addCell(rs.getString("rdate"));
          table.addCell(rs.getString("pread"));
          table.addCell(rs.getString("rdate"));
          table.addCell(rs.getString("cread"));
          table.addCell(rs.getString("cons"));
          table.addCell(rs.getString("typ"));
      }
  }
public static PdfPTable createTable1() throws DocumentException {
        PdfPTable table = new PdfPTable(3);
       // table.setWidthPercentage(288 / 5.23f);
        table.setWidths(new int[]{2, 1, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Table 1"));
        cell.setColspan(3);
        cell.setRowspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
      //  cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
         table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        
        return table;
    }
private void addTableHeader(PdfPTable table) {
    Stream.of("PREVIOUS READING", "PREVIOUS READING DATE", "CURRENT READING","CURRENT READING DATE","CONSUMPTION","BILL TYPE")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle,font10));
        table.addCell(header);
    });
}

private void addTableHeader2(PdfPTable table) {
    Stream.of("Transaction Code", "Name", "Date/Time")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
    });
}
 private void addCustomRows(PdfPTable table) 
  throws URISyntaxException, BadElementException, IOException {
  
}
 public void http() throws IOException
 {
     URL yahoo = new URL("http://localhost/ebills/kiwacoe.php?yr=" + xyr + "&mon=" + xmon + "&reg=" + xreg);
     System.out.println("http://localhost/ebills/kiwacoe.php?yr=" + xyr + "&mon=" + xmon + "&reg=" + xreg);
     URLConnection yc = yahoo.openConnection();
     BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
     String inputLine;
     while ((inputLine = in.readLine()) != null) //  System.out.println(inputLine);
     {
        MessageBox.infoBox(inputLine, "Feedback");
     }
     in.close();
      
 }
 public void http_bal() throws IOException
 {
     
    URL yahoo = new URL("http://localhost/ebills/sms22.php");
 //   System.out.println("http://localhost/ebills/sms20.php?yr="+xyr+"&mon="+xmon+"&reg="+xreg);    
    URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;
        double t=0;
        String qq="";  //Double.toString(t)
        while ((inputLine = in.readLine()) != null) 
          t=Double.parseDouble(inputLine);
          //  System.out.println(inputLine);
       //   bal.
       //  qq= Double.toString(t) ;
       //     bal.setText();
        inputLine=  Format_amt.formatx( Double.toString(t));
           bal.setText(inputLine);
          //  MessageBox.infoBox(inputLine, "Feedback");
        in.close();

 }
 public void readmaster () throws SQLException, DocumentException
 {
     
     String  sql = "SELECT * from saccodb where reg='"+xreg+"' order by membid";
    Connection connz = DBconnect.ConnecrDb();
    System.out.println(sql);
    pst22 = connz.prepareStatement(sql);
    rs22 = pst22.executeQuery();
    
   
       
     int t = 0;
     int cnt = 0;
     int knt=0;
     this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
     while (rs22.next()) {
        
       
         
          membid = rs22.getString("membid");
         nam = rs22.getString("nam");
         paddr = rs22.getString("paddr");
         metno = rs22.getString("metno");
          plotno = rs22.getString("plotno");
         t = check_readings();
         if (t > 0) {
              knt = knt + 1;
            
             cnt = cnt + 1;

             makepdf();
             document.newPage();
         }
        

     }
      String sknt = Integer.toString(knt);
       this.setCursor(Cursor.getDefaultCursor());
       MessageBox.infoBox(sknt+" Bills processed!", "Print Bills");
 }
 public int check_readings() throws SQLException
 {
  Connection connq = DBconnect.ConnecrDb();
      String sqld = "SELECT count(*) as cnt,seq from readings where CONCAT(yr,mon)='"+xyr+xmon+"' and membid='"+membid+"' ";
      System.out.println(sql);
      pst9 = connq.prepareStatement(sqld);
      rs9 = pst9.executeQuery();
       System.out.println(sqld);
      //rs.first();
     int yy=0;
      while (rs9.next()) {
          //  table.set
      //    mamt=rs.getString("bamt");
          yy =rs9.getInt("cnt");
           invno =rs9.getString("seq");
        
      }
      
      return yy;
 }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> mon;
    private javax.swing.JComboBox<String> reg;
    private javax.swing.JComboBox<String> yr;
    // End of variables declaration//GEN-END:variables
}
