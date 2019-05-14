package ProcessManagement;

import java.awt.BorderLayout;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.FlowLayout;


/**
 *
 * @author Owner
 */
public class MainFrame extends JFrame{
    
    private Process process;
    private JTextArea processTextArea = new JTextArea(); 
    private JTextArea CPUTextArea = new JTextArea();
    private JTextField queueStatus = new JTextField();
    private JTextField rate = new JTextField();
    private JTextField time = new JTextField();
    
    public MainFrame(){
            
            //Layout of Frame
           
           JPanel leftPanel = new JPanel();
           JPanel centerPanel = new JPanel();
           JPanel rightPanel = new JPanel();
           
           leftPanel.setLayout( new BorderLayout());
           centerPanel.setLayout(new BorderLayout());
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
           
           queueStatus.setEditable(false);
           queueStatus.setSize(400, 100);
           centerPanel.add(queueStatus, BorderLayout.SOUTH);
           
           JLabel rateLabel = new JLabel("Throughput:");
           rate.setEditable(false);
           rate.setSize(100, 100);
           JLabel timeLabel = new JLabel("Time:");
           time.setEditable(false);
           time.setSize(100, 100);
           JPanel ratePanel = new JPanel();
           ratePanel.setLayout(new FlowLayout());
           ratePanel.add(rateLabel);
           ratePanel.add(rate);
           ratePanel.add(timeLabel);
           ratePanel.add(time);
           centerPanel.add(ratePanel, BorderLayout.CENTER);
           
        //Creation of Components that will go into the Frame
            
            
            
            
            //Adds Compnents to the content frame
            
            leftPanel.add(LScroll);
            rightPanel.add(RScroll);
            this.add(leftPanel,BorderLayout.WEST);
            this.add(centerPanel, BorderLayout.CENTER);
            this.add(rightPanel, BorderLayout.EAST);
            this.pack();
            
            
            
                 
    }

    public void onProcessCreation(String process) {
        processTextArea.setText(process);
            
    }
    
    public void onExecution(String pid) {
        CPUTextArea.setText(CPUTextArea.getText()+ " Executed Process: " + pid + "\n");
    }

    public void setQueueStatus(String status) {
        queueStatus.setText(status);
    }
    
    public void setThroughput(String rate, String time) {
        this.rate.setText(rate);
        this.time.setText(time);
    }
    
}
    