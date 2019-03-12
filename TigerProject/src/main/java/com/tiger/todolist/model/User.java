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
public class User {
//PROPERTIES
    private String username;
    private String password;
    private int userLevel;
    private static int id = 0;  
    private ArrayList<Category> list = new ArrayList<Category>();

    
 //CONSTRUCTORS
    public User(){
        this.username = "default";
        this.password = "defaultPass";
        this.userLevel = 0;
        this.id = id;
        id ++; 
    }
    public User(String username, String password, int userLevel) {
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;  //0 = gneneral User // 1 = Admin User
        this.id = id;
        id ++;
    }
//GETTERS AND SETTERS
    
    
    public int getUserLevel() {
        return userLevel;
    }
 
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public ArrayList<Category> getList() {
        return list;
    }
    
    public static int getId() {
        return id;
    }
   //FUNCTIONS 
    public void addList(Category listName){      // Adding a instance of list.
        this.list.add(listName);  
            System.out.println(list.size());
        
    }
   
    public void removeList(Category list){
        this.list.remove(list); 
    }
    
    public String[] showLists(){
        
    String storeName = "";
    for(int i = 0; i < list.size(); i++){
        storeName += list.get(i).getTitle() + "," ; 
    }
    String[] listName = storeName.split(",");
    
    return listName; 
    }
    
}
