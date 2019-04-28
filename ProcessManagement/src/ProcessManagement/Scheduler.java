package ProcessManagement;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.lang.Math;

public class Scheduler {
    private static final int MAX_QUEUE_SIZE = 1001;
    //private int index;
    private CPU cpu;
    ArrayBlockingQueue<Process> readyQueue;
    int time = 0;
    int pid = 1000;
    
    public Scheduler()
    {
        readyQueue = new ArrayBlockingQueue<Process>(MAX_QUEUE_SIZE, true);
        this.cpu = new CPU(this);
        //int index = 0;
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
//        if(index >= readyQueue.length)      //ready queue is full
//        {
//            System.out.println("READY QUEUE IS AT MAX SIZE");
//            return 1;
//        }//end if
//        else
//        {
//            readyQueue[index] = new Process(p);
//            index++;
//            return 0;
//        }//end else
    }//end add process
    
    
    
    public void createProcesses()  //populate ready queue
    {
        new Thread(new Runnable() {
            @Override
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

                    Process p = new Process(Scheduler.this.pid, Process.WAITING, (time), runTime);
                    System.out.println(p);
                    Scheduler.this.pid++;
                    try {
                    Scheduler.this.readyQueue.put(p);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
//                    while (addProcess(p) == 1) {
//                        try {
//                            // Wait for some process to finish
//                            Thread.sleep(meanRunTime);
//                            Scheduler.this.time += meanRunTime;
//                        } catch (InterruptedException e) {
//                            System.out.println("Waiting for queue spot to open up interrupted");
//                        }
                }
                    
            }
            
        }).start();
        
    }//end of create proccess
    
    public void sendToCPU()
    {
        //for(int i = 0; i < readyQueue.length; i++)  //FIFO
        {
            //cpu = new CPU(readyQueue[i].getRunTime());
            //cpu.sleep();
        }//end for loop
    }//end send to cpu
}//end of class
