package ProcessManagement;

//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//import java.lang.System;

/**
 * 
 * @author anastasiya
 */
public class CPU extends Thread {
    private final Scheduler scheduler;
    private final MainFrame frame;
    private long startTime;
	
    public CPU(Scheduler scheduler, MainFrame frame)
    {
    	this.scheduler = scheduler;
        this.frame = frame;
        startTime = System.currentTimeMillis();
    }
    
    @Override
    public void run()
    {
        while(true) {
            try
            {
                Process runningProcess = null;
                if (!scheduler.readyQueue.isEmpty()) {
                    runningProcess = scheduler.readyQueue.take(); // removes it from readyQueue
                    frame.setQueueStatus("Queue is not empty");
                }
                else {
                    frame.setQueueStatus("Queue is empty");
                    Thread.sleep(4);
                    continue;
                }
                runningProcess.setState(Process.RUNNING);
                Thread.sleep(runningProcess.getRunTime());
                
                int pid = runningProcess.getPID();
                long time = System.currentTimeMillis() - this.startTime;
                frame.onExecution(pid, time, scheduler.MAX_QUEUE_SIZE - scheduler.readyQueue.remainingCapacity()); 
                double throughput = (double)(pid-1000) / (double) time;
                System.out.println("throughput=" + throughput + " num=" + (pid-1000) + " time=" + time);
                frame.setThroughput(Double.toString(throughput));
            }//end try
            catch(InterruptedException ex)
            {
                System.out.println("error in CPU sleep function");
            }//end catch
        }
    }
    // make a Thread sleep for run_time millis(?)
    
}
