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
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignIn extends JFrame {
     
    private JTextField userName = new JTextField("");
    private JPasswordField password = new JPasswordField("");
    private JButton SignInButton = new JButton("Sign In");
    private JButton pullWebService = new JButton("Pull Data from Web Service");
    private JButton closeApp = new JButton("Close"); 
    
    mainListener listener = new mainListener();
    private static SignIn instance = null;
    
    public static SignIn getInstance(){
        if(SignIn.instance == null) SignIn.instance = new SignIn();
                return SignIn.instance; 
    }
    
    public static void destroyObject(){
        SignIn.instance = null; 
    }
    
    public SignIn(){
        this.setTitle("Sign In");
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(5,1));
        form.add(userName);
        form.add(password);
        form.add(SignInButton);
        form.add(pullWebService);
        form.add(closeApp);
        
        SignInButton.addActionListener(listener);
        SignInButton.setActionCommand("confirm");
        pullWebService.addActionListener(listener);
        pullWebService.setActionCommand("pullWebService");
        closeApp.addActionListener(listener);
        closeApp.setActionCommand("closeApp");
        
        
        Dimension newDim= new Dimension(500,150);
        
        this.setPreferredSize(newDim);
        this.setMaximumSize(newDim);
        this.setSize(newDim);
        this.revalidate();//Calling all is an instruction to tell the layout manager to reset based on the new component list 
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

    public  void setPassword(JPasswordField password) {
        this.password = password;
    }

    public JButton getSignIn() {
        return SignInButton;
    }

    public void setSignIn(JButton SignIn) {
        this.SignInButton = SignIn;
    }
    
    
}
