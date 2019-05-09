package ProcessManagement;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.lang.Math;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;


public class Scheduler {
    private static final int MAX_QUEUE_SIZE = 1001;
    //private int index;
    private CPU cpu;
    ArrayBlockingQueue<Process> readyQueue;
    int time = 0;
    int pid = 1000;
    Process process;
    MainFrame frame = new MainFrame();
    
    public Scheduler()
    {
        readyQueue = new ArrayBlockingQueue<Process>(MAX_QUEUE_SIZE, true);
        this.cpu = new CPU(this,frame);
        
    }//end of constructor
    
    private int addProcess(Process p)
    {
        try {
            readyQueue.add(p);
        }
        catch (IllegalStateException e) {
            return 0;
        }
        return 1;
    }//end add process
    
    
    
    public void createProcesses()  //populate ready queue
    {      
        Thread thread1 = new Thread(){
            public void run() {
                // Create 1002 processes
                Scheduler.this.cpu.start();
                
                while(pid < 2002) {
                    Random rand = new Random();
                    int meanRunTime = 10;
                    int sd = 2;
                    // Random number following a Normal distribution
                    int runTime = (int) Math.round(rand.nextGaussian()) * sd + meanRunTime;
                    int meanDelayTime = 5;
                    sd = 1;
                    int arrivalDelayTime = (int) Math.round(rand.nextGaussian()) * sd + meanDelayTime;
                    //System.out.println(Scheduler.this.time);
                    try {
                            // Wait for process to arrive
                            Thread.sleep(arrivalDelayTime);
                            Scheduler.this.time += arrivalDelayTime;
                        } catch (InterruptedException e) {
                            System.out.println("Queue waiting for arival interrupted");
                        }

                    Process p = new Process(Scheduler.this.pid, Process.WAITING, (time), runTime);    //constructs Process
                    double throughput = (double)(pid-1000) / (double) time;
                    System.out.println("throughput=" + throughput + " num=" + (pid-1000) + " time=" + time);
                    
                    Scheduler.this.pid++;
                    try {
                    Scheduler.this.readyQueue.put(p);
                    frame.onProcessCreation(readyQueue);
                    frame.setThroughput(Double.toString(throughput));
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
                    
            }
            
        };
        thread1.start();
        
        SwingUtilities.invokeLater(new Runnable(){
                                                
                        public void run() {
                            
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            frame.setSize(500,500);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setVisible(true);
       
                        }
                    });
        
    }//end of create proccess
    
        
}//end of class
