/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author k1732912
 */
public class taskWindow extends JFrame {
    
    private TaskBoard tb = new TaskBoard();
    private JButton showSt = new JButton("Show Subtasks"); 
    
    public taskWindow(){
        super("To Do List: Tasks");
        this.setLayout(new FlowLayout());
        
        this.add(tb);
        this.add(showSt);
        
        this.setSize(500, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
