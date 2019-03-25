/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.controller.popupWindows;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author k1732912
 */
public class taskWindow extends JFrame {
    
    private TaskBoard tb = new TaskBoard(mainListener.pastList); 
    
    private JTextField search = new JTextField(10);
    private JButton searchBut = new JButton("Search!"); 
    private JButton showSt = new JButton("Show Subtasks");
    private JButton addTask = new JButton("Add task");
    private JButton back = new JButton("Back");
    
    private popupWindows listener = new popupWindows();
    private static taskWindow instance = null;
    
    public static taskWindow getInstance(){
        if(taskWindow.instance == null) taskWindow.instance = new taskWindow();
                return taskWindow.instance;
    }
    
    public static taskWindow getInstance(TaskBoard tb){
        if(taskWindow.instance == null) taskWindow.instance = new taskWindow(tb);
                return taskWindow.instance;
    }
   
    public static void deleteObject(){
        taskWindow.instance = null; 
    }
    
    public taskWindow(){
        super("To Do List: Tasks");
        this.setLayout(new GridLayout(1,10));
        JPanel LeftPanel = new JPanel();
        LeftPanel.add(tb);
        LeftPanel.add(search);
        LeftPanel.add(searchBut);
        LeftPanel.add(showSt);
        LeftPanel.add(addTask);
        LeftPanel.add(back);
        
        back.addActionListener(listener); 
        back.setActionCommand("back");
        addTask.addActionListener(listener); 
        addTask.setActionCommand("addTask");
        searchBut.addActionListener(listener);
        searchBut.setActionCommand("search");
        this.add(LeftPanel, BorderLayout.LINE_END);
        
        this.setSize(500, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    public taskWindow(TaskBoard newTb){
        super("To Do List: Tasks");
        this.setLayout(new GridLayout(1,10));
        JPanel LeftPanel = new JPanel();
        LeftPanel.add(newTb);
        LeftPanel.add(search);
        LeftPanel.add(searchBut);
        LeftPanel.add(showSt);
        LeftPanel.add(addTask);
        LeftPanel.add(back);
        
        back.addActionListener(listener); 
        back.setActionCommand("back");
        addTask.addActionListener(listener); 
        addTask.setActionCommand("addTask");
        searchBut.addActionListener(listener);
        searchBut.setActionCommand("search");
        this.add(LeftPanel, BorderLayout.LINE_END);
        
        this.setSize(500, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public TaskBoard getTb() {
        return tb;
    }

    public void setTb(TaskBoard tb) {
        this.tb = tb;
    }
    
     public JTextField getSearch() {
        return search;
    }

    public void setSearch(JTextField search) {
        this.search = search;
    }

    
}
