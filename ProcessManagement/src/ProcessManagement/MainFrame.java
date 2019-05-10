package ProcessManagement;

import java.awt.BorderLayout;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.Dimension;

/**
 *
 * @author Owner
 */
public class MainFrame extends JFrame{
    
    private Process process;
    //private JTextArea processTextArea = new JTextArea(); 
    //private JTextArea CPUTextArea = new JTextArea();
    private JTextField rqPID = new JTextField(5);
    private JTextField rqTime = new JTextField(5);
    private JTextField rqNum = new JTextField(5);
    private JTextField cpuPID = new JTextField(5);
    private JTextField cpuTime = new JTextField(5);
    private JTextField cpuNum = new JTextField(5);
    private JTextField queueStatus = new JTextField(16);
    private JTextField rate = new JTextField();
    
    public MainFrame(){
        
        this.setLayout(new BorderLayout());
        this.setTitle("Process Management Simulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setPreferredSize(new Dimension(600, 900));

        //Layout of Frame

        JPanel leftPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setLayout(new BorderLayout());
        //leftPanel.setPreferredSize(new Dimension(200, 300));
        centerPanel.setLayout(new BorderLayout());
        //centerPanel.setPreferredSize(new Dimension(200, 300));
        rightPanel.setLayout(new BorderLayout());
        //rightPanel.setPreferredSize(new Dimension(200, 300));
//           this.processTextArea.setLineWrap(true);
//           this.processTextArea.setSize(500, 1000);
//           this.CPUTextArea.setLineWrap(true);
//           this.CPUTextArea.setSize(500,1000);
//           processTextArea.setEditable(false);
//           CPUTextArea.setEditable(false);
//           JScrollPane LScroll = new JScrollPane(processTextArea);
//           JScrollPane RScroll = new JScrollPane(CPUTextArea);
//           LScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//           RScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Creation of Components that will go into the Frame

        JPanel topLeftPanel = new JPanel(new FlowLayout());
        JLabel rqPIDLabel = new JLabel("PID:");
        rqPID.setEditable(false);
        //rqPID.setSize(100, 100);
        topLeftPanel.add(rqPIDLabel);
        topLeftPanel.add(rqPID);

        JPanel centerLeftPanel = new JPanel(new FlowLayout());
        JLabel rqTimeLabel = new JLabel("Arrival Time:");
        rqTime.setEditable(false);
        //rqTime.setSize(100, 100);
        centerLeftPanel.add(rqTimeLabel);
        centerLeftPanel.add(rqTime);

        JPanel bottomLeftPanel = new JPanel(new FlowLayout());
        JLabel rqNumLabel = new JLabel("Number in Queue:");
        rqNum.setEditable(false);
        //rqNum.setSize(100, 100);
        bottomLeftPanel.add(rqNumLabel);
        bottomLeftPanel.add(rqNum);

        leftPanel.add(topLeftPanel, BorderLayout.NORTH);
        leftPanel.add(centerLeftPanel, BorderLayout.CENTER);
        leftPanel.add(bottomLeftPanel, BorderLayout.SOUTH);

        JPanel topRightPanel = new JPanel(new FlowLayout());
        JLabel cpuPIDLabel = new JLabel("PID:");
        cpuPID.setEditable(false);
        //cpuPID.setSize(100, 100);
        topRightPanel.add(cpuPIDLabel);
        topRightPanel.add(cpuPID);

        JPanel centerRightPanel = new JPanel(new FlowLayout());
        JLabel cpuTimeLabel = new JLabel("Arrival Time:");
        cpuTime.setEditable(false);
       // cpuTime.setSize(100, 100);
        centerRightPanel.add(cpuTimeLabel);
        centerRightPanel.add(cpuTime);

        JPanel bottomRightPanel = new JPanel(new FlowLayout());
        JLabel cpuNumLabel = new JLabel("Number in Queue:");
        cpuNum.setEditable(false);
        //rqNum.setSize(100, 100);
        bottomRightPanel.add(cpuNumLabel);
        bottomRightPanel.add(cpuNum);

        rightPanel.add(topRightPanel, BorderLayout.NORTH);
        rightPanel.add(centerRightPanel, BorderLayout.CENTER);
        rightPanel.add(bottomRightPanel, BorderLayout.SOUTH);

        JPanel message = new JPanel(new FlowLayout());
        queueStatus.setEditable(false);
        //queueStatus.setSize(400, 100);
        message.add(queueStatus);
        centerPanel.add(message, BorderLayout.SOUTH);

        JLabel rateLabel = new JLabel("Throughput:");
        rateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rate.setEditable(false);
        //rate.setSize(100, 100);
        JPanel ratePanel = new JPanel();
        ratePanel.setLayout(new FlowLayout());
        ratePanel.add(rateLabel);
        ratePanel.add(rate);
        centerPanel.add(ratePanel, BorderLayout.CENTER);


        //Adds Compnents to the content frame

//            leftPanel.add(LScroll);
//            rightPanel.add(RScroll);
        this.add(leftPanel,BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);
        this.pack();
        this.setLocationRelativeTo(null);
                 
    }

    public void onProcessCreation(int PID, long time, int num) {
            rqPID.setText(Integer.toString(PID));
            rqTime.setText(Long.toString(time));
            rqNum.setText(Integer.toString(num));
    }
    
    public void onExecution(int PID, long time, int num) {
        cpuPID.setText(Integer.toString(PID));
        cpuTime.setText(Long.toString(time));
        cpuNum.setText(Integer.toString(num));
    }

    public void setQueueStatus(String status) {
        queueStatus.setText(status);
    }
    
    public void setThroughput(String rate) {
        this.rate.setText(rate);
    }
    
}
    