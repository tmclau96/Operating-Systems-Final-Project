package ProcessManagement;

import java.awt.BorderLayout;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


/**
 *
 * @author Owner
 */
public class MainFrame extends JFrame{
    
    private Process process;
    JTextArea processTextArea = new JTextArea(); 
    JTextArea CPUTextArea = new JTextArea();
    
    public MainFrame(){
            
            //Layout of Frame
           
           JPanel leftPanel = new JPanel();
           
           JPanel rightPanel = new JPanel();
           
           leftPanel.setLayout( new BorderLayout());
           rightPanel.setLayout( new BorderLayout());
           this.processTextArea.setLineWrap(true);
           this.processTextArea.setSize(500, 1000);
           this.CPUTextArea.setLineWrap(true);
           this.CPUTextArea.setSize(500,1000);
           processTextArea.setEditable(false);
           CPUTextArea.setEditable(false);
           JScrollPane LScroll = new JScrollPane(processTextArea);
           JScrollPane RScroll = new JScrollPane(CPUTextArea);
           LScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
           RScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
           
            
        //Creation of Components that will go into the Frame
            
            
            
            
            //Adds Compnents to the content frame
            
            leftPanel.add(LScroll);
            rightPanel.add(RScroll);
            this.add(leftPanel,BorderLayout.WEST);
            this.add(rightPanel, BorderLayout.EAST);
            this.pack();
            
            
            
                 
    }

    public void onProcessCreation(ArrayBlockingQueue<Process> p) {
        synchronized(p){
            processTextArea.setText(processTextArea.getText() + p.peek().toString());
            
        }
    }
    
    public void onExecution(Process p) {
        synchronized(p){
            CPUTextArea.setText(CPUTextArea.getText()+ " Executed Process: " +p.getPID() + "\n");
        }
    }
    
    }
    

    
    
