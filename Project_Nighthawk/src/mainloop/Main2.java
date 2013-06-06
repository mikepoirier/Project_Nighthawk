/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainloop;

import processes.GameProcessMgr;
import processes.PlayerProcess;
import processes.Render2DProcess;

/**
 *
 * @author Mike
 */
public class Main2
{

    GameProcessMgr gpm;
    Render2DProcess r2dp;
    PlayerProcess pp;

    public boolean CreateProcesses()
    {
        boolean processesCreated = false;
        
        gpm = GameProcessMgr.getInstance();
        
        r2dp = new Render2DProcess();
        pp = new PlayerProcess();       
        
        gpm.attachProcess(r2dp);
        gpm.attachProcess(pp);
        
        processesCreated = true;
        
        return processesCreated;
    }

    /**
     * This is the game loop. It will iterate through all the different
     * processes and update each of them until the shutdown command is reached.
     */
    public void RunProcesses()
    {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 30;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        boolean gameRunning = true;
	long lastFpsTime = System.nanoTime();
	int fps = 0;

        // keep looping round til the game ends
        while (gameRunning)
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000)
            {
                System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            gpm.updateProcesses(updateLength);

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give 
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try
            {
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            }
            catch(Exception e)
            {
                System.err.println("Error in game loop!");
                e.printStackTrace();
            }
        }
    }

    public void ShutdownProcesses()
    {
    }

    public static void main(String[] args)
    {
        Main2 startup = new Main2();

        if (startup.CreateProcesses())
        {
            startup.RunProcesses();
        }
        startup.ShutdownProcesses();
    }
}