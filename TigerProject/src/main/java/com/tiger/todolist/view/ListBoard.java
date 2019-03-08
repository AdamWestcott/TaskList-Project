/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.tiger.todolist.view;
//
///**
// *
// * @author k1746252
// */
//import com.tiger.todolist.controller.mainListener;
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//
//public class ListBoard extends JPanel {
//
//    private JLabel list= new JLabel ("Lists");
//    private mainListener listener = new mainListener();
//    
//    public ListBoard()
//    {
//        this.setLayout(new GridLayout(10,1));
//        this.add(list);
//        
//        
//        String[] listsNames = mainListener.getListNames();
//        for(int i = 0; i < listsNames.length; i++){
//            JButton name = new JButton();
//            name.setBorderPainted(false); //removes border from JButton
//            name.setText(listsNames[i]); 
//            name.addActionListener(listener);
//            name.setActionCommand("thisList");
//            this.add(name);
//        } 
//        
//        
//    }
//    
//
//    
//    
//    
//
//}
