/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author k1732912
 */
public class subtaskWindow extends JFrame {
    private SubtaskBoard sTboard = SubtaskBoard.getInstance();
    private static subtaskWindow instance = null;
    
    public static subtaskWindow getInstance(){
        if(subtaskWindow.instance == null)   subtaskWindow.instance= new subtaskWindow();
        return subtaskWindow.instance;
            
    }
    
    public subtaskWindow(){
        super("To Do List: Subtasks");
        setLayout(new FlowLayout());
        
        this.add(sTboard);
        
        this.setSize(500, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
