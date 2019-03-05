/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.model;

/**
 *
 * @author k1746252
 */
public class SubTask extends Task {   
   
    //PROPERTIES
   private String task;
   private Boolean checkBox;
   private String subTaskTitle;
   
   //FUNCTIONS
   public SubTask()
   {
       this.task=super.getName();
       this.checkBox=false;
       this.subTaskTitle="No Entry,Edit SubTask Title";
       
   }
   
}
