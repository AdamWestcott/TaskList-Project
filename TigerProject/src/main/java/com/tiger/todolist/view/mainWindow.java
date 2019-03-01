/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author k1732912
 */
// Contains lists and sign in.
public class mainWindow extends JFrame{
    
    private JButton signInButton = new JButton("Sign in");
    private ListBoard lists = new ListBoard();
    
    public mainWindow(){
        super("To Do List");
        this.setLayout(new BorderLayout());
        signInButton.setMaximumSize(new Dimension (100,100));
        
        this.add(lists);
        this.add(signInButton, BorderLayout.EAST);
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true); 
        
        
    }
}
