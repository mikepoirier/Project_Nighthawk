/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import actors.Actor;
import java.awt.event.KeyAdapter;

/**
 *
 * @author Mike
 */
public interface IControls
{
    public void setOwner(Actor owner);
    
    public Actor getOwner();
    
    public KeyAdapter getControls();
    
    public void move();
}