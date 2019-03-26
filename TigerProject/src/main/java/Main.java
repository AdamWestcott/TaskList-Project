/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.model.Board;
import com.tiger.todolist.model.Category;
import com.tiger.todolist.model.Task;
import com.tiger.todolist.model.User;
import com.tiger.todolist.view.SignIn;
import com.tiger.todolist.view.mainWindow;
import java.util.Date;

/**
 *
 * @author K1732912
 */
public class Main {

    public static void main(String[] args) {
        
     
        User Paul = new User("Paul","Neve",0);
        Board.getStatus().addUser(Paul);
        Paul.createList("Cats dates");
        Paul.createList("EH RAW");
        Paul.createList("Work");
        
        Paul.getList().get(0).createTask(false, "Description: of task 0 ", "today", 5, "Task 0");            
        Paul.getList().get(0).createTask(false, "Description: of task 1 ", "Tomorrow", 1, "Task 1"); //Add two tasks to list "cat dates"
        
        Paul.getList().get(1).createTask(false, "EH RAW TASK 0 ", "today", 1, "Task 0");            
        Paul.getList().get(1).createTask(false, "EH RAW TASK 1 ", "Tomorrow", 1, "Task 1"); //Add two tasks to list "cat dates"
        
        //Paul.getList().get(0).loadTasks();  //System prints out the tasks in list 0
        
        
        User Tim = new User("Tim","password",0);
        Board.getStatus().addUser(Tim);
        Tim.createList("Tims dates");
        Tim.createList("Works");
        Tim.createList("Personal");
        
        SignIn.getInstance();    
        mainListener mainController = new mainListener(); 
       
       
    }
    
}
