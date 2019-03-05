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
public class Category {
    //PROPERTIES
    private String title;
    private static ArrayList<Task> task = new ArrayList<Task>();
    private static ArrayList<Task> backupList = new ArrayList<Task>();
    
    //CONSTRUCTORS
    public Category(){
        this.title = "List Name";
    }
    
    public Category(String title){
        this.title = title;
    }
    
    //FUNCTIONS
    public void editTaskTitle(String newTitle, Task currentTask){
        if(task.contains(currentTask)){ 
             
        }
    }
    public void addTask(Task taskObject){
        task.add(taskObject);
        System.out.println("Task added to List");
    }
    
    public void removeTask(Task taskObject){
        if(task.contains(taskObject)){
            backupList.add(taskObject);
            task.remove(taskObject); 
        }
        else System.out.println("Task does not exist in list");
    }
    
    public void restoreTask(Task taskObject){
        if(backupList.contains(taskObject)){
            task.add(taskObject);
            backupList.remove(taskObject);
            System.out.println("Task restored");
        }
        else System.out.println("Task does not exist in list");
    }

    //GETTERS AND SETTERS
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
