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
import com.tiger.todolist.controller.mainListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SignIn extends JFrame {
    
    private JTextField userName = new JTextField("User Name");
    private JTextField password = new JTextField("Password");
    private JButton SignInButton = new JButton("Submit");

    mainListener listener = new mainListener(); 
    
    public SignIn(){
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(3,1));
        form.add(userName);
        form.add(password);
        form.add(SignInButton);
        
        SignInButton.addActionListener(listener);
        SignInButton.setActionCommand("confirm");
        
        Dimension newDim= new Dimension(300,150);
        
        this.setPreferredSize(newDim);
        this.setMaximumSize(newDim);
        this.setSize(newDim);
        this.revalidate();
        this.setResizable(false);
        this.add(form);
        this.setVisible(true);
    }
    
    public JTextField getUserName() {
        return userName;
    }

    public void setUserName(JTextField userName) {
        this.userName = userName;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }

    public JButton getSignIn() {
        return SignInButton;
    }

    public void setSignIn(JButton SignIn) {
        this.SignInButton = SignIn;
    }
    




    
}
