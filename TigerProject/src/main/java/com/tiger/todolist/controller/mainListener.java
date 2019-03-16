/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.controller;

import com.tiger.todolist.model.Board;
import com.tiger.todolist.view.SignIn;
import com.tiger.todolist.view.TaskBoard;
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
         String un = SignIn.getUserName().getText();
         String pn = SignIn.getPassword().getText();
         int currentUser = Board.getStatus().findUser(un,pn);
         
        if(e.getActionCommand().equals("confirm")){
            
            if(Board.getStatus().findUser(un,pn) != -1){
                mainWindow window = new mainWindow();
            }
            else JOptionPane.showMessageDialog(null, "Incorrect login details");
        }    
         //DISPLAYING USER TASKS
         for(int i = 0; i < getListNames().length; i++){
                if(e.getActionCommand().equals("thisList"+i)){
                    JOptionPane.showMessageDialog(null, i+": This list clicked");
                    TaskBoard taskView = new TaskBoard(i);
                    
                    taskWindow mainTask = new taskWindow(taskView);
                    
                 
                    
                    }
                }  
        
        
    }
    
    public String getListTitle(int listId){
        String un = SignIn.getUserName().getText();
        String pn = SignIn.getPassword().getText();
        int userIndex = Board.getStatus().findUser(un,pn);
        String listName = Board.getStatus().getUsers().get(userIndex).getList().get(listId).getTitle();
        return listName;
    }
    
    public String[] getListNames(){  // Retrieves the list names of of user
        String un = SignIn.getUserName().getText();
        String pn = SignIn.getPassword().getText();
        int userIndex = Board.getStatus().findUser(un,pn);
        String[] store = Board.getStatus().getUsers().get(userIndex).showLists();
        
        return store;
    }
    
   
     public String[] getTaskDetails(int listId){
        String un = SignIn.getUserName().getText();
        String pn = SignIn.getPassword().getText();
        int userIndex = Board.getStatus().findUser(un,pn);
        
         String[] taskDetails = Board.getStatus().getUsers().get(userIndex).getList().get(listId).getTaskDetails();
         
         return taskDetails; 
     }
     
}
