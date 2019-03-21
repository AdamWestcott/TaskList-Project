/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.mainListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
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
    
    
    
    private mainListener listener = new mainListener(); 
    
    public TaskBoard(){
        
    }
    public TaskBoard(int i){
        int listIndex = i; 
                    
        String[] taskDetails =  listener.getTaskDetails(listIndex);
        JPanel BottomPanel = new JPanel();
       BottomPanel.setLayout( new GridLayout(10,1));;
        
        for(int x = 0; x < taskDetails.length; x++){
                    String splitElements = taskDetails[x];
                    String[] specificDetails = splitElements.split(",");
                        
                    if(this.currentList.getText().equals("")){
                        this.currentList.setText(specificDetails[0]);
                        
                    }
                      taskTitle.setText(specificDetails[1]);      
                      taskDescription.setText(specificDetails[2]);
                      priority.setText(specificDetails[3]);
                      dueDate.setText(specificDetails[4]);
                      JCheckBox checkBox = new JCheckBox("Complete");
                      JLabel one = new JLabel();
                      one.setText(taskTitle.getText());
                      JTextArea two = new JTextArea();
                      two.setText(taskDescription.getText());
                      JLabel three = new JLabel();
                      three.setText(priority.getText());
                      JLabel four = new JLabel();
                      four.setText(dueDate.getText());
                      
                      
                        BottomPanel.add(one);
                        BottomPanel.add(two);
                        BottomPanel.add(three);
                        BottomPanel.add(four); 
                        BottomPanel.add(checkBox); 

        }
        JPanel TopPanel = new JPanel();
        TopPanel.setLayout( new GridLayout(2,1));
                      
                        TopPanel.add(tasks);
                        TopPanel.add(currentList);
                        this.add(TopPanel, BorderLayout.CENTER);
                        this.add(BottomPanel, BorderLayout.PAGE_END);
 
        
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

    
            

    
}
