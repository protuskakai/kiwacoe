/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import javax.swing.JOptionPane;

public class MessageBox
{

    public static void infoBox(String infoMessage, String titleBar)
    {
       // JOptionPane.;    
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.PLAIN_MESSAGE);
    }
}

