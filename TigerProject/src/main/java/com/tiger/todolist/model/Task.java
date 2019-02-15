/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.model;

/**
 *
 * @author K1732912
 */
public class Task {
    private boolean checkbox;
  private String description;
  private String startDate;
  private String endDate;
  private int priority; 
  private String name;
  
  public Task (boolean checkbox, String description, String startDate, String endDate, int priority, String name){
      this.checkbox = checkbox;
      this.startDate = startDate;
      this.description = description;
      this.endDate = endDate;
      this.priority = priority;
      this.name = name;
  }
  
  public Task(){
      this.checkbox = false;
      this.description = "default";
      this.startDate = "";
      this.endDate = "000000";
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
