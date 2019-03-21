/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.controller;

import com.tiger.todolist.model.Board;
import com.tiger.todolist.model.User;
import com.tiger.todolist.view.SignIn;
import com.tiger.todolist.view.TaskBoard;
import com.tiger.todolist.view.addTaskPopUp;
import com.tiger.todolist.view.taskWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author k1732912
 */
public class popupWindows implements ActionListener {
    int currentUser = Board.getStatus().findUser(getUserName(),getPassword());
    User user = Board.getStatus().getUsers().get(currentUser); 
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("addTask") ){ //TaskBoard "Add list" button listener
         addTaskPopUp.getInstance();
            
       }
       else if(e.getActionCommand().equals("add")){
          
          String passTaskName = addTaskPopUp.getInstance().getEntTaskName().getText();
          String passTaskDesc = addTaskPopUp.getInstance().getEntDescript().getText();
          String passDueDate = addTaskPopUp.getInstance().getEntDueDate().getText();
          int passPriority = Integer.parseInt(addTaskPopUp.getInstance().getPriorities().getSelectedItem().toString());
          user.getList().get(mainListener.pastList).createTask(false, passTaskDesc, passDueDate, passPriority, passTaskName);
          addTaskPopUp.getInstance().dispose();
          //NOTES TO TEAM: IDEA IS TO MAKE TASK WINDOW SINGLETON - SO WHEN 
          //::addTaskPopUP CLOSES A NEW TASKWINDOW OPENS on press of "add"
//          TaskBoard taskView = new TaskBoard(mainListener.pastList);
//          taskWindow mainTask = new taskWindow(taskView);    
        }
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
