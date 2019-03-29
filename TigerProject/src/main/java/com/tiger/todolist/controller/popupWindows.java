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
import com.tiger.todolist.view.TaskBoard;
import com.tiger.todolist.view.addListPopUp;
import com.tiger.todolist.view.addSubPopUp;
import com.tiger.todolist.view.addTaskPopUp;
import com.tiger.todolist.view.deleteListPopUp;
import com.tiger.todolist.view.editSubTaskPopUp;
import com.tiger.todolist.view.editTaskPopUp;
import com.tiger.todolist.view.mainWindow;
import com.tiger.todolist.view.subtaskWindow;
import com.tiger.todolist.view.taskWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
          try{
            String passDueDate = addTaskPopUp.getInstance().getEntDueDate().getText();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date convertTo = df.parse(passDueDate);
            
           
            int passPriority = Integer.parseInt(addTaskPopUp.getInstance().getPriorities().getSelectedItem().toString());
            user.getList().get(mainListener.pastList).createTask(false, passTaskDesc, convertTo, passPriority, passTaskName);
            addTaskPopUp.getInstance().dispose();
          addTaskPopUp.deleteObject();
          taskWindow.getInstance(); 
          }
          catch(ParseException err){
               JOptionPane.showMessageDialog(null, "Incorrect date format. Do as: 10/01/2020");
          }
          
          
          
          
        }
        else if(e.getActionCommand().equals("edit") ){
          String newTaskName = editTaskPopUp.getInstance().getEntTaskName().getText();
          String newTaskDesc = editTaskPopUp.getInstance().getEntDescript().getText();
          try{
            String newDueDate = editTaskPopUp.getInstance().getEntDueDate().getText();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date convertTo = df.parse(newDueDate);
            
            int passPriority = Integer.parseInt(editTaskPopUp.getInstance().getPriorities().getSelectedItem().toString());
          
            user.getList().get(mainListener.pastList).getTask().get(currentTask).setName(newTaskName);
            user.getList().get(mainListener.pastList).getTask().get(currentTask).setDescription(newTaskDesc);
            user.getList().get(mainListener.pastList).getTask().get(currentTask).setDueDate(convertTo);
            user.getList().get(mainListener.pastList).getTask().get(currentTask).setPriority(passPriority);

            editTaskPopUp.getInstance().dispose();
            editTaskPopUp.deleteObject();
            taskWindow.getInstance();
          }
          catch(ParseException err){
               JOptionPane.showMessageDialog(null, "Incorrect date format. Do as: 10/01/2020");
          }
          
           
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
            
            if(isNumber && inputAsInt <= 20 &&  inputAsInt >0 ) {//Its a priority
                taskWindow.getInstance().dispose();
                taskWindow.deleteObject();
                TaskBoard tb = new TaskBoard(mainListener.pastList,inputAsInt);
                taskWindow.getInstance(tb);    
            }
            else if(input.length() < 15 && !input.equals("")){
                taskWindow.getInstance().dispose();
                taskWindow.deleteObject();
                TaskBoard tb = new TaskBoard(mainListener.pastList,input);
                taskWindow.getInstance(tb); 
            }
        }
         else if(e.getActionCommand().equals("displayAllTasks")){
            taskWindow.getInstance().dispose();
            taskWindow.deleteObject();
            taskWindow.getInstance();
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
            user.getList().get(mainListener.pastList).getTask().get(currentTask).createSubTask(enteredVal,new Date(),2);
            addSubPopUp.getInstance().dispose();
            addSubPopUp.deleteObject();
            subtaskWindow.getInstance();
            
            
        }
        else if(e.getActionCommand().equals("addListBut")){
            addListPopUp.getInstance();
            mainWindow.getInstance().dispose();
            mainWindow.deleteObject(); 
            
        }
        
        
        else if(e.getActionCommand().equals("removeListButton")){
            deleteListPopUp.getInstance();
            mainWindow.getInstance().dispose();
            mainWindow.deleteObject(); 
            
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
               
                   if(user.getList().get(mainListener.pastList).getTask().size() > 1){
                        user.getList().get(mainListener.pastList).getTask().remove(taskId);
                        taskWindow.getInstance().dispose();
                        taskWindow.deleteObject();
                        taskWindow.getInstance();  
                   }
                   else{
                        user.getList().get(mainListener.pastList).getTask().remove(taskId);
                        user.getList().get(mainListener.pastList).createDefaultTask(); 
                        taskWindow.getInstance().dispose();
                        taskWindow.deleteObject();
                        mainWindow.getInstance();  
                      
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
           }
             else if(e.getActionCommand().equals("isComplete"+i) ){
            boolean checkBox = user.getList().get(mainListener.pastList).getTask().get(i).isCheckbox();
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
       for(int i = 0; i < getSubTaskDetails().length;i++){
  
            if(e.getActionCommand().equals("editSubTask"+i)){
                currentSubTask =i;
                SubTask SubTask = user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().get(currentSubTask);
                String SubtaskName = SubTask.getDescription();
                if(user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().contains(SubTask)){
                    subtaskWindow.getInstance().dispose();
                    subtaskWindow.deleteObject();
                    editSubTaskPopUp.getInstance(SubtaskName,currentSubTask);  

                }
            }
            else if(e.getActionCommand().equals("deleteSubTask"+i)){
               SubTask SubtaskId = user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().get(i);
               System.out.println(SubtaskId );
               if(user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().contains(SubtaskId)){
                   if(user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().size() > 1){
                     user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().remove(SubtaskId);
                     subtaskWindow.getInstance().dispose();
                     subtaskWindow.deleteObject();
                     subtaskWindow.getInstance();  
                   }
                   else{
                     user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().remove(SubtaskId);
                     subtaskWindow.getInstance().dispose();
                     subtaskWindow.deleteObject();
                     taskWindow.getInstance();
                   }
                    
               }
       }
                    
            
    }
        if(e.getActionCommand().equals("subedit")){
                editSubTaskPopUp.getInstance().dispose();
            String newTaskName = editSubTaskPopUp.getInstance().getEntSubTaskName().getText();
            user.getList().get(mainListener.pastList).getTask().get(currentTask).getSubTasks().get(currentSubTask).setDescription(newTaskName);
            
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
        String[] SubtaskDetails = user.getList().get(mainListener.pastList).getTask().get(currentTask).showSubTasks();
        return SubtaskDetails;
     }
 }
