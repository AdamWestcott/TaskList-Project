/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.controller.popupWindows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author k1732912
 */
public class TaskBoard extends JPanel{
    
    private JLabel currentList = new JLabel("");
    private JLabel tasks = new JLabel ("Tasks");
    private JLabel taskTitle = new JLabel ("Task title");
    private JLabel taskDescription = new JLabel ("Task Descripton");
    private JLabel priority = new JLabel ("...Number...");
    private JLabel dueDate = new JLabel("A date");
    private JCheckBox checkBox = new JCheckBox("Complete",false);
    private JLabel storesTaskId = new JLabel();
    
    private JButton[] butForTasks;


    private popupWindows popupListener = new popupWindows();
    private mainListener listener = new mainListener(); 
    
    
    
    public TaskBoard(int i){
        int listIndex = i;
                    
        String[] taskDetails =  listener.getTaskDetails(listIndex);
        butForTasks = new JButton[taskDetails.length];
        JPanel BottomPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout( new GridLayout(1,4));
        int GridNumber =0;

              taskTitle.setText("Task");      
              taskDescription.setText("Description");
              priority.setText("Priority");
              dueDate.setText("Due Date");
              Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

              Font font = new Font("Courier", Font.BOLD,12);
              JLabel first = new JLabel();
              first.setText(taskTitle.getText());
              JLabel second = new JLabel();
              second.setText(taskDescription.getText());
              JLabel third= new JLabel();
              third.setText(priority.getText());
              JLabel fourth = new JLabel();
              fourth.setText(dueDate.getText());


              first.setFont(font);
              second.setFont(font);
              third.setFont(font);
              fourth.setFont(font);

              middlePanel.add(first);
              middlePanel.add(second);
              middlePanel.add(third);
              middlePanel.add(fourth);
                      
        for(int x = 0; x < taskDetails.length; x++){
                    String splitElements = taskDetails[x];
                    String[] specificDetails = splitElements.split(",");
                    GridNumber++;
                    BottomPanel.setLayout( new GridLayout(GridNumber,1)); 
                    if(this.currentList.getText().equals("")){
                        this.currentList.setText(specificDetails[0]);
                        
                    }
                     if(this.currentList.getText().equals("")){
                        this.currentList.setText(specificDetails[0]);
                        
                    }
                    
                      taskTitle.setText(specificDetails[1]);      
                      taskDescription.setText(specificDetails[2]);
                      dueDate.setText(specificDetails[3]);
                      priority.setText(specificDetails[4]);
                      checkBox.setText(specificDetails[5]);
                      storesTaskId.setText(""+x);
                      
                      JLabel one = new JLabel();
                      one.setText(taskTitle.getText());
                      JLabel two = new JLabel();
                      two.setText(taskDescription.getText());
                      JLabel three = new JLabel();
                      three.setText(priority.getText());
                      JLabel four = new JLabel();
                      four.setText(dueDate.getText());
                      JCheckBox five = new JCheckBox();
                      five.setText("Complete");
                      five.setSelected(Boolean.valueOf(checkBox.getText()));
                      five.addActionListener(popupListener);
                      five.setActionCommand("isComplete");
                       butForTasks[x] = new JButton("Delete");
                       butForTasks[x].addActionListener(popupListener);
                       butForTasks[x].setActionCommand("deleteTask"+x);
                        
                       one.setBorder(border);
                        BottomPanel.add(one);
                        BottomPanel.add(two);
                        BottomPanel.add(three);
                        BottomPanel.add(four); 
                        BottomPanel.add(five);
                        BottomPanel.add(butForTasks[x]);
        }
        
        JPanel TopPanel = new JPanel();
        TopPanel.setLayout( new GridLayout(2,1));
                      
                        TopPanel.add(tasks);
                        TopPanel.add(currentList);
                        this.add(TopPanel, BorderLayout.CENTER);
                        this.add(middlePanel, BorderLayout.PAGE_START);
                        this.add(BottomPanel, BorderLayout.PAGE_END);
 
        
        }
    
