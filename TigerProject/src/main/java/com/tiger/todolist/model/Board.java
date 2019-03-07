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
    private static Board status = null; 
    
    //SINGLETON
    private Board(){}; 
    

    //FUNCTIONS
    public static Board getStatus(){
        if(Board.status == null) Board.status = new Board();
                return Board.status; 
    }
    
    public void createUser(String user, String pass, int userLvl){
        addUser(new User(user,pass,userLvl));
    }
    
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
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    
    
}
