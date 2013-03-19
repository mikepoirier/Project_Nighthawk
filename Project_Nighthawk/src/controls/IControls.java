/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import actors.Actor;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;

/**
 *
 * @author Mike
 */
public interface IControls
{
    public void setOwner(Actor owner);
    
    public KeyAdapter getControls();
}
