/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
    import javax.swing.JButton;
    import javax.swing.JCheckBox;
    import javax.swing.JComboBox;
    import javax.swing.JPanel;
    import javax.swing.JRadioButton;
    import javax.swing.JScrollPane;
    import javax.swing.JTextField;
    import javax.swing.JTextArea;
    import javax.swing.WindowConstants;

/**
 *
 * @author Lewys
 */
public class BoardView {
    public static void main(String[] args){
        
//        JFrame testWindow = new JFrame("Test: To Do List!");     // Create top level window
//        testWindow.setLayout(new FlowLayout());                  // Set the layout of the window
//
//        JLabel task = new JLabel("Enter task:");                 // Create components // Label
//        JTextField taskBox = new JTextField("Enter task");       // Text Field
//        JCheckBox completeBox = new JCheckBox("Complete");       // Checkbox
//        JRadioButton radioButtonExample = new JRadioButton("Radio Button ex");  // Radio Button
//        
//        String dropDownList[] = {"A","Drop","Down","List","Example"};
//        JComboBox comboBox = new JComboBox(dropDownList);        // Combo list - takes an array
//        
//        JButton button = new JButton("Maybe we could use this to add a task?"); // Button
//        
//        testWindow.add(task);
//        testWindow.add(taskBox);
//        testWindow.add(completeBox);
//        testWindow.add(radioButtonExample);
//        testWindow.add(comboBox);
//        testWindow.add(button);
//        
//        testWindow.pack();
//        
//        testWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Closing operation 
//        testWindow.setVisible(true);                                    //Making window visible

        JFrame mainWindow = new JFrame("To Do Application");
        //mainWindow.setLayout(new GridLayout(2,1));
       
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        
        JPanel listTitles = new JPanel();
        listTitles.setLayout(new FlowLayout());
        listTitles.add(new JLabel("Lists"));
        listTitles.add(new JButton("Button1"));
        listTitles.add(new JButton("Button2"));
        listTitles.setPreferredSize(new Dimension(100,100));
        
           
        mainPanel.add(listTitles);
        
        mainWindow.setContentPane(mainPanel);
        
        
        
        
        
        
        
        
       // mainWindow.add(new JLabel("List"));        
        //mainWindow.add(new JButton("Lists"));
        
        
        
        mainWindow.setSize(400,400);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }
}
