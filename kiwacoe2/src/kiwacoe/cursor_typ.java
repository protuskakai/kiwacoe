/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;
//import static javafxapplication9.FXMLDocumentController.conn;

/**
 *
 * @author user
 */
public class cursor_typ {

    public static Cursor busy() {
        Cursor mm = null;

        mm = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);

        // mm=Cursor.getDefaultCursor();
        return mm;
    }

    public static Cursor notbusy() {
        Cursor mm = null;
        mm = Cursor.getDefaultCursor();

        return mm;
    }

}
