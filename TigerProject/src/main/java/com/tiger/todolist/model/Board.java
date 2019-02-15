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
    private ArrayList<List> list = new ArrayList<List>(); 
    
    public void createList(List listName){      //Creating a instance of list in board.
        this.list.add(listName);  
            System.out.println(list.size());
        
    }
    
   
    
    public void removeList(List list){
        this.list.remove(list); 
    }
    
    
    
    
}
