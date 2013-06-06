/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import actors.Actor;
import gameView.GameWindow;

/**
 *
 * @author Mike
 */
public class AIControls extends BaseControls
{
    public AIControls()
    {
    }
    
    public AIControls(Actor a)
    {
        super.setOwner(a);
    }
    
    public AIControls(GameWindow gw)
    {
        
    }
}