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
    
    static int pastList = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
         int currentUser = Board.getStatus().findUser(getUserName(),getPassword());
         
         //
        if(e.getActionCommand().equals("confirm")){
            
            if(Board.getStatus().findUser(getUserName(),getPassword()) != -1){
                mainWindow.getInstance();
            }
            else JOptionPane.showMessageDialog(null, "Incorrect login details");
        }    
         //DISPLAYING USER TASKS
         for(int i = 0; i < getListNames().length; i++){
                if(e.getActionCommand().equals("thisList"+i)){
                    JOptionPane.showMessageDialog(null, i+": This list clicked");
                    TaskBoard taskView = new TaskBoard(i);
                    taskWindow mainTask = new taskWindow(taskView);
                    pastList = i; 
                    }
                }  
        
        
    }
    
    public String getListTitle(int listId){
        int userIndex = Board.getStatus().findUser(getUserName(),getPassword());
        String listName = Board.getStatus().getUsers().get(userIndex).getList().get(listId).getTitle();
        return listName;
    }
    
    public String[] getListNames(){  // Retrieves the list names of of user
        int userIndex = Board.getStatus().findUser(getUserName(),getPassword());
        String[] store = Board.getStatus().getUsers().get(userIndex).showLists();
        
        return store;
    }
    
   
     public String[] getTaskDetails(int listId){
        int userIndex = Board.getStatus().findUser(getUserName(),getPassword());
        
         String[] taskDetails = Board.getStatus().getUsers().get(userIndex).getList().get(listId).getTaskDetails();
         
         return taskDetails; 
     }
     
     public String getUserName(){
         String un = SignIn.getInstance().getUserName().getText();
         return un;
     }
     
     public String getPassword(){
         String pn = SignIn.getInstance().getPassword().getText();
         return pn;
     }
     
}
