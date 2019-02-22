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
public class Task {
    private boolean checkbox;
  private String description;
  private String startDate;
  private String dueDate;
  private int priority; 
  private String name;
  private ArrayList<SubTask> SubTasks  = new ArrayList<SubTask>();

  
  public Task (boolean checkbox, String description, String dueDate, int priority, String name){
      this.checkbox = checkbox;
      this.description = description;
      this.dueDate = dueDate;
      this.priority = priority;
      this.name = name;
  }
  
  public Task(){
      this.checkbox = false;
      this.description = "default";
      this.startDate = "";
      this.dueDate = "000000";
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

       public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
