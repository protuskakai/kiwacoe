/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.awt.GridLayout;
import javax.swing.*;
/**
 *
 * @author user
 */
public class Kalenda2 extends JFrame {
    private JPanel panel;
     private JPanel panel2;
    public Kalenda2(int rows,int cols,int hgap,int vgap){
        panel=new JPanel(new GridLayout(rows, cols, hgap, vgap));
        panel2=new JPanel(new GridLayout(1, 1, 12, 10));
        JComboBox gh=new JComboBox();
        panel2.add(gh);
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=cols;j++)
            {
                JButton btn=new JButton(String.valueOf(i));
                panel.add(btn);
            }
        }
        add(panel2);
         pack();
        add(panel);
        pack();
        setVisible(true);
    }
}