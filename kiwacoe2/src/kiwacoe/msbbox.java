/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.util.Optional;
import static javafx.application.Application.launch;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author user
 */
public class msbbox 
{
    

        


 
public static void show(Alert.AlertType mx,String infoMessage, String titleBar, String headerMessage)
    {
        
        Alert alert = new Alert(mx);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

public static boolean showyesno(Alert.AlertType alertType,String titleBar, String statement) {
    Alert alert = new Alert(alertType, statement);
    alert.setTitle(titleBar);
   // alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
   alert.getButtonTypes().clear();
   alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
    Optional<ButtonType> choose = alert.showAndWait();
    return choose.get() == ButtonType.YES;
}


}
