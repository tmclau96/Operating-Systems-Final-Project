package ProcessManagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
        this.startTime = System.currentTimeMillis();
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
                frame.onExecution(Integer.toString(pid)); 
                
                long time = System.currentTimeMillis() - this.startTime;
                double throughput = (double)(pid-1000) / (double) time;
                frame.setThroughput(Double.toString(throughput), Long.toString(time));
            }//end try
            catch(InterruptedException ex)
            {
                System.out.println("error in CPU sleep function");
            }//end catch
        }
    }
    // make a Thread sleep for run_time millis(?)
    
}
