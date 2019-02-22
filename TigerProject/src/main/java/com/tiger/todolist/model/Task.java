/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.model;
import java.util.ArrayList; 
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author K1732912
 */
public class Task {
  private boolean checkbox;
  private String description;
  private Date dueDate = new Date();
  private int priority; 
  private String name;
  private ArrayList<SubTask> SubTasks  = new ArrayList<SubTask>();

  
  public Task (boolean checkbox, String description, Date dueDate, int priority, String name){
      this.checkbox = checkbox;
      this.description = description;
      this.dueDate = dueDate;
      this.priority = priority;
      this.name = name;
  }
  
  public Task(){
      this.checkbox = false;
      this.description = "default";
      this.dueDate = dueDate;
      this.priority = 0;
      this.name = "task";
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

      
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
    public void editSubtask(SubTask SubtaskObject)
    {
        Scanner input = new Scanner(System.in);
       if(SubTasks.contains(SubtaskObject))
             {
                 System.out.println("Enter in new Description");
                 String newDescription = input.nextLine();
                 this.setDescription(newDescription);
                 
                 System.out.println("");
               
             
             }
    }
    
    public void addSubTask(SubTask SubtaskObject)
    {
     SubTasks.add(SubtaskObject);
     System.out.println("SubTask added to Task");
    }
    
    public void removeSubTask(SubTask SubtaskObject)
    {
     if(SubTasks.contains(SubtaskObject))
             {
              SubTasks.remove(SubtaskObject);
             }
     else System.out.println("SubTask not in Task");
    }
       
    
  
    
}
