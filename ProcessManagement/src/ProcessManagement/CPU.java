package ProcessManagement;

import java.util.Date;

/**
 *
 * @author anastasiya
 */
public class CPU {
    private int sleepTime;
	
    public CPU(int sleepTime)
    {
    	this.sleepTime=sleepTime;
    }
    
    public void sleep()
    {
        try
        {
            Thread.sleep(sleepTime);
            System.out.println(Thread.currentThread().getName()+" The task executed at "+ new Date());
        }//end try
        catch(InterruptedException ex)
        {
            System.out.println("error in sleep function");
        }//end catch
    }
    // make a Thread sleep for run_time millis(?)
    
}
