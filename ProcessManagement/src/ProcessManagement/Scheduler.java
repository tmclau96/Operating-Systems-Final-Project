package ProcessManagement;

public class Scheduler {
    private static final int MAX_QUEUE_SIZE = 10;
    private int index;
    Process[] readyQueue;
    
    public Scheduler()
    {
        readyQueue = new Process[MAX_QUEUE_SIZE];
        int index = 0;
    }//end of constructor
    
    public void addProcess(Process p)
    {
        if(index >= readyQueue.length)      //ready queue is full
        {
            System.out.println("READY QUEUE IS AT MAX SIZE");
        }//end if
        else
        {
            readyQueue[index] = new Process(p);
            index++;
        }//end else
    }//end add process
    
    
    
    private void createProcesses()  //populate ready queue
    {
        
    }
}
