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
    private JButton saveData = new JButton("Save");
    private JButton loadData = new JButton("Load file");
    private JButton signInButton = new JButton("Sign out");
    private JButton addList = new JButton("Add List");
    private JButton editList = new JButton("Edit List");
    private JButton removeList = new JButton("Remove List");
    private JLabel list= new JLabel ("Lists");
    
    private mainListener listener = new mainListener(); 
    private static mainWindow instance = null;
    
    public static mainWindow getInstance(){
        if(mainWindow.instance == null) mainWindow.instance = new mainWindow();
                return mainWindow.instance;
    }
    
    public static void deleteObject(){
        mainWindow.instance = null; 
    }
    
    public mainWindow(){
        super("To Do List");
        this.setLayout(new FlowLayout());
        this.add(search, new FlowLayout(FlowLayout.LEFT));
        this.add(saveData, new FlowLayout(FlowLayout.RIGHT));
        this.add(loadData, new FlowLayout(FlowLayout.RIGHT));
        this.add(addList,new FlowLayout(FlowLayout.RIGHT));
        this.add(editList,new FlowLayout(FlowLayout.RIGHT));
        this.add(removeList,new FlowLayout(FlowLayout.RIGHT));
        this.add(signInButton,new FlowLayout(FlowLayout.RIGHT));
        
        this.setLayout(new GridLayout(12,1));
        this.add(list);
        
        
        String[] listsNames = listener.getListNames();
        for(int i = 0; i < listsNames.length; i++){
            JButton name = new JButton();
            name.setBorderPainted(false); //removes border from JButton
            name.setText(listsNames[i]);
            name.addActionListener(listener);
            name.setActionCommand("thisList"+i);
            this.add(name);
        } 
        
        saveData.addActionListener(listener);
        saveData.setActionCommand("saveBut");
        loadData.addActionListener(listener);
        loadData.setActionCommand("loadBut");
        addList.addActionListener(listener);
        addList.setActionCommand("addListBut");
        signInButton.addActionListener(listener);
        signInButton.setActionCommand("signOutButton"); 
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true); 
    }
}
