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
public class Main {

    public static void main(String[] args) {
        Board userBoard = new Board();
        List a = new List();
        List b = new List();
        userBoard.createList(a);
        userBoard.createList(b);
        
    }
    
}
