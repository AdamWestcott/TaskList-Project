/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.controller.popupWindows;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author k1732912
 */
// Contains lists and sign in.
public class mainWindow extends JFrame{
    
    private JButton saveData = new JButton("Save File");
    private JButton loadData = new JButton("Load File");
    private JButton signInButton = new JButton("Sign Out");
    private JButton addList = new JButton("Add List");
    private JButton removeList = new JButton("Remove List");
    private JLabel list= new JLabel ("Your Lists");
    private  int lengthofWindow =7;
    
    private mainListener listener = new mainListener(); 
    private popupWindows listenerpop = new popupWindows();
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
        JPanel main= new JPanel();
        main.setLayout(new FlowLayout());
        main.add(saveData, new FlowLayout(FlowLayout.RIGHT));
        main.add(loadData, new FlowLayout(FlowLayout.RIGHT));
        main.add(addList,new FlowLayout(FlowLayout.RIGHT));
        main.add(removeList,new FlowLayout(FlowLayout.RIGHT));
        main.add(signInButton,new FlowLayout(FlowLayout.RIGHT));
        main.add(list);
        
        String[] listsNames = listener.getListNames();
        for(int i = 0; i < listsNames.length; i++){
            JButton name = new JButton();
            name.setBorderPainted(false); //removes border from JButton
            name.setText(listsNames[i]);
            name.addActionListener(listener);
            name.setActionCommand("thisList"+i);
            this.lengthofWindow++;
             main.setLayout(new GridLayout(lengthofWindow,1));
            main.add(name);
        } 
        
        saveData.addActionListener(listener);
        saveData.setActionCommand("saveBut");
        loadData.addActionListener(listener);
        loadData.setActionCommand("loadBut");
        addList.addActionListener(listenerpop);
        addList.setActionCommand("addListBut");
        signInButton.addActionListener(listener);
        signInButton.setActionCommand("signOutButton");
        removeList.addActionListener(listenerpop);
        removeList.setActionCommand("removeListButton");
        JScrollPane scrPane = new JScrollPane(main);
        this.add(scrPane);
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true); 
    }
}
