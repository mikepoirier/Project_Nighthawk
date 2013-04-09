/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameView;

import actors.Actor;
import actors.ActorFactory;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author Mike
 */
public class GameMap extends AbsGamePanel
{
    ActorFactory af;
    
    public GameMap()
    {
        init(null);
    }
    
    public GameMap(Dimension d)
    {
        init(d);
    }
    
    @Override
    protected final void init(Dimension d)
    {
        super.init(d);
        af = ActorFactory.getInstance();
    }

    @Override
    public void paint(Graphics g)
    {
        
        bufferGraphics.clearRect(0, 0, d.width, d.height);
        
        List<Actor> actors = af.getActorList();
        
        for (Actor current : actors)
        {
            current.draw(offscreen);
        }
        
        g.drawImage(offscreen, 0, 0, this);
    }
    
}
