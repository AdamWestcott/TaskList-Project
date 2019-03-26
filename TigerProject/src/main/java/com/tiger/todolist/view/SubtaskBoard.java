/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.popupWindows;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author k1732912
 */
public class SubtaskBoard extends JPanel{

    private JLabel subTasks = new JLabel("Subtasks");
    private JLabel taskName = new JLabel("");
    private JLabel subTaskName = new JLabel();
    private JCheckBox checkBox = new JCheckBox("Complete");
    private popupWindows listener = new popupWindows();
    
    private static SubtaskBoard instance = null;
    
    public static SubtaskBoard getInstance(){
        if(SubtaskBoard.instance == null) SubtaskBoard.instance = new SubtaskBoard();
                return SubtaskBoard.instance;
    }
    
    public SubtaskBoard(){
        this.setLayout(new GridLayout(8,4));
        this.add(subTasks);
        String[] subTaskDetails = listener.getSubTaskDetails(listener.currentTask);
 
        for (int i=0; i<subTaskDetails.length;i++){
        String splitElements = subTaskDetails[i];
        String[] splitDetails = splitElements.split(",");
        
        if(this.taskName.getText().equals("")){
            taskName.setText(splitDetails[0]);    
            this.add(taskName);    
        }
        subTaskName.setText(splitDetails[1]);
        this.add(subTaskName);
        JCheckBox two = new JCheckBox();
        two.setText("Complete");
        two.setSelected(Boolean.valueOf(checkBox.getText()));
        this.add(two);
 
        
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
