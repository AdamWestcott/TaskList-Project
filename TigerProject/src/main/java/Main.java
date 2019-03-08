/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.model.Board;
import com.tiger.todolist.model.Category;
import com.tiger.todolist.model.User;
import com.tiger.todolist.view.mainWindow;
import java.util.Date;

/**
 *
 * @author K1732912
 */
public class Main {

    public static void main(String[] args) {
        
        Board.getStatus().createUser("time", "doa", 1);
        Board.getStatus().createUser("time", "fafa", 1);
        Board.getStatus().createUser("time", "dgag", 1);
        Board.getStatus().createUser("time", "dhshs", 1);
        
        User a = new User();
        Board.getStatus().addUser(a);
        
        
        Category sgs = new Category("asga");
        Category fs = new Category("fwsgs"); 
        Category gs = new Category("afa");
        Category gsa = new Category("afaafa");
        
        Board.getStatus().getUsers().get(0).addList(sgs); 
        Board.getStatus().getUsers().get(0).addList(fs);
        Board.getStatus().getUsers().get(0).addList(gs);
        Board.getStatus().getUsers().get(0).addList(gsa);
        Board.getStatus(); 
        //Board.getStatus().createUser("Tim","Tim27",1);
        
        
        mainWindow window = new mainWindow(); 
        mainListener mainController = new mainListener(); 
        
       
        // mainWindow a = new mainWindow();
        //taskWindow b = new taskWindow();
       // subtaskWindow c = new subtaskWindow();
       
       
    }
    
}
