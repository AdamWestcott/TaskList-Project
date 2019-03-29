/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.popupWindows;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author k1732912
 */
public class SubtaskBoard extends JPanel{

    private JLabel subTasks = new JLabel("Subtasks");   //Top title
    private JLabel taskName = new JLabel("");   // Name of the task it belongs
    private JLabel subTaskName = new JLabel();  // The description of the task
    private JCheckBox checkBox = new JCheckBox("Complete"); 
    private JButton[] butForSubEdit;
    private JButton[] butForSubTasks;
    private popupWindows listener = new popupWindows();
   
    
    public SubtaskBoard(){
        JPanel middlePanel = new JPanel();
        this.setLayout(new FlowLayout());
        middlePanel.setLayout( new GridLayout(100,2));
        this.add(subTasks);
        String[] subTaskDetails = listener.getSubTaskDetails();     // an array of strings. ex array[0] = "taskName", "desc", "false"
        butForSubEdit = new JButton[subTaskDetails.length];
        butForSubTasks= new JButton[subTaskDetails.length];
        for (int i=0; i<subTaskDetails.length;i++){ 
        String splitElements = subTaskDetails[i];
        
        String[] splitDetails = splitElements.split(",");
        if(this.taskName.getText().equals("")){
            taskName.setText(splitDetails[0]);    
            this.add(taskName);    
        }
        subTaskName.setText(splitDetails[1]);
        JLabel one = new JLabel();
        one.setText(subTaskName.getText());
        middlePanel.add(one);
        
//        JCheckBox two = new JCheckBox();
//        two.setText("Complete");
//        two.setSelected(Boolean.valueOf(checkBox.getText()));
           butForSubEdit[i] = new JButton("Edit");
           butForSubEdit[i].addActionListener(listener);
           butForSubEdit[i].setActionCommand("editSubTask"+i);
           
           butForSubTasks[i] = new JButton("Delete");
           butForSubTasks[i].addActionListener(listener);
           butForSubTasks[i].setActionCommand("deleteSubTask"+i);
//           middlePanel.add(two);
           middlePanel.add(butForSubEdit[i]);
           middlePanel.add(butForSubTasks[i]);
           this.add(middlePanel);
 
        
        }
        
    }
    
     public JLabel getSubTaskName() {
        return subTaskName;
    }

    public void setSubTaskName(JLabel subTaskName) {
        this.subTaskName = subTaskName;
    }
    
     public JLabel getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(JLabel subTasks) {
        this.subTasks = subTasks;
    }

    public JLabel getTaskName() {
        return taskName;
    }

    public void setTaskName(JLabel taskName) {
        this.taskName = taskName;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
