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
public class user {
    private String username;
    private String password;
    private board userBoard;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public board getUserBoard() {
        return userBoard;
    }

    public void setUserBoard(board userBoard) {
        this.userBoard = userBoard;
    }
    
}
