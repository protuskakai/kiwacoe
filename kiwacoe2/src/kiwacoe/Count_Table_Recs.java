/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import static kiwacoe.Expenses_Capture.sql;
import static kiwacoe.Validate_batchstatus.pst;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Count_Table_Recs {

   static  ResultSet rs = null;
          public String mx,sql;

       static PreparedStatement pst = null;
        static PreparedStatement pst2 = null;
         static PreparedStatement pst22 = null;

    public static JComboBox locs(JComboBox nn) throws SQLException  {
        nn.removeAll();
        nn.addItem("");
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "SELECT * from locations ";
        String fld="";
        pst = conn.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {

         fld= rs.getString("loc");
          nn.addItem(fld);
        }

        return nn;
    }
     public static String[] yrmon(String yr,String mon,String batname,String transname) throws SQLException  {
       
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "select count(*) as cnt,sum(amt) as tot from "+transname+" where CONCAT(yr,mon)='"+yr+mon+"'";
        String fld="";
        pst = conn.prepareStatement(sql);
        System.out.print(sql);
        rs = pst.executeQuery();
        String scnt="0";
        String stot="0";
        while (rs.next()) {

         scnt= rs.getString("cnt");
         int ycnt = rs.getInt("cnt");
         stot= rs.getString("tot");
            if (ycnt==0) {
                stot = "0";
            }
            
       //     MessageBox.infoBox(scnt+stot, stot);
        //  nn.addItem(fld);
        }


      //  return nn;
      
      sql="update "+batname+" set recs="+scnt+",tot="+stot+" where  CONCAT(yr,mon)='"+yr+mon+"'";
       System.out.println(sql);
          try {
              pst2=conn.prepareStatement(sql);
              pst2.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(BatchTotals.class.getName()).log(Level.SEVERE, null, ex);
           //   MessageBox.infoBox("Record Update Error", "Error");
             //msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
            
          }
           if (stot == null) {
              stot = "0";
          }
           String[] xx={scnt,stot};
             
             return xx;
    }
      public static String[] yrmontyp(String yr,String mon,String typ,String batname,String transname) throws SQLException  {
       
        Connection conn = DBconnect.ConnecrDb();
       
        String sql = "select count(*) as cnt,sum(amt) as tot from "+transname+" where CONCAT(yr,mon,typ)='"+yr+mon+typ+"'";
        String fld="";
        pst = conn.prepareStatement(sql);
        System.out.print(sql);
        rs = pst.executeQuery();
        String scnt="0";
        String stot="0";
        while (rs.next()) {

         scnt= rs.getString("cnt");
         stot= rs.getString("tot");
        //  nn.addItem(fld);
        }

      //  return nn;
      
      sql="update "+batname+" set recs="+scnt+",tot="+stot+" where  CONCAT(yr,mon,typ)='"+yr+mon+typ+"'";
       System.out.println(sql);
          try {
              pst2=conn.prepareStatement(sql);
              pst2.executeUpdate(sql);
             //    rs= pst.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(BatchTotals.class.getName()).log(Level.SEVERE, null, ex);
           //   MessageBox.infoBox("Record Update Error", "Error");
             //msbbox.show(Alert.AlertType.ERROR, ex.toString(),"insertrec Method" ,"Database Error");
            
          }
          if (stot == null) {
              stot = "0";
          }
          String[] xx = {scnt, stot};

          return xx;
    }
      
      
   public static int count(String tabl,String wher) throws SQLException  {
       
        Connection conn = DBconnect.ConnecrDb();
       
       int x = 0;
        String sql = "SELECT COUNT(*) as count FROM " +tabl+ " where  "+wher;
        Connection connx = DBconnect.ConnecrDb();
          System.out.println(sql);
        pst = connx.prepareStatement(sql);

        rs = pst.executeQuery();
        rs.first();
        x = Integer.valueOf(rs.getString("count"));

        return x;
    }     
      
}
