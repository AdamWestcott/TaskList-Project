/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.controller.popupWindows;
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
public class addListPopUp extends JFrame {
    private JLabel addList = new JLabel("Add List");

   
    private JTextField entListName = new JTextField();
    private JButton confirm = new JButton("Add task");
    private mainListener Mainlistener = new mainListener(); 
    private static addListPopUp instance = null; 
    
    public static addListPopUp getInstance(){
        if(addListPopUp.instance == null) addListPopUp.instance = new addListPopUp();
                return addListPopUp.instance; 
    }
    
    public static void deleteObject(){
         addListPopUp.instance = null; 
    }
    
    public addListPopUp(){
        this.setLayout(new GridLayout(3,1));
        
        this.add(addList);
        confirm.addActionListener(Mainlistener);
        confirm.setActionCommand("addList");
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
