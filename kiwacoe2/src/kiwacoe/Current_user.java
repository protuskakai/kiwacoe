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
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */


public class Current_user {

   static  ResultSet rs = null;
          public String mx,sql;

       static PreparedStatement pst = null;

    public static String[] usr()  {
      String user=Login.user;  
      String pwd=Login.pwd; 
      String typ=Login.typ; 
      String ff[]={user,pwd,typ};
      
      return ff;
    }
}


