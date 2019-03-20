/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessManagement;

/**
 *
 * @author Taylor
 */
public class Process {
    private int pid;
    private String state;
    
    public Process(int pid, String state)
    {
        this.pid = pid;
        this.state = state;
    }//end constructor
    
    public int getPID()
    {
        return pid;
    }//end get pid
    
    public String getState()
    {
        return state;
    }//end get state
}//end class
