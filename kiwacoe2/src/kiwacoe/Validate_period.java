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
public class Validate_period {

    static ResultSet rs = null;
    static String mx, sql;

    static PreparedStatement pst = null;

    public static int validate(String yr, String mon) throws SQLException {

        int x = 0;
        String sql = "SELECT COUNT(*) as count  from periods  where yr='" + yr + "' and mon='" + mon + "' and status='Open'";
        Connection connx = DBconnect.ConnecrDb();
        pst = connx.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.first();
        x = Integer.valueOf(rs.getString("count"));

        return x;

    }
    public static int exists(String yr, String mon) throws SQLException {

        int x = 0;
        String sql = "SELECT COUNT(*) as count  from periods  where yr='" + yr + "' and mon='" + mon + "' ";
        Connection connx = DBconnect.ConnecrDb();
        pst = connx.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.first();
        x = Integer.valueOf(rs.getString("count"));

        return x;

    }

}
