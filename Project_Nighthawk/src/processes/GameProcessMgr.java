/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mike
 */
public class GameProcessMgr
{
    private List<AbsGameProcess> processList = new ArrayList<>();
    private static GameProcessMgr gpm = new GameProcessMgr();
    
    private GameProcessMgr()
    {
        
    }
    
    public static GameProcessMgr getInstance()
    {
        return gpm;
    }
    
    
    public int updateProcesses(long deltaMs)
    {
        int successCount = 0;
        int failCount = 0;
        
        for(AbsGameProcess current: processList)
        {
            // Gets the index of the current process in case we have to remove it
            int currentIndex = processList.indexOf(current);
            
            // If the process is uninitialized, initialize it.
            if(current.getState() == AbsGameProcess.State.UNINITIALIZED)
            {
                current.onInit();
            }
            
            // If the process is running, update it.
            if(current.getState() == AbsGameProcess.State.RUNNING)
            {
                current.onUpdate(deltaMs);
            }
            
            // If the process is dead, run the appropriate exit function
            if(current.isDead())
            {
                switch(current.getState())
                {
                    case SUCCEEDED:
                        current.onSuccess();
                        AbsGameProcess child = current.removeChild();
                        if(child != null)
                        {
                            attachProcess(child);
                        }
                        else
                        {
                            ++successCount; // Only counts if the whole chain is completed.
                        }
                        break;
                    case FAILED:
                        current.onFail();
                        ++failCount;
                        break;
                    case ABORTED:
                        current.onAbort();
                        ++failCount;
                        break;
                }
                
                // Remove the process and destroy it
                processList.remove(currentIndex);
            }
        }
        return ((successCount << 16) | failCount);
    }
    
    public void attachProcess(AbsGameProcess process)
    {
        processList.add(process);
    }
    
    public void abortAllProcesses()
    {
        
    }
    
    public int getProcessCount()
    {
        return processList.size();
    }
    
    private void clearAllProcesses()
    {
        
    }
}