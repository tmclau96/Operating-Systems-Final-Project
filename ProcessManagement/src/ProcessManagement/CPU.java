/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessManagement;

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
    	Thread.sleep(sleepTime);
    	System.out.println(Thread.currentThread().getName()+" The task executed at "+ new Date());
    }
    // make a Thread sleep for run_time millis(?)
    
}
