/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.model.Board;
import com.tiger.todolist.model.User;
import com.tiger.todolist.view.SignIn;
import java.util.Date;


/**
 *
 * @author K1732912
 */
public class Main {

    public static void main(String[] args) {
        
        User Paul = new User("Paul","Neve",1);  //Admin level
        Board.getStatus().addUser(Paul);
        Paul.createList("Cats dates");
        Paul.createList("EH RAW");
        Paul.createList("Work");
        
        Paul.getList().get(0).createTask(false, "Description: of task 0 ",new Date(), 5, "Task 0");            
        Paul.getList().get(0).createTask(false, "Description: of task 1 ", new Date(), 1, "Task 1"); 
        Paul.getList().get(0).getTask().get(0).createSubTask("get cat milk",new Date(),2);
        Paul.getList().get(0).getTask().get(0).createSubTask("get stuff",new Date(),2);
        Paul.getList().get(0).getTask().get(0).createSubTask("gedsfbhdfbdfb",new Date(),2);
        
        Paul.getList().get(1).createTask(false, "EH RAW TASK 0 ", new Date(), 1, "Task 0");            
        Paul.getList().get(1).createTask(false, "EH RAW TASK 1 ", new Date(), 1, "Task 1"); 
        Paul.getList().get(1).getTask().get(0).createSubTask("EH RAWWWWW",new Date(),2);
        Paul.getList().get(1).getTask().get(0).createSubTask("MOAR EH RAWWWWW",new Date(),2);
        Paul.getList().get(1).getTask().get(0).createSubTask("EVEN MOARRRR EH RAWWWWW",new Date(),2);
    
        
        SignIn.getInstance();    
        mainListener mainController = new mainListener(); 
       

   }
    
}
