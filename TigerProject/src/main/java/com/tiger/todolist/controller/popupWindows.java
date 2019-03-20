/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.controller;

import com.tiger.todolist.view.addTaskPopUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author k1732912
 */
public class popupWindows implements ActionListener {
    
    addTaskPopUp over; 
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("addTask") ){ //TaskBoard "Add list" button listener
         over = new addTaskPopUp();
            
       }
       else if(e.getActionCommand().equals("add")){
          System.out.println("Pressed");
         
          String passTaskName = addTaskPopUp.getEntTaskName().getText();
          String passTaskDesc = addTaskPopUp.getEntDescript().getText();
          String passDueDate = addTaskPopUp.getEntDueDate().getText();
          String passPriority = addTaskPopUp.getPriorities().getSelectedItem().toString();

          
           System.out.println(passTaskName);
           System.out.println(passTaskDesc);
           System.out.println(passDueDate);
           System.out.println(passPriority);
          
           
                
        }
    }
      
 }
