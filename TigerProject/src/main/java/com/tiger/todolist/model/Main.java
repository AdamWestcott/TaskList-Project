/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiger.todolist.model;
import java.util.Date;

/**
 *
 * @author K1732912
 */
public class Main {

    public static void main(String[] args) {
        Board userBoard = new Board();
        List a = new List();
        List b = new List();
        userBoard.createList(a);
        userBoard.createList(b);
        
        Task newTask = new Task();
        System.out.println(newTask.getDueDate()); 
        newTask.setDueDate(new Date(119, 0, 28)); //(year+1900, month jan = 0 e.g., day)  
        System.out.println(newTask.getDueDate()); 
    }
    
}
