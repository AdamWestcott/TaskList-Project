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
public class List {
    private String title;
    private ArrayList<Task> task = new ArrayList<Task>();
    
    public List(){
        this.title = "List Name";
    }
    
    public List(String title, ArrayList<Task> task){
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Task> getTask() {
        return task;
    }

    public void setTask(ArrayList<Task> task) {
        this.task = task;
    }
    
    
}
