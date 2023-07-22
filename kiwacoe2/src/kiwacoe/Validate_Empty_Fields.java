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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class Validate_Empty_Fields {

   

    public static int validate_textfields(JTextField nn[])  {
        int x = 0;

        int jj = nn.length;
        for (int i = 0; i < jj; i++) {
            if (nn[i].getText().trim().isEmpty()) {
                x = 1;
                
            }
        }
       if (x==1)
       {
           MessageBox.infoBox("Empty Fields Not Allowed", "Can't Save Record");
       }
        return x;

    }
public static int validate_comboboxes(JComboBox nn[])  {
        int x = 0;

        int jj = nn.length;
        String sjj = Integer.toString(jj);
       // msbbox.show(Alert.AlertType.ERROR, sjj, "Can't Save Record", "Error");
        for (int i = 0; i < jj; i++) {
            if (nn[i].getSelectedItem() == null) {
                x = 1;
            }
        }
       if (x==1)
       {
            MessageBox.infoBox("Empty Fields Not Allowed", "Can't Save Record");
       }
        return x;

    }
}
