/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processes;

/**
 *
 * @author Mike
 */
public abstract class AbsGameProcess
{

    public enum State
    {

        UNINITIALIZED, REMOVED, RUNNING, PAUSED, SUCCEEDED, FAILED, ABORTED;
    }
    private State currentState = State.UNINITIALIZED;
    private AbsGameProcess childProcess;

    public abstract void onInit();

    public abstract void onUpdate(long deltaMs);

    public abstract void onSuccess();

    public abstract void onFail();

    public abstract void onAbort();

    public abstract void succeed();

    public abstract void fail();

    public abstract void pause();

    public abstract void unpause();

    public void attachChild(AbsGameProcess child)
    {
        this.childProcess = child;
    }

    public AbsGameProcess removeChild()
    {
        AbsGameProcess temp = this.childProcess;
        this.childProcess = null;
        return temp;
    }

    public AbsGameProcess getChild()
    {
        return this.childProcess;
    }

    public State getState()
    {
        return currentState;
    }
    
    protected void setState(State state)
    {
        currentState = state;
    }
    
    public boolean isAlive()
    {
        return (currentState == State.RUNNING || 
                currentState == State.PAUSED);
    }
    
    public boolean isDead()
    {
        return (currentState == State.SUCCEEDED ||
                currentState == State.FAILED ||
                currentState == State.ABORTED);
    }
}
