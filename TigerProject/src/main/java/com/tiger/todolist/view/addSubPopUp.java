/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.popupWindows;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private JLabel subDate = new JLabel("Add a Date");      
    private JLabel subPriority = new JLabel("Choose Priority");
    private JTextField entSubtaskName = new JTextField();
    private JTextField entSubTaskDate = new JTextField(); 
    private String[] priotityLvls = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    private JComboBox<String>  priorities = new JComboBox<String>(priotityLvls);
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
        this.setLayout(new GridLayout(10,1));
        this.add(addSubtask);
        this.add(entSubtaskName);
        
        this.add(subDate);
        this.add(entSubTaskDate);
        
        this.add(subPriority);
        this.add(priorities);
        
        confirm.addActionListener(listener);
        confirm.setActionCommand("addSub");
        this.add(confirm);
        
        
         Dimension newDim= new Dimension(500,300);
        this.setPreferredSize(newDim);
        this.setMaximumSize(newDim);
        this.setSize(newDim);
        this.revalidate();//Calling all is an instruction to tell the layout manager to reset based on the new component list 
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        
    }

    public JTextField getEntSubtaskName() {
        return entSubtaskName;
    }

    public JTextField getEntSubTaskDate() {
        return entSubTaskDate;
    }

    public JComboBox<String> getPriorities() {
        return priorities;
    }
      

   
}

    
