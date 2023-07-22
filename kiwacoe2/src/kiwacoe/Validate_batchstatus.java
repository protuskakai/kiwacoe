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
import javafx.scene.control.Alert;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Validate_batchstatus {

    static ResultSet rs = null;
    static String mx, sql;

    static PreparedStatement pst = null;

    public static int validate(String yr, String mon,String tabl) throws SQLException {

        int x = 0;
        String sql = "SELECT COUNT(*) as count FROM " +tabl+ "  where yr='" + yr + "' and mon='" + mon + "' and stat='Open'";
        Connection connx = DBconnect.ConnecrDb();
          System.out.println(sql);
        pst = connx.prepareStatement(sql);

        rs = pst.executeQuery();
        rs.first();
        x = Integer.valueOf(rs.getString("count"));

        return x;

    }

}