    public TaskBoard(int i, int priorityInput){
     int listIndex = i;
                    
        String[] taskDetails =  listener.getTaskDetails(listIndex);
        butForTasks = new JButton[taskDetails.length];
        JPanel BottomPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout( new GridLayout(1,4));
        int GridNumber =0;

              taskTitle.setText("Task");      
              taskDescription.setText("Description");
              priority.setText("Priority");
              dueDate.setText("Due Date");
              Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

              Font font = new Font("Courier", Font.BOLD,12);
              JLabel first = new JLabel();
              first.setText(taskTitle.getText());
              JLabel second = new JLabel();
              second.setText(taskDescription.getText());
              JLabel third= new JLabel();
              third.setText(priority.getText());
              JLabel fourth = new JLabel();
              fourth.setText(dueDate.getText());


              first.setFont(font);
              second.setFont(font);
              third.setFont(font);
              fourth.setFont(font);

              middlePanel.add(first);
              middlePanel.add(second);
              middlePanel.add(third);
              middlePanel.add(fourth);
                      
        for(int x = 0; x < taskDetails.length; x++){
                    String splitElements = taskDetails[x];
                    String[] specificDetails = splitElements.split(",");
                    int passedPriority = Integer.parseInt(specificDetails[4]); 
                    if(passedPriority == priorityInput){
                    GridNumber++;
                    BottomPanel.setLayout( new GridLayout(GridNumber,1)); 
                    if(this.currentList.getText().equals("")){
                        this.currentList.setText(specificDetails[0]);
                        
                    }
                     if(this.currentList.getText().equals("")){
                        this.currentList.setText(specificDetails[0]);
                        
                    }
                    
                      taskTitle.setText(specificDetails[1]);      
                      taskDescription.setText(specificDetails[2]);
                      dueDate.setText(specificDetails[3]);
                      priority.setText(specificDetails[4]);
                      checkBox.setText(specificDetails[5]);
                      storesTaskId.setText(""+x);
                      
                      JLabel one = new JLabel();
                      one.setText(taskTitle.getText());
                      JLabel two = new JLabel();
                      two.setText(taskDescription.getText());
                      JLabel three = new JLabel();
                      three.setText(priority.getText());
                      JLabel four = new JLabel();
                      four.setText(dueDate.getText());
                      JCheckBox five = new JCheckBox();
                      five.setText("Complete");
                      five.setSelected(Boolean.valueOf(checkBox.getText()));
                      five.addActionListener(popupListener);
                      five.setActionCommand("isComplete");
                       butForTasks[x] = new JButton("Delete");
                       butForTasks[x].addActionListener(popupListener);
                       butForTasks[x].setActionCommand("deleteTask"+x);
                        
                       one.setBorder(border);
                        BottomPanel.add(one);
                        BottomPanel.add(two);
                        BottomPanel.add(three);
                        BottomPanel.add(four); 
                        BottomPanel.add(five);
                        BottomPanel.add(butForTasks[x]);
                    }
        }
        
        JPanel TopPanel = new JPanel();
        TopPanel.setLayout( new GridLayout(2,1));
                      
                        TopPanel.add(tasks);
                        TopPanel.add(currentList);
                        this.add(TopPanel, BorderLayout.CENTER);
                        this.add(middlePanel, BorderLayout.PAGE_START);
                        this.add(BottomPanel, BorderLayout.PAGE_END);
 
        
    }
     public TaskBoard(int i, String input){
     int listIndex = i;
                    
        String[] taskDetails =  listener.getTaskDetails(listIndex);
        butForTasks = new JButton[taskDetails.length];
        JPanel BottomPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout( new GridLayout(1,4));
        int GridNumber =0;

              taskTitle.setText("Task");      
              taskDescription.setText("Description");
              priority.setText("Priority");
              dueDate.setText("Due Date");
              Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

              Font font = new Font("Courier", Font.BOLD,12);
              JLabel first = new JLabel();
              first.setText(taskTitle.getText());
              JLabel second = new JLabel();
              second.setText(taskDescription.getText());
              JLabel third= new JLabel();
              third.setText(priority.getText());
              JLabel fourth = new JLabel();
              fourth.setText(dueDate.getText());


              first.setFont(font);
              second.setFont(font);
              third.setFont(font);
              fourth.setFont(font);

              middlePanel.add(first);
              middlePanel.add(second);
              middlePanel.add(third);
              middlePanel.add(fourth);
                      
        for(int x = 0; x < taskDetails.length; x++){
                    String splitElements = taskDetails[x];
                    String[] specificDetails = splitElements.split(",");
                    String passedDate = specificDetails[3];  
                    if(passedDate.equals(input)){
                    GridNumber++;
                    BottomPanel.setLayout( new GridLayout(GridNumber,1)); 
                    if(this.currentList.getText().equals("")){
                        this.currentList.setText(specificDetails[0]);
                        
                    }
                     if(this.currentList.getText().equals("")){
                        this.currentList.setText(specificDetails[0]);
                        
                    }
                    
                      taskTitle.setText(specificDetails[1]);      
                      taskDescription.setText(specificDetails[2]);
                      dueDate.setText(specificDetails[3]);
                      priority.setText(specificDetails[4]);
                      checkBox.setText(specificDetails[5]);
                      storesTaskId.setText(""+x);
                      
                      JLabel one = new JLabel();
                      one.setText(taskTitle.getText());
                      JLabel two = new JLabel();
                      two.setText(taskDescription.getText());
                      JLabel three = new JLabel();
                      three.setText(priority.getText());
                      JLabel four = new JLabel();
                      four.setText(dueDate.getText());
                      JCheckBox five = new JCheckBox();
                      five.setText("Complete");
                      five.setSelected(Boolean.valueOf(checkBox.getText()));
                      five.addActionListener(popupListener);
                      five.setActionCommand("isComplete");
                       butForTasks[x] = new JButton("Delete");
                       butForTasks[x].addActionListener(popupListener);
                       butForTasks[x].setActionCommand("deleteTask"+x);
                        
                       one.setBorder(border);
                        BottomPanel.add(one);
                        BottomPanel.add(two);
                        BottomPanel.add(three);
                        BottomPanel.add(four); 
                        BottomPanel.add(five);
                        BottomPanel.add(butForTasks[x]);
                    }
        }
        
        JPanel TopPanel = new JPanel();
        TopPanel.setLayout( new GridLayout(2,1));
                      
                        TopPanel.add(tasks);
                        TopPanel.add(currentList);
                        this.add(TopPanel, BorderLayout.CENTER);
                        this.add(middlePanel, BorderLayout.PAGE_START);
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

    public JLabel getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(JLabel taskDescription) {
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
    
    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public JLabel getStoresTaskId() {
        return storesTaskId;
    }

    public void setStoresTaskId(JLabel storesTaskId) {
        this.storesTaskId = storesTaskId;
    }
    
    public JButton[] getButForTasks() {
        return butForTasks;
    }
    
            

    
}
