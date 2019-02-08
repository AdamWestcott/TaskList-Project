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
public class list {
    private String title;
    private ArrayList<task> task;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<task> getTask() {
        return task;
    }

    public void setTask(ArrayList<task> task) {
        this.task = task;
    }
    
    
}
