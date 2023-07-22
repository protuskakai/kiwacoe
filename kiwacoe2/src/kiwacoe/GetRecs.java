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
import static kiwacoe.LoansNew_Capture.zyr;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class GetRecs {
    static ResultSet rs = null;
    static public String mx, sql;
    static PreparedStatement pst2 = null;
    static ResultSet rs2 = null;
    static Connection conn = DBconnect.ConnecrDb();
    static PreparedStatement pst = null;

    public static int cnt(String sql) throws SQLException {
        int cmt = 0;
        // String sql = "SELECT count(*) as cnt from loans where yr='" + zyr + "' and mon='" + zmon + "' ";
        //  Connection conn = DBconnect.ConnecrDb();
        System.out.println(sql);
      //  MessageBox.infoBox(sql, "sql");
        pst2 = conn.prepareStatement(sql);
        rs2 = pst2.executeQuery();
        rs2.next();
        cmt = rs2.getInt("cnt");
        return cmt;
    }
}
