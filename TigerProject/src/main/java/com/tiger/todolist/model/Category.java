/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.model;
import java.util.ArrayList; 
import java.util.Date;


/**
 *
 * @author K1732912
 */
public class Category {
    //PROPERTIES
    private String title;
    private ArrayList<Task> task = new ArrayList<Task>();
    private  ArrayList<Task> backupList = new ArrayList<Task>();
    private static int id = 0;

  
    //CONSTRUCTORS
    public Category(){
        this.title = "List Name";
        this.id = id;
        id++;
    }
    
    public Category(String title){
        this.title = title;
        this.id = id;
        id++;
    }
    
    //FUNCTIONS
    public void editTaskTitle(String newTitle, Task currentTask){
        if(task.contains(currentTask)){ 
             
        }
    }
    
    public void createTask(boolean checkbox, String description, Date dueDate, int priority, String name){
        task.add(new Task(checkbox,description,dueDate,priority,name));
    }
    
     public void createDefaultTask(){
        task.add(new Task(false,"Default Task",new Date(),20,"DefualtTask"));
    }
    
    public String[] showTasks(){
        
    String storeName = "";
    for(int i = 0; i < task.size(); i++){
        storeName += task.get(i).getName() + "," ; 
    }
    String[] taskNames = storeName.split(",");
    
    return taskNames; 
    }
    
    public String[] getTaskDetails(){
        String storeTask = "";
        for(int i = 0; i < task.size(); i++){
            storeTask += this.getTitle() + ","; 
            storeTask += task.get(i).getName()+ ",";
            storeTask += task.get(i).getDescription()+ ",";
            storeTask += task.get(i).getDueDate()+ ",";
            storeTask += task.get(i).getPriority()+ ",";
            storeTask += task.get(i).isCheckbox()+ ",";
            storeTask += task.get(i).getId();
            storeTask += "#";
//            System.out.println(storeTask);
        }
        String[] taskNames = storeTask.split("#");
        
        return taskNames; 
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
    
    public String[] loadTasks(){                        //Puts tasks of this list into an array
        String[] taskNames = new String[task.size()];
        for(int i = 0; i < task.size(); i++){
            taskNames[i] = task.get(i).getName();
            System.out.println(taskNames[i]);
        }
        return taskNames; 
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
     
    public static int getId() {
        return id;
    }
    
    
}
