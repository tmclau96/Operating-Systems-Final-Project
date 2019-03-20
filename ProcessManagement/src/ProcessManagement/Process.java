package ProcessManagement;

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
