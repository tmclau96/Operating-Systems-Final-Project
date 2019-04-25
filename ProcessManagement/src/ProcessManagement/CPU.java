package ProcessManagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author anastasiya
 */
public class CPU extends Thread {
    private final Scheduler scheduler;
	
    public CPU(Scheduler scheduler)
    {
    	this.scheduler = scheduler;
    }
    
    @Override
    public void run()
    {
        while(true) {
            try
            {
                Process runningProcess = null;
                if (scheduler.readyQueue.size() != 0)
                    runningProcess = scheduler.readyQueue.take(); // removes it from readyQueue
                else {
                    System.out.println("Queue is empty");
                    Thread.sleep(4);
                    continue;
                }
                runningProcess.setState(Process.RUNNING);
                Thread.sleep(runningProcess.getRunTime());
                System.out.println(Thread.currentThread().getName()+
                        " Executed process  "+ runningProcess.getPID());
            }//end try
            catch(InterruptedException ex)
            {
                System.out.println("error in CPU sleep function");
            }//end catch
        }
    }
    // make a Thread sleep for run_time millis(?)
    
}
