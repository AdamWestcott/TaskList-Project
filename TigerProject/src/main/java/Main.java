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
        
        //Board.getStatus().createUser("time", "doa", 1);
        //Board.getStatus().createUser("time", "fafa", 1);
        //Board.getStatus().createUser("time", "dgag", 1);
        //Board.getStatus().createUser("time", "dhshs", 1);
        
//        User a = new User();
//        Board.getStatus().addUser(a);
//        
//        
//        Category Csgs = new Category("asga");
//        Category Cfs = new Category("fwsgs"); 
//        Category Cgs = new Category("afa");
//        Category Cgsa = new Category("afaafa");
//        
//        Task ava = new Task(false,"A task afa","2/2/29",3,"Get milk");
//        Task sg = new Task(false,"Another task ","2/2/29",3,"Get the code working"); 
//        Task deh = new Task(false,"A third task","2/2/29",3,"Get Apples"); 
//        Task hsh = new Task(false,"A task afa","2/2/29",3,"Do something"); 
//        
//        
//        Board.getStatus().getUsers().get(0).addList(Csgs); 
//        Board.getStatus().getUsers().get(0).addList(Cfs);
//        Board.getStatus().getUsers().get(0).addList(Cgs);
//        Board.getStatus().getUsers().get(0).addList(Cgsa);
//        Board.getStatus(); 
        //Board.getStatus().createUser("Tim","Tim27",1);
//        Board.getStatus().getUsers().get(0).getList().get(1).createTask(false,"A task description","2/2/29",3,"Get milk");
//        Board.getStatus().getUsers().get(0).getList().get(0).createTask(false,"Another task ","2/2/29",3,"Get the code working");
//        Board.getStatus().getUsers().get(0).getList().get(0).createTask(false,"A third task","2/2/29",3,"Get Apples");
        //Board.getStatus().getUsers().get(0).getList().get(0).createTask(false,"A task afa","2/2/29",3,"Do something");
//        Csgs.addTask(ava);
//        Csgs.addTask(sg);
//        Cfs.addTask(sg);
//        Cgs.addTask(deh);
//        Cgsa.addTask(hsh);
        
        User Paul = new User("Paul","Neve",0);
        Board.getStatus().addUser(Paul);
        Paul.createList("Cats dates");
        Paul.createList("EH RAW");
        Paul.createList("Work");
        
        Paul.getList().get(0).createTask(false, "Description: of task 0 ", "today", 1, "Task 0");            
        Paul.getList().get(0).createTask(true, "Description: of task 1 ", "Tomorrow", 1, "Task 1"); //Add two tasks to list "cat dates"
        
        Paul.getList().get(1).createTask(true, "EH RAW TASK 0 ", "today", 1, "Task 0");            
        Paul.getList().get(1).createTask(true, "EH RAW TASK 1 ", "Tomorrow", 1, "Task 1"); //Add two tasks to list "cat dates"
        
        Paul.getList().get(0).loadTasks();  //System prints out the tasks in list 0
        
        
        User Tim = new User("Tim","password",0);
        Board.getStatus().addUser(Tim);
        Tim.createList("Tims dates");
        Tim.createList("Works");
        Tim.createList("Personal");
        
        SignIn.getInstance();    
        //mainWindow window = new mainWindow(); 
        mainListener mainController = new mainListener(); 
        
       
        // mainWindow a = new mainWindow();
        //taskWindow b = new taskWindow();
       // subtaskWindow c = new subtaskWindow();
       
       
    }
    
}
