package ProcessManagement;

import java.util.Random;
import java.lang.Math;

public class Scheduler {
    private static final int MAX_QUEUE_SIZE = 500;
    private int index;
    Process[] readyQueue;
    int time = 0;
    int pid = 1000;
    
    public Scheduler()
    {
        readyQueue = new Process[MAX_QUEUE_SIZE];
        int index = 0;
    }//end of constructor
    
    private int addProcess(Process p)
    {
        if(index >= readyQueue.length)      //ready queue is full
        {
            System.out.println("READY QUEUE IS AT MAX SIZE");
            return 1;
        }//end if
        else
        {
            readyQueue[index] = new Process(p);
            index++;
            return 0;
        }//end else
    }//end add process
    
    
    
    public void createProcesses()  //populate ready queue
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Create 1000 processes
                while(pid < 2000) {
                    Random rand = new Random();
                    int meanRunTime = 10;
                    int sd = 2;
                    // Random number following a Normal distribution
                    int runTime = (int) Math.round(rand.nextGaussian()) * sd + meanRunTime;
                    int meanDelayTime = 5;
                    sd = 1;
                    int arrivalDelayTime = (int) Math.round(rand.nextGaussian()) * sd + meanDelayTime;
                    System.out.println(Scheduler.this.time);
                    try {
                            // Wait for process to arrive
                            Thread.sleep(arrivalDelayTime);
                            Scheduler.this.time += arrivalDelayTime;
                        } catch (InterruptedException e) {
                            System.out.println("Queue waiting for arival interrupted");
                        }

                    Process p = new Process(Scheduler.this.pid, Process.WAITING, (time), runTime);
                    System.out.println(p);
                    Scheduler.this.pid++;
                    while (addProcess(p) == 1) {
                        try {
                            // Wait for some process to finish
                            Thread.sleep(meanRunTime);
                            Scheduler.this.time += meanRunTime;
                        } catch (InterruptedException e) {
                            System.out.println("Waiting for queue spot to open up interrupted");
                        }
                    }
                }
            }
        }).start();
        
    }
}
