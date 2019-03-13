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
import java.util.EventObject;


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
        
        else if(e.getActionCommand().equals("confirm")){
            String un = SignIn.getUserName().getText();
            String pn = SignIn.getPassword().getText();
            
            if(Board.getStatus().findUser(un,pn) != -1){
                mainWindow window = new mainWindow();
                
            }    
            else
                JOptionPane.showMessageDialog(null, "Incorrect login details");
            }
        else if(e.getActionCommand().equals("thisList")){
            taskWindow abc = new taskWindow();
        }
    }
    
    public static String[] getListNames(){
        //String[] store = Board.getStatus().getUsers().get(0).showLists();
        String un = SignIn.getUserName().getText();
        String pn = SignIn.getPassword().getText();
        int userIndex = Board.getStatus().findUser(un,pn);
        String[] store = Board.getStatus().getUsers().get(userIndex).showLists();
        
        return store;
    }
    
   
     public static String[] getTaskDetails(){
         String[] taskDetails = Board.getStatus().getUsers().get(0).getList().get(0).getTaskDetails();
         
         return taskDetails; 
     }
     
}
