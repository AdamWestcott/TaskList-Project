/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.model;
import java.util.ArrayList; 
/**
 *
 * @author K1732912
 */
public class Board {
   //Create list on board
    
    //PROPERTIES
    private ArrayList<User> users = new ArrayList<User>();
    
    //FUNCTIONS
    public void addUser(User user){
        users.add(user);
        System.out.println(user.getUsername()+" added to board");
    }
    
    public void removeUser(User user){
        users.remove(user);
        System.out.println(user.getUsername()+" User removed");
    }
    
    
    public void showUsers(){
    users.forEach((user) -> System.out.println(user.getUsername()));
    }
    
    
    
    
}
