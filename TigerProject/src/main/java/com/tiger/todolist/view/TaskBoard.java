/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.mainListener;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author k1732912
 */
public class TaskBoard extends JPanel{
    
    private JLabel currentList = new JLabel("");
    private JLabel tasks = new JLabel ("Tasks");
    private JLabel taskTitle = new JLabel ("Task title");
    private JTextArea taskDescription = new JTextArea ("Task Descripton");
    private JLabel priority = new JLabel ("...Number...");
    private JLabel dueDate = new JLabel("A date");
    private JRadioButton checkBox = new JRadioButton("Complete");
    
    
    
    private mainListener listener = new mainListener(); 

    public TaskBoard(int i){
        int listIndex = i; 
        this.setLayout( new GridLayout (7,1));
                    
        String[] taskDetails =  listener.getTaskDetails(listIndex);
       this.add(tasks);
        
        for(int x = 0; x < taskDetails.length; x++){
                    String splitElements = taskDetails[x];
                    String[] specificDetails = splitElements.split(",");
                        
                    if(this.currentList.getText().equals("")){
                        this.currentList.setText(specificDetails[0]);
                        this.add(currentList);
                    }
                      taskTitle.setText(specificDetails[1]);      
                      taskDescription.setText(specificDetails[2]);
                      priority.setText(specificDetails[3]);
                      dueDate.setText(specificDetails[4]);
                       
                      JLabel one = new JLabel();
                      one.setText(taskTitle.getText());
                      JTextArea two = new JTextArea();
                      two.setText(taskDescription.getText());
                      JLabel three = new JLabel();
                      three.setText(priority.getText());
                      JLabel four = new JLabel();
                      four.setText(dueDate.getText());
                      
                        
                        this.add(one);
                        this.add(two);
                        this.add(three);
                        this.add(four); 
//                        this.add(checkBox); 

        }
        
        
        }
     
    public JLabel getCurrentList() {
        return currentList;
    }

    public void setCurrentList(JLabel currentList) {
        this.currentList = currentList;
    }

    public JLabel getTasks() {
        return tasks;
    }

    public void setTasks(JLabel tasks) {
        this.tasks = tasks;
    }

    public JLabel getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(JLabel taskTitle) {
        this.taskTitle = taskTitle;
    }

    public JTextArea getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(JTextArea taskDescription) {
        this.taskDescription = taskDescription;
    }

    public JLabel getPriority() {
        return priority;
    }

    public void setPriority(JLabel priority) {
        this.priority = priority;
    }

    public JLabel getDueDate() {
        return dueDate;
    }

    public void setDueDate(JLabel dueDate) {
        this.dueDate = dueDate;
    }

    public JRadioButton getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JRadioButton checkBox) {
        this.checkBox = checkBox;
    }
            

    
}
