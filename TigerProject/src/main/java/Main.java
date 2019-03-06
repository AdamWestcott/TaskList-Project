/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.model.Board;
import com.tiger.todolist.view.mainWindow;
import java.util.Date;

/**
 *
 * @author K1732912
 */
public class Main {

    public static void main(String[] args) {
    
        
        Board.getStatus(); 
        //Board.getStatus().createUser("Tim","Tim27",1);
        
        
        mainWindow window = new mainWindow(); 
        mainListener mainController = new mainListener();
        

// mainWindow a = new mainWindow();
        //taskWindow b = new taskWindow();
       // subtaskWindow c = new subtaskWindow();
       
       
    }
    
}
