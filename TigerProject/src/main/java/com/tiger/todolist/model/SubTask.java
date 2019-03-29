/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.model;

import java.util.Date;

/**
 *
 * @author k1746252
 */
public class SubTask extends Task {   
   
    //PROPERTIES
   private String task;
   private String description;
   private Date completionDate;
   private int priorityOrder;
   
   //FUNCTIONS
   public SubTask()
   {
       this.task=super.getName();
       this.description="No Entry,Edit SubTask Title";
       this.completionDate= new Date();
       this.priorityOrder = 2;
       
   }
   
    public SubTask(String description, Date completionDate, int priorityOrder)
   {
       this.task = super.getName();
       this.description = description;
       this.completionDate = completionDate;
       this.priorityOrder = priorityOrder; 
       
   }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(int priorityOrder) {
        this.priorityOrder = priorityOrder;
    }
    
    
}
