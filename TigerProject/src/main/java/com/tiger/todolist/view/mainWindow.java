/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.mainListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author k1732912
 */
// Contains lists and sign in.
public class mainWindow extends JFrame{
    
    private JTextField search = new JTextField("Search");
    private JButton signInButton = new JButton("Sign in");
    private JButton addList = new JButton("Add List");
    private JButton editList = new JButton("Edit List");
    private JButton removeList = new JButton("Remove List");
    private JLabel list= new JLabel ("Lists");
    
    private mainListener listener = new mainListener(); 
    
    public mainWindow(){
        super("To Do List");
        this.setLayout(new FlowLayout());
        this.add(search, new FlowLayout(FlowLayout.LEFT)); 
        this.add(addList,new FlowLayout(FlowLayout.RIGHT));
        this.add(editList,new FlowLayout(FlowLayout.RIGHT));
        this.add(removeList,new FlowLayout(FlowLayout.RIGHT));
        this.add(signInButton,new FlowLayout(FlowLayout.RIGHT));
        
        this.setLayout(new GridLayout(10,1));
        this.add(list);
        
        
        String[] listsNames = mainListener.getListNames();
        for(int i = 0; i < listsNames.length; i++){
            JButton name = new JButton();
            name.setBorderPainted(false); //removes border from JButton
            name.setText(listsNames[i]);
            name.addActionListener(listener);
            name.setActionCommand("thisList");
            this.add(name);
        } 
        
        
        addList.addActionListener(listener);
        addList.setActionCommand("addListBut");
        signInButton.addActionListener(listener);
        signInButton.setActionCommand("signInButton"); 
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true); 
    }
}
