import com.tiger.todolist.controller.popupWindows;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author k1732912
 */
public class addSubtaskPopUp extends JFrame{
    private JLabel addSubtask = new JLabel("Add SubTask");

   
    private JTextField entTaskName = new JTextField();
    private JButton confirm = new JButton("Add task");
    
    private popupWindows listener = new popupWindows(); 
    private static addSubtaskPopUp instance = null; 
    
    public static addSubtaskPopUp getInstance(){
        if(addSubtaskPopUp.instance == null) addSubtaskPopUp.instance = new addSubtaskPopUp();
                return addSubtaskPopUp.instance; 
    }
    
    public static void deleteObject(){
         addSubtaskPopUp.instance = null; 
    }
    
    public addSubtaskPopUp(){
        this.setLayout(new GridLayout(1,1));
        
        this.add(addSubtask);
        
        confirm.addActionListener(listener);
        confirm.setActionCommand("addSub");
        this.add(confirm);
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        
    }
      public JTextField getEntTaskName() {
          return entTaskName;
    }

   
}
