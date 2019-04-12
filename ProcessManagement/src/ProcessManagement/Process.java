package ProcessManagement;

public class Process {
    private int pid;
    private String state;
    private int arrival_time;
    private int run_time;
    
    public Process(int pid, String state, int arrival_time, int run_time)
    {
        this.pid = pid;
        this.state = state;
        this.arrival_time = arrival_time;
        this.run_time = run_time;
    }//end constructor
    
    public Process(Process p)
    {
        this.pid = p.getPID();
        this.state = p.getState();
        this.arrival_time = p.getArrivalTime();
        this.run_time = p.getRunTime();
    }//end copy constructor
   
    //setter methods
    
    public void setState(String state)
    {
        this.state = state;
    }//end set state
   
    //getter methods
    
    public int getPID()
    {
        return pid;
    }//end get pid
    
    public String getState()
    {
        return state;
    }//end get state
    
    public int getArrivalTime()
    {
        return arrival_time;
    }//end get arrival time
    
    public int getRunTime()
    {
        return run_time;
    }//end get run time
    

}//end class

