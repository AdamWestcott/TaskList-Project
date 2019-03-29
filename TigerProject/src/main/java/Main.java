/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tiger.todolist.controller.mainListener;
import com.tiger.todolist.model.Board;
import com.tiger.todolist.model.Category;
import com.tiger.todolist.model.SubTask;
import com.tiger.todolist.model.Task;
import com.tiger.todolist.model.Translator;
import com.tiger.todolist.model.Translator.Subtask;
import com.tiger.todolist.model.User;
import com.tiger.todolist.view.SignIn;
import com.tiger.todolist.view.mainWindow;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.apache.http.protocol.HTTP.USER_AGENT;

/**
 *
 * @author K1732912
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
     
        User Paul = new User("Paul","Neve",0);
        Board.getStatus().addUser(Paul);
        Paul.createList("Cats dates");
        Paul.createList("EH RAW");
        Paul.createList("Work");
        
        Paul.getList().get(0).createTask(false, "Description: of task 0 ",new Date(), 5, "Task 0");            
        Paul.getList().get(0).createTask(false, "Description: of task 1 ", new Date(), 1, "Task 1"); //Add two tasks to list "cat dates"
        Paul.getList().get(0).getTask().get(0).createSubTask("get cat milk",new Date(),2);
        Paul.getList().get(0).getTask().get(0).createSubTask("get stuff",new Date(),2);
        Paul.getList().get(0).getTask().get(0).createSubTask("gedsfbhdfbdfb",new Date(),2);
        
        Paul.getList().get(1).createTask(false, "EH RAW TASK 0 ", new Date(), 1, "Task 0");            
        Paul.getList().get(1).createTask(false, "EH RAW TASK 1 ", new Date(), 1, "Task 1"); 
        Paul.getList().get(1).getTask().get(0).createSubTask("EH RAWWWWW",new Date(),2);
        Paul.getList().get(1).getTask().get(0).createSubTask("MOAR EH RAWWWWW",new Date(),2);
        Paul.getList().get(1).getTask().get(0).createSubTask("EVEN MOARRRR EH RAWWWWW",new Date(),2);
        
        //Paul.getList().get(0).loadTasks();  //System prints out the tasks in list 0
        
        
        User Tim = new User("Tim","password",0);
        Board.getStatus().addUser(Tim);
        Tim.createList("Tims dates");
        Tim.createList("Works");
        Tim.createList("Personal");
        
        SignIn.getInstance();    
        mainListener mainController = new mainListener(); 
       
       Gson gson = new Gson();
      // String jsonCode = gson.toJson(Tim);
       //System.out.println(jsonCode);
       
       String altText = "{\"username\":\"Jim\",\"password\":\"egg\",\"userLevel\":0,\"list\":[{\"title\":\"Jims dates\",\"task\":[],\"backupList\":[]},{\"title\":\"Works\",\"task\":[],\"backupList\":[]},{\"title\":\"Personal\",\"task\":[],\"backupList\":[]}]}";
       
      //User ex = gson.fromJson(altText, User.class);
      //System.out.println(ex.getUsername());
      
      String url = "http://www.nooblab.com/p2.json";

	HttpClient client = HttpClientBuilder.create().build();
	HttpGet request = new HttpGet(url);

	// add request header
	request.addHeader("User-Agent", USER_AGENT);
	HttpResponse response = client.execute(request);

	BufferedReader rd = new BufferedReader(
		new InputStreamReader(response.getEntity().getContent()));
        
 //       Type founderListType = new TypeToken<ArrayList<Task>>(){}.getType();
//        ArrayList<Translator> results = gson.fromJson(rd,founderListType);
        
       Translator[] results = gson.fromJson(rd,Translator[].class);
       //ArrayList<Translator> results = new ArrayList(Arrays.asList(results));
       
        for (Translator result : results){
            //Adding a new user
            int userListPos ; //Position of the new user added to the list.
            
                //PASSING NEW USER
                String newUserName = result.getUser().getName();
                String newUserPass = result.getUser().getPassword();
                int newLevel = result.getUser().getUserLevel();
                Board.getStatus().createUser(newUserName, newUserPass, newLevel);   //Creating a new user from passed data
                userListPos =  Board.getStatus().getUsers().size()-1;       
                User Uobj = Board.getStatus().getUsers().get(userListPos);
                Uobj.createList(Uobj.getUsername()+"'s List");                        //Creating a defualt list for user
                
                int taskNumber = 0;
                for(Translator task : results){
                //PASSING NEW TASK FOR EACH USER
                if(task.getUser().getName().equals(Uobj.getUsername()) ){
                    int tasksAdded = 0;
                    String newTaskName = task.getDescription();
                    Date newDueDate = task.getCompletionDate();
                    int newPriority = task.getPriorityOrder();

                    //ArrayList<Subtask> newSubTasks = task.getSubtasks();
                    
                    Uobj.getList().get(0).createTask(false,newTaskName,newDueDate,newPriority,"Task");
                    
                    for(int x = 0; x< result.getSubtasks().size();x++){
 
                        String subDesc = result.getSubtasks().get(x).getDescription();
                        Date subDueDate = result.getSubtasks().get(x).getCompletionDate();
                        int subPri = result.getSubtasks().get(x).getPriorityOrder();
                        Uobj.getList().get(0).getTask().get(taskNumber).createSubTask(subDesc, subDueDate, subPri);
                         
                    }
                    taskNumber++;
                    
                    //Uobj.getList().get(0).getTask().get(i).setSubTasks(newSubTasks);
                    
                    }
                
                }
                
             
            
            
            
            
            
        }
        
    }
    
}
