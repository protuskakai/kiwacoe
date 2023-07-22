/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    import java.sql.*;

    import java.util.*;


    public class NewClass {


        public static void main(String[] args)

        {

            if (args.length == 0)

    	    {

    	  // System.out.println("ERROR: connection URL must be provided in order to run   the demo!");

    	  //  return;

    	    }


            String url =   "jdbc:informix-sqli://emily:1533:informixserver=emily3;user=rdtest;password=test";

    	Connection conn = null;

            int        rc;

    	String     cmd=null;


            String testName = "Create Database";


    	System.out.println(">>>" + testName + " test.");

    	System.out.println("URL = \"" + url + "\"");


    	try 

    	    {

    	    Class.forName("com.informix.jdbc.IfxDriver");

    	    } 

    	catch (Exception e)

    	    {

    	    System.out.println("ERROR: failed to load Informix JDBC driver.");

    	    e.printStackTrace();

    	    return;

    	    }


    	try 

    	    {

    	    conn = DriverManager.getConnection(url);

    	    } 

    	catch (SQLException e) 

    	    {

    	    System.out.println("ERROR: failed to connect!");

    	    System.out.println("ERROR: " + e.getMessage());

    	    e.printStackTrace();

    	    return;

    	    }


    	try

    	    {

    	    Statement stmt = conn.createStatement();

    	    cmd = "create database testDB;";

    	    rc = stmt.executeUpdate(cmd);

    	    stmt.close();

    	    }

    	catch (SQLException e)

    	    {

    	    System.out.println("ERROR: execution failed - statement: " + cmd);

    	    System.out.println("ERROR: " + e.getMessage());

    	    e.printStackTrace();

    	    return;

    	    }


    	try 

    	    {

                conn.close();

    	    } 

    	catch (SQLException e) 

    	    {

    	    System.out.println("ERROR: failed to close the connection!");

    	    e.printStackTrace();

    	    return;

    	    }


    	System.out.println(">>>End of " + testName + " test.");

        }

    }
