/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.model;
import com.google.gson.Gson;
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
    
    public int findUser (String un, String pn) {
        for(int i = 0 ; i < users.size(); i++){
           System.out.println(i);
            if (users.get(i).getUsername().equals(un)&& users.get(i).getPassword().equals(pn)){
                int userIndex = i;
                return userIndex;
            }
    
    }
    return -1;
    }
    
    public String getJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public void updateFromJson(String json){
        Gson gson = new Gson();
        Board.status = gson.fromJson(json, Board.class);
    }
}
