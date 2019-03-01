/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.view;

/**
 *
 * @author k1746252
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListBoard extends JPanel {

    public ListBoard()
    {
        this.setLayout(new GridLayout(2,1));
        JScrollPane scroll = new JScrollPane(lists);
        this.add(list);
        this.add(scroll,BorderLayout.CENTER);
        
        lists.setLineWrap(true);
        lists.setEditable(false);
    }
    
    private JLabel list= new JLabel ("Lists");  
    private JTextArea lists = new JTextArea();
    
    public JLabel getList() {
        return list;
    }

    public void setList(JLabel list) {
        this.list = list;
    }

    public JTextArea getLists() {
        return lists;
    }

    public void setLists(JTextArea lists) {
        this.lists = lists;
    }

    

}
