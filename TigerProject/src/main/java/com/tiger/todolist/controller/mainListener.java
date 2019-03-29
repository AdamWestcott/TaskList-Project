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
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;



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
         //int currentUser = Board.getStatus().findUser(getUserName(),getPassword());
         
        if(e.getActionCommand().equals("confirm")){
            
            if(Board.getStatus().findUser(getUserName(),getPassword()) != -1){
                mainWindow.getInstance();
                SignIn.getInstance().setVisible(false); 
            }
            else JOptionPane.showMessageDialog(null, "Incorrect login details");
        }
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
        else if(e.getActionCommand().equals("signOutButton")){
            SignIn.getInstance().setVisible(true);
            mainWindow.getInstance().dispose();
            mainWindow.deleteObject(); 
            
        }
        else if(e.getActionCommand().equals("addListBut")){
            SignIn.getInstance().setVisible(true);
            mainWindow.getInstance().dispose();
            mainWindow.deleteObject(); 
            
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
