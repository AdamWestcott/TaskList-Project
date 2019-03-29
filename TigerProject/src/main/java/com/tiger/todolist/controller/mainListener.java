/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.controller;

import com.google.gson.Gson;
import com.tiger.todolist.model.Board;
import com.tiger.todolist.model.Category;
import com.tiger.todolist.model.Task;
import com.tiger.todolist.model.Translator;
import com.tiger.todolist.model.User;
import com.tiger.todolist.view.SignIn;
import com.tiger.todolist.view.TaskBoard;
import com.tiger.todolist.view.addListPopUp;
import com.tiger.todolist.view.addSubPopUp;
import com.tiger.todolist.view.deleteListPopUp;
import com.tiger.todolist.view.mainWindow;
import com.tiger.todolist.view.taskWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.apache.http.protocol.HTTP.USER_AGENT;



/**
 *
 * @author Lewys
 */
public class mainListener implements ActionListener {
// This class will listen for events in the mainWindow
// Each component has it's own action command, "If 'command' == something, do this...."
    
    public static int pastList = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
         //SIGN IN FUNCTIONALITY
        if(e.getActionCommand().equals("confirm")){
            
            if(Board.getStatus().findUser(getUserName(),getPassword()) != -1){
                mainWindow.getInstance();
                SignIn.getInstance().setVisible(false);
            }
            else JOptionPane.showMessageDialog(null, "Incorrect login details");
        }
        //JSON FUNCTIONALITY
        else if(e.getActionCommand().equals("pullWebService")){
            Gson gson = new Gson();
             try{
                  String url = "http://www.nooblab.com/p2.json";

	HttpClient client = HttpClientBuilder.create().build();
	HttpGet request = new HttpGet(url);

	
	request.addHeader("User-Agent", USER_AGENT);    // add request header
	HttpResponse response = client.execute(request);

	BufferedReader rd = new BufferedReader(
		new InputStreamReader(response.getEntity().getContent()));
       
        Translator[] results = gson.fromJson(rd,Translator[].class);
       
        for (Translator result : results){
            //ADDING A NEW USER
            int userListPos ; //Position of the new user added to the list.
            
                //PASSING NEW USER
                String newUserName = result.getUser().getName();
                String newUserPass = result.getUser().getPassword();
                int newLevel = result.getUser().getUserLevel();
                Board.getStatus().createUser(newUserName, newUserPass, newLevel);   //Creating a new user from passed data
                userListPos =  Board.getStatus().getUsers().size()-1;       
                User Uobj = Board.getStatus().getUsers().get(userListPos);
                Uobj.createList(Uobj.getUsername()+"'s List");                        //Creating a defualt list for user
                
                int taskNumber = 0;
                for(Translator task : results){
                //PASSING NEW TASK FOR EACH USER
                if(task.getUser().getName().equals(Uobj.getUsername()) ){
                    int tasksAdded = 0;
                    String newTaskName = task.getDescription();
                    Date newDueDate = task.getCompletionDate();
                    int newPriority = task.getPriorityOrder();

                    Uobj.getList().get(0).createTask(false,newTaskName,newDueDate,newPriority,"Task");  //PASSING THE JSON TASK TO OUR DATA MODEL
                    
                    for(int x = 0; x< result.getSubtasks().size();x++){
 
                        String subDesc = result.getSubtasks().get(x).getDescription();
                        Date subDueDate = result.getSubtasks().get(x).getCompletionDate();
                        int subPri = result.getSubtasks().get(x).getPriorityOrder();
                        Uobj.getList().get(0).getTask().get(taskNumber).createSubTask(subDesc, subDueDate, subPri);
                         
                    }
                    taskNumber++;
                    
                    }
                
                }
             }
        JOptionPane.showMessageDialog(null, "Sucessfully Pulled Data from Web Service. \n You can now log in using an web service user! ");
         }
             catch(IOException err){
                 
             }
        }
        //LOAD FILE FUNCTIONALITY
        else if(e.getActionCommand().equals("loadBut")){
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Load previous game");
            int selection = fc.showOpenDialog(null);
           
            if (selection == JFileChooser.APPROVE_OPTION) // if OK is selected
            {
                try {
                    File fileToSave = fc.getSelectedFile();
                    String inboundJson = FileUtils.readFileToString(fileToSave,"UTF-8");
                    Board.getStatus().updateFromJson(inboundJson);
                    mainWindow.getInstance(); 
                } catch (IOException err) {
                    JOptionPane.showMessageDialog(null,"Unable to load");
                }
            }
        }
        //SAVE FILE FUNCTIONALITY
        else if(e.getActionCommand().equals("saveBut")){
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Save current task board");
            int selection = fc.showSaveDialog(null);
            
            if (selection == JFileChooser.APPROVE_OPTION)// if OK is selected
            {
                File fileToSave = fc.getSelectedFile();
                try {
                    FileUtils.writeStringToFile(fileToSave,Board.getStatus().getJson(),"UTF-8");
                } catch (IOException err) {
                    JOptionPane.showMessageDialog(null,"Unable to save");
                }
            }
        }
        //CLOSE BUTTON ON SIGN IN PAGE
        else if(e.getActionCommand().equals("closeApp")){
            System.exit(0); 
        }
        //SIGN OUT FUNCTIONALITY ON TASKWINDOW
        else if(e.getActionCommand().equals("signOutButton")){
            SignIn.getInstance().setVisible(true);
            mainWindow.getInstance().dispose();
            mainWindow.deleteObject(); 
            
        }
         else if(e.getActionCommand().equals("addList")){
           int userIndex = Board.getStatus().findUser(getUserName(),getPassword());
           String enteredVal = addListPopUp.getInstance().getEntListName().getText();
           Board.getStatus().getUsers().get(userIndex).createList(enteredVal);
            addListPopUp.getInstance().dispose();
            addListPopUp.deleteObject(); 
            mainWindow.getInstance();
            
        }
         
         else if(e.getActionCommand().equals("deleteList")){
            int userIndex = Board.getStatus().findUser(getUserName(),getPassword());
            String enteredVal = deleteListPopUp.getInstance().getEntListName().getText();
            
            User currentUser = Board.getStatus().getUsers().get(userIndex);
           
             boolean flag = false;
              for(int i = 0; i < currentUser.getList().size();i++){
               Category categoryId = currentUser.getList().get(i);
               if(enteredVal.equals(categoryId.getTitle())){
                   currentUser.getList().remove(i);
                   deleteListPopUp.getInstance().dispose();
                    deleteListPopUp.deleteObject(); 
                    mainWindow.getInstance();
                    flag = true;
                    
               }  
              
           } 
              if(flag == false){
              JOptionPane.showMessageDialog(null, "Incorrect details, list does not exist!");
              }
         }
            
        
         //DISPLAYING USER TASKS
       else  for(int i = 0; i < getListNames().length; i++){
                if(e.getActionCommand().equals("thisList"+i)){
                    //JOptionPane.showMessageDialog(null, i+": This list clicked");
                    mainWindow.getInstance().dispose();
                    mainWindow.deleteObject(); 
                    pastList = i;
                    taskWindow.getInstance(); 
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
