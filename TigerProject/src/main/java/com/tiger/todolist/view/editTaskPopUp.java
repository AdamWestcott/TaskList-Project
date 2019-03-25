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
public class editTaskPopUp extends JFrame{
    
    private JLabel editTask = new JLabel("Edit Task");
    private JLabel taskName = new JLabel("Edit Task Name");
    private JLabel description = new JLabel("Enter New Description:");
    private JLabel dueDate = new JLabel("Edit Due Date:");
    private JLabel priority = new JLabel("Change Priority:");
    
    
    private JTextField entTaskName = new JTextField();
    private JTextArea entDescript = new JTextArea();
    private JTextField entDueDate = new JTextField();
    private String[] priotityLvls = new String[]{"1","2","3","4","5","6","7","8","9","10"}; 
    private JComboBox<String>  priorities = new JComboBox<String>(priotityLvls);
    private JButton confirm = new JButton("Confirm Edit");
    
    private popupWindows listener = new popupWindows();
    private mainListener mainListen = new mainListener(); 
    private static editTaskPopUp instance = null;
    
    public static editTaskPopUp getInstance(){
        if(editTaskPopUp.instance == null) editTaskPopUp.instance = new editTaskPopUp();
                return editTaskPopUp.instance; 
    }
     public static editTaskPopUp getInstance(String taskName){
        if(editTaskPopUp.instance == null) editTaskPopUp.instance = new editTaskPopUp(taskName);
                return editTaskPopUp.instance; 
    }
    
    public static void deleteObject(){
         editTaskPopUp.instance = null; 
    }
    
    public editTaskPopUp(){}
    
    public editTaskPopUp(String tskName){
        this.setLayout(new GridLayout(10,1));
        this.add(editTask);
        
        String[] taskDetails =  mainListen.getTaskDetails(mainListen.pastList);
        
        for(int i =0; i < taskDetails.length;i++){
            String splitElements = taskDetails[i];
            String[] specificDetails = splitElements.split(",");
            
            if(specificDetails[1].equals(tskName) ){
                
                this.add(taskName);
                entTaskName.setText(specificDetails[1]);
                this.add(entTaskName);

                this.add(description);
                entDescript.setText(specificDetails[2]);
                this.add(entDescript);

                this.add(dueDate);
                entDueDate.setText(specificDetails[3]);
                this.add(entDueDate);

                this.add(priority);
                this.add(priorities); 
              }
        }
        
        
        confirm.addActionListener(listener);
        confirm.setActionCommand("edit");
        this.add(confirm);
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        
    }
    public void setEditTask(JLabel editTask) {
        this.editTask = editTask;
    }

    public void setEntDescript(JTextArea entDescript) {
        this.entDescript = entDescript;
    }

    public void setEntDueDate(JTextField entDueDate) {
        this.entDueDate = entDueDate;
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
