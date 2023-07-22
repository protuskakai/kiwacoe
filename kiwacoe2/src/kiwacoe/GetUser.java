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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
//import static javafxapplication9.FXMLDocumentController.conn;
 
/**
 *
 * @author user
 */
public class GetUser {

 //static  String pattern = "###,###.00";
 // static DecimalFormat decimalFormat = new DecimalFormat(pattern);
    

    static String[] data() {
       
        String user = Login.user;
        String pwd = Login.pwd;
        String typ = Login.typ;
        String xx[] = {user, pwd, typ};

       return xx;
    }
}
