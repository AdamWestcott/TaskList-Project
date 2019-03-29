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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author k1746252
 */
public class editSubTaskPopUp extends JFrame {
    private JLabel editSubTask = new JLabel("Edit SubTask");
    private JLabel SubtaskName = new JLabel("Edit SubTask Name");
    
    private JTextField entSubTaskName = new JTextField();
     private JButton Subconfirm = new JButton("Confirm Edit");
    
    private popupWindows listener = new popupWindows();
    
    private static editSubTaskPopUp instance = null;
  
    public static editSubTaskPopUp getInstance(String subTaskName,int subTaskId){
        if(editSubTaskPopUp.instance == null) editSubTaskPopUp.instance = new editSubTaskPopUp(subTaskName,subTaskId);
                return editSubTaskPopUp.instance; 
    }
    
    public static editSubTaskPopUp getInstance(){
        if(editSubTaskPopUp.instance == null) editSubTaskPopUp.instance = new editSubTaskPopUp();
                return editSubTaskPopUp.instance; 
    }
    
    
     public static void deleteObject(){
         editSubTaskPopUp.instance = null; 
    }
     public editSubTaskPopUp(){}
     
    public editSubTaskPopUp(String subTaskName,int subTaskId){
    this.setLayout(new GridLayout(10,1));
    String[] SubtaskDetails =  listener.getSubTaskDetails();
    this.add(editSubTask);
   
            String splitElements = SubtaskDetails[subTaskId];
            String[] specificDetails = splitElements.split(",");
            if(specificDetails[1].equals(subTaskName) ){
                
                this.add(SubtaskName);
                entSubTaskName.setText(specificDetails[1]);
                this.add(entSubTaskName);
 
              }
            
//                entSubTaskName.setText(specificDetails[1]);
//                JTextField one = new JTextField();
//                
//                one.setText(entSubTaskName.getText());
//                this.add(one);
  
    
        Subconfirm.addActionListener(listener);
        Subconfirm.setActionCommand("subedit");
        
        this.add(Subconfirm);
        
        Dimension newDim= new Dimension(500,150);
        this.setSize(500,400);
        this.setPreferredSize(newDim);
        this.setMaximumSize(newDim);
        this.setSize(newDim);
        this.revalidate();//Calling all is an instruction to tell the layout manager to reset based on the new component list 
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    public JLabel getEditSubTask() {
        return editSubTask;
    }

    public void setEditSubTask(JLabel editSubTask) {
        this.editSubTask = editSubTask;
    }

    public JTextField getEntSubTaskName() {
        return entSubTaskName;
    }

    public void setEntSubTaskName(JTextField entSubTaskName) {
        this.entSubTaskName = entSubTaskName;
    }
    
    
}
