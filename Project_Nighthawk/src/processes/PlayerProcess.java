/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processes;

import actors.Actor;
import actors.ActorFactory;
import gameView.AbsGamePanel;
import java.util.ArrayList;
import java.util.List;
import resourceCache.ResourceCache;

/**
 *
 * @author Mike
 */
public class PlayerProcess extends AbsGameProcess
{
    
    ActorFactory af;
    ResourceCache rc;
    AbsGamePanel agp;

    @Override
    public void onInit()
    {
        rc = ResourceCache.getInstance();
        rc.setResourceLocation("../Assets/Images");
        rc.upload("SMikeWalk.zip");
        rc.upload("SRobWalk.zip");
        af = ActorFactory.getInstance();
        addActor("../Assets/Actors/player_2D.xml");
        
        setState(State.RUNNING);
    }

    @Override
    public void onUpdate(long deltaMs)
    {
        List<Actor> actorList = af.getActorList();
        
        for(Actor current : actorList)
        {
            current.update();
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
    
    public void addActor(String resource)
    {
        Actor p = af.createActor(resource);
    }
    
}
