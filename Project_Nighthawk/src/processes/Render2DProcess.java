/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processes;

import actors.ActorFactory;
import gameView.GameMap;
import gameView.GameMenu;
import gameView.GameWindow;
import java.awt.Dimension;

/**
 *
 * @author Mike
 */
public class Render2DProcess extends AbsGameProcess
{

    private GameWindow gw;
    private GameMenu gmu;
    private GameMap gm;
    private Dimension d;
    private ActorFactory af;

    @Override
    public void onInit()
    {
        d = new Dimension(600, 400);
        gw = new GameWindow(d);
        gm = new GameMap(d);
        gmu = new GameMenu(d);
        af = ActorFactory.getInstance();

        gm.setVisible(true);

        gw.addJPanel(gm);
        gw.setVisible(true);

        // Passes the game window to the actor factory so that controls can
        // be attached correctly.
        af.setCurrentGameWindow(gw);
        
        setState(State.RUNNING);
    }

    @Override
    public void onUpdate(long deltaMs)
    {
        if (gmu != null && gmu.isVisible())
        {
            gmu.repaint();
        }
        if (gm != null && gm.isVisible())
        {
            gm.repaint();
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
