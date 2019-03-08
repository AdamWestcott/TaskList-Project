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

    public TaskBoard(){
        this.setLayout( new GridLayout (7,1));
        
        String[] tasks = listener.getTaskDetails();             // Getting tasks details
        String[] seperateTasks = new String[tasks.length];      // Setting array outside loop[
        for(int i = 0; i < tasks.length; i++){
           seperateTasks = tasks[i].split(",");
           for(int x = 0; x < seperateTasks.length; x++){
                taskTitle.setText(seperateTasks[0]);
                taskDescription.setText(seperateTasks[1]);
                dueDate.setText(seperateTasks[2]);
                checkBox.setText(seperateTasks[3]);
                priority.setText(seperateTasks[4]);
                if(currentList.getText().equals("")){
                    currentList.setText(seperateTasks[0]);
                    this.add(currentList);
            }
           this.add(taskTitle);
           this.add(taskDescription);
           this.add(dueDate);
           this.add(checkBox);
           this.add(priority);
        }
        }
        //currentList.setText(seperateTasks[0]);
//        this.add(currentList);
//        this.add(tasks);
//        this.add(taskTitle);
//        this.add(taskDescription);
//        this.add(priority);
//        this.add(dueDate);
//        this.add(checkBox);
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
