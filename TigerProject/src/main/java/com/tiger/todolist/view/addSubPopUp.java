/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

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
    public class addSubPopUp extends JFrame{
    private JLabel addSubtask = new JLabel("Add SubTask");

   
    private JTextField entSubtaskName = new JTextField();
    private JButton confirm = new JButton("Add task");
    
    private popupWindows listener = new popupWindows(); 
    private static addSubPopUp instance = null; 
    
    public static addSubPopUp getInstance(){
        if(addSubPopUp.instance == null) addSubPopUp.instance = new addSubPopUp();
                return addSubPopUp.instance; 
    }
    
    public static void deleteObject(){
         addSubPopUp.instance = null; 
    }
    
    public addSubPopUp(){
        this.setLayout(new GridLayout(3,1));
        
        this.add(addSubtask);
        confirm.addActionListener(listener);
        confirm.setActionCommand("addSub");
        this.add(entSubtaskName);
        this.add(confirm);
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        
    }

    public JTextField getEntSubtaskName() {
        return entSubtaskName;
    }
      

   
}

    
