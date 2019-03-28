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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author k1732912
 */
public class addTaskPopUp extends JFrame{
    private JLabel addTask = new JLabel("Add Task");
    private JLabel taskName = new JLabel("Enter Task Name");
    private JLabel description = new JLabel("Enter Description:");
    private JLabel dueDate = new JLabel("Due Date:");
    private JLabel priority = new JLabel("Select Priority:");

   
    private JTextField entTaskName = new JTextField();
    private JTextArea entDescript = new JTextArea();
    private JTextField entDueDate = new JTextField();
    private String[] priotityLvls = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"}; 
    private JComboBox<String>  priorities = new JComboBox<String>(priotityLvls);
    private JButton confirm = new JButton("Add task");
    
    private popupWindows listener = new popupWindows(); 
    private static addTaskPopUp instance = null; 
    
    public static addTaskPopUp getInstance(){
        if(addTaskPopUp.instance == null) addTaskPopUp.instance = new addTaskPopUp();
                return addTaskPopUp.instance; 
    }
    
    public static void deleteObject(){
         addTaskPopUp.instance = null; 
    }
    
    public addTaskPopUp(){
        this.setLayout(new GridLayout(10,1));
        
        this.add(addTask);
        this.add(taskName);
        this.add(entTaskName);
        this.add(description);
        this.add(entDescript);
        this.add(dueDate);
        this.add(entDueDate);
        this.add(priority);
        this.add(priorities);
        
        confirm.addActionListener(listener);
        confirm.setActionCommand("add");
        this.add(confirm);
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        
    }
      public JTextField getEntTaskName() {
          return entTaskName;
    }

    public JTextArea getEntDescript() {
        return entDescript;
    }

    public JTextField getEntDueDate() {
        return entDueDate;
    }

    public JComboBox<String> getPriorities() {
        return priorities;
    }
   
}
