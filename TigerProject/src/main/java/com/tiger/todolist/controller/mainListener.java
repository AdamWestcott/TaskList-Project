/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.controller;

import com.tiger.todolist.model.Board;
import com.tiger.todolist.model.User;
import com.tiger.todolist.view.SignIn;
import com.tiger.todolist.view.mainWindow;
import com.tiger.todolist.view.taskWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Lewys
 */
public class mainListener implements ActionListener {
// This class will listen for events in the mainWindow
// Each component has it's own action command, "If 'command' == something, do this...."
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("addListBut")){
            JOptionPane.showMessageDialog(null, "Clicked add List");
        }
        else if(e.getActionCommand().equals("signInButton")){
            SignIn signInForm = new SignIn();   
        }
        else if(e.getActionCommand().equals("confirm")){
                JOptionPane.showMessageDialog(null, "Clicked Confirm");
            }
        else if(e.getActionCommand().equals("thisList")){
            taskWindow taskWindow = new taskWindow();
             
        }
    }
    
    public static String[] getListNames(){
        String[] store = Board.getStatus().getUsers().get(0).showLists();
        return store;
    }
    
//    public static String[] getTaskNames(){
//        String[] store = Board.getStatus().getUsers().get(0).getList().get(0).showTasks();
//        return store;
//    }
   
     public static String[] getTaskDetails(){
         String[] taskDetails = Board.getStatus().getUsers().get(0).getList().get(0).getTaskDetails();
         
         return taskDetails; 
     }
    
}
