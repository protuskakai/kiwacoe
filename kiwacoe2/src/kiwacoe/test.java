/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.informix.*;

public class test {
    static String url="jdbc:informix-sqli://62.24.113.58:10000/water:INFORMIXSERVER=62.24.113.58:10000;user=pkakai;password=abc123";

    public static void ddd(){
        try {
            Class.forName("com.informix.jdbc.IfxDriver");
        }catch (Exception e){
            System.out.println("ERROR: failed to load Informix JDBC driver.");
            e.printStackTrace();
            return;
        }
        try{

            DriverManager.registerDriver((com.informix.jdbc.IfxDriver)Class.forName("com.informix.jdbc.IfxDriver").newInstance());

        }catch(Exception ex){
            System.out.println("Driver is not Registered");
        }
        try{

            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection Successful");
        }catch (SQLException e){
            System.out.println("ERROR: failed to connect!");
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        }
}

