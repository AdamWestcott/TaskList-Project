/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author k1732912
 */
public class SubtaskBoard extends JPanel{
    private JLabel subTasks = new JLabel("Subtasks");
    private JLabel taskName = new JLabel("Task Name");
    private JRadioButton checkBox = new JRadioButton("Complete");;
    
    
    public SubtaskBoard(){
        this.setLayout(new GridLayout(2,1));
        //super.add(getTaskTitle());
        this.add(taskName);
        this.add(checkBox);
        
    }
}
