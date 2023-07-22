/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;
//import static javafxapplication9.FXMLDocumentController.conn;
/**
 *
 * @author user
 */
public class DBconnect {   
public static Connection ConnecrDb() 
{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sacco2", "55509", "kitale");
            System.out.println("Connection success!");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            //msbbox.show(Alert.AlertType.ERROR, e.toString(),"New Record" ,"ffff");
            MessageBox.infoBox(e.toString(), "Error");
            return null;
        }
    }
}
