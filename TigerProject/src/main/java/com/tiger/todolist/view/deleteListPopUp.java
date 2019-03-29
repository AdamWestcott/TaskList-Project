/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.mainListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author k1746252
 */
public class deleteListPopUp extends JFrame {
     private JLabel deleteList = new JLabel("Delete List");

   
    private JTextField entListName = new JTextField();
    private JButton confirm = new JButton("delete List");
    private mainListener Mainlistener = new mainListener(); 
    private static deleteListPopUp instance = null; 
    
    public static deleteListPopUp getInstance(){
        if(deleteListPopUp.instance == null) deleteListPopUp.instance = new deleteListPopUp();
                return deleteListPopUp.instance; 
    }
    
    public static void deleteObject(){
         deleteListPopUp.instance = null; 
    }
    
    public deleteListPopUp(){
         this.setLayout(new GridLayout(3,1));
        this.add(deleteList);
        confirm.addActionListener(Mainlistener);
        confirm.setActionCommand("deleteList");
        this.add(entListName);
        this.add(confirm);
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public JTextField getEntListName() {
        return entListName;
    }
}

