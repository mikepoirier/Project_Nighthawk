/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processes;

/**
 *
 * @author Mike
 */
public class DelayProcess extends AbsGameProcess
{
    long timeToDelay;
    long timeDelayedSoFar;
    
    public void delayProcess(int timeToDelay)
    {
        this.timeToDelay = timeToDelay;
        timeDelayedSoFar = 0;
    }

    @Override
    public void onInit()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpdate(long deltaMs)
    {
        this.timeDelayedSoFar += deltaMs;
        if(timeDelayedSoFar >= timeToDelay)
        {
            succeed();
        }
    }

    @Override
    public void onSuccess()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onFail()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onAbort()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void succeed()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fail()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unpause()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}