/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import com.tiger.todolist.controller.popupWindows;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author k1732912
 */
public class subtaskWindow extends JFrame {
    
    
    private JButton backBut = new JButton("Back");
    private JButton addBut = new JButton("Add");
    
    
    private popupWindows listener = new popupWindows();
    private SubtaskBoard sTboard = new SubtaskBoard(); 
    
    private static subtaskWindow instance = null;
    
    public static subtaskWindow getInstance(){
        if(subtaskWindow.instance == null)   subtaskWindow.instance= new subtaskWindow();
        return subtaskWindow.instance;
    }
    
    public static void deleteObject(){
        subtaskWindow.instance = null; 
    }
    
    public subtaskWindow(){
        super("To Do List: Subtasks");
        setLayout(new FlowLayout());
        
        this.add(sTboard);
        addBut.addActionListener(listener);
        addBut.setActionCommand("addButOnSub");
        backBut.addActionListener(listener);
        backBut.setActionCommand("backButOnSub");
        this.add(addBut);
        this.add(backBut);
        
        
        this.setSize(500, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public SubtaskBoard getsTboard() {
        return sTboard;
    }

    public void setsTboard(SubtaskBoard sTboard) {
        this.sTboard = sTboard;
    }
    
}
