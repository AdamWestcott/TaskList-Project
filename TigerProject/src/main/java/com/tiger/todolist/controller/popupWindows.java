/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author k1732912
 */
public class popupWindows implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("addTask")){
          System.out.println("printing");
          JOptionPane.showMessageDialog(null, "Clicked Add Task");
      }  
    }
}
