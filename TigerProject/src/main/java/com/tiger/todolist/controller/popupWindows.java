/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.controller;

import com.tiger.todolist.model.Board;
import com.tiger.todolist.model.SubTask;
import com.tiger.todolist.model.Task;
import com.tiger.todolist.model.User;
import com.tiger.todolist.view.SignIn;
import com.tiger.todolist.view.SubtaskBoard;
import com.tiger.todolist.view.TaskBoard;
import com.tiger.todolist.view.addSubPopUp;
import com.tiger.todolist.view.addTaskPopUp;
import com.tiger.todolist.view.editSubTaskPopUp;
import com.tiger.todolist.view.editTaskPopUp;
import com.tiger.todolist.view.mainWindow;
import com.tiger.todolist.view.subtaskWindow;
import com.tiger.todolist.view.taskWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author k1732912
 */
public class popupWindows implements ActionListener {
    private mainListener listener = new mainListener();
    int currentUser = Board.getStatus().findUser(getUserName(),getPassword());
    User user = Board.getStatus().getUsers().get(currentUser);
    public static int currentTask = 0; 
    public static int currentSubTask=0;
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("addTask") ){ //TaskBoard "Add list" button listener
           taskWindow.getInstance().dispose();
           taskWindow.deleteObject(); 
           addTaskPopUp.getInstance();
       }
       
       
       else if(e.getActionCommand().equals("back") ){
           taskWindow.getInstance().dispose();
           taskWindow.deleteObject();
           mainWindow.getInstance();
           
       }
       else if(e.getActionCommand().equals("add")){
          String passTaskName = addTaskPopUp.getInstance().getEntTaskName().getText();
          String passTaskDesc = addTaskPopUp.getInstance().getEntDescript().getText();
          String passDueDate = addTaskPopUp.getInstance().getEntDueDate().getText();
          int passPriority = Integer.parseInt(addTaskPopUp.getInstance().getPriorities().getSelectedItem().toString());
          user.getList().get(mainListener.pastList).createTask(false, passTaskDesc, passDueDate, passPriority, passTaskName);
          addTaskPopUp.getInstance().dispose();
          addTaskPopUp.deleteObject();
          taskWindow.getInstance(); 
          
        }
        else if(e.getActionCommand().equals("edit") ){
          String newTaskName = editTaskPopUp.getInstance().getEntTaskName().getText();
          String newTaskDesc = editTaskPopUp.getInstance().getEntDescript().getText();
          String newDueDate = editTaskPopUp.getInstance().getEntDueDate().getText();
          int passPriority = Integer.parseInt(editTaskPopUp.getInstance().getPriorities().getSelectedItem().toString());
          
          user.getList().get(mainListener.pastList).getTask().get(currentTask).setName(newTaskName);
          user.getList().get(mainListener.pastList).getTask().get(currentTask).setDescription(newTaskDesc);
          user.getList().get(mainListener.pastList).getTask().get(currentTask).setDueDate(newDueDate);
          user.getList().get(mainListener.pastList).getTask().get(currentTask).setPriority(passPriority);
          
          editTaskPopUp.getInstance().dispose();
          editTaskPopUp.deleteObject();
          taskWindow.getInstance(); 
        }
        else if(e.getActionCommand().equals("search")){
            String input = taskWindow.getInstance().getSearch().getText();
            boolean isNumber = true;
            int inputAsInt = 0; 
            try{
              inputAsInt = Integer.parseInt(input);  
            }
            catch(NumberFormatException err){
                    isNumber = false;    
            }
                if(isNumber && inputAsInt <= 10 &&  inputAsInt >0) {//Its a priority
                    taskWindow.getInstance().dispose();
                    taskWindow.deleteObject();
                    TaskBoard tb = new TaskBoard(mainListener.pastList,inputAsInt);
                    taskWindow.getInstance(tb);    
                }
                else{
                    taskWindow.getInstance().dispose();
                    taskWindow.deleteObject();
                    TaskBoard tb = new TaskBoard(mainListener.pastList,input);
                    taskWindow.getInstance(tb);
                    
                }
                        
             
             
        }
        else if(e.getActionCommand().equals("backButOnSub")){ 
            subtaskWindow.getInstance().dispose();
            subtaskWindow.getInstance().deleteObject(); 
            taskWindow.getInstance();
               }   
        else if(e.getActionCommand().equals("addButOnSub")){ 
            addSubPopUp.getInstance();
            subtaskWindow.getInstance().dispose();
            subtaskWindow.getInstance().deleteObject(); 
            
        }
        else if(e.getActionCommand().equals("addSub")){
            String enteredVal = addSubPopUp.getInstance().getEntSubtaskName().getText();
            user.getList().get(mainListener.pastList).getTask().get(currentTask).createSubTask(false, enteredVal);
            addSubPopUp.getInstance().dispose();
            addSubPopUp.deleteObject();
            subtaskWindow.getInstance();
            
            
        }
        
      
       else   
       for(int i = 0; i < listener.getTaskDetails(mainListener.pastList).length;i++){
           if(e.getActionCommand().equals("subTask"+i)){
               currentTask = i;
               try{
                taskWindow.getInstance().dispose();
                  taskWindow.deleteObject();
                  subtaskWindow.getInstance();
               }
               catch(IndexOutOfBoundsException err){
                 user.getList().get(mainListener.pastList).getTask().get(i).createDefaultSubTask();
                 taskWindow.getInstance().dispose();
                 taskWindow.deleteObject();
                 subtaskWindow.getInstance();
               }
                 
           }
           else if(e.getActionCommand().equals("deleteTask"+i)){
               Task taskId = user.getList().get(mainListener.pastList).getTask().get(i);
               System.out.println(taskId);
               if(user.getList().get(mainListener.pastList).getTask().contains(taskId)){
                   user.getList().get(mainListener.pastList).getTask().remove(taskId);
                   taskWindow.getInstance().dispose();
                   taskWindow.deleteObject();
                   taskWindow.getInstance(); 
               }
             }
           else if(e.getActionCommand().equals("editTask"+i)){ 
               currentTask = i; 
            Task taskId = user.getList().get(mainListener.pastList).getTask().get(i);
            String taskName = user.getList().get(mainListener.pastList).getTask().get(i).getName();
            if(user.getList().get(mainListener.pastList).getTask().contains(taskId)){
                taskWindow.getInstance().dispose();
                taskWindow.deleteObject();
                editTaskPopUp.getInstance(taskName);
                
                
            }
             else if(e.getActionCommand().equals("isComplete"+i) ){
            boolean checkBox = user.getList().get(mainListener.pastList).getTask().get(i).isCheckbox();
            //System.out.println("you have clicked a checkbox 2");
              if(checkBox){
                    user.getList().get(mainListener.pastList).getTask().get(i).setCheckbox(false);
                    taskWindow.getInstance().getTb().getCheckBox().setSelected(false);
                    System.out.println(user.getList().get(mainListener.pastList).getTask().get(i).isCheckbox()+"f");
                          }
              else if(!checkBox) {
              user.getList().get(mainListener.pastList).getTask().get(i).setCheckbox(true);
              taskWindow.getInstance().getTb().getCheckBox().setSelected(true);
              System.out.println(user.getList().get(mainListener.pastList).getTask().get(i).isCheckbox()+"t");
       }
           }
           
       }
       }
       for(int i = 0; i < getSubTaskDetails().length;i++){
  
            if(e.getActionCommand().equals("editSubTask"+i)){
                currentSubTask =i;
                SubTask SubTask = user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().get(currentSubTask);
                String SubtaskName = SubTask.getSubTaskTitle();
                if(user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().contains(SubTask)){
                    subtaskWindow.getInstance().dispose();
                    subtaskWindow.deleteObject();
                    editSubTaskPopUp.getInstance(SubtaskName,currentSubTask);  

                }
            }
            
    }
        if(e.getActionCommand().equals("subedit")){
                editSubTaskPopUp.getInstance().dispose();
            String newTaskName = editSubTaskPopUp.getInstance().getEntSubTaskName().getText();
            user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().get(currentSubTask).setSubTaskTitle(newTaskName);
            
            
            
            editSubTaskPopUp.deleteObject();
            subtaskWindow.getInstance(); 
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
     
     public String[] getSubTaskDetails(){
         System.out.println("List = "+mainListener.pastList);
         System.out.println("Task = "+currentTask);
        String[] SubtaskDetails = user.getList().get(mainListener.pastList).getTask().get(currentTask).showSubTasks();
        return SubtaskDetails;
     }
 }
