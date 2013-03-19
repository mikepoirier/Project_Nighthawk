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
public class BaseControls implements IControls
{
    Actor owner;
    private int x,y;

//    public Actor getActor()
//    {
//        return owner;
//    }

    @Override
    public void setOwner(Actor owner)
    {
        this.owner = owner;
    }
    
    protected void moveUp()
    {
        y = owner.getComponentMap().get("TransformComponent").getY();
        y--;
        owner.getComponentMap().get("TransformComponent").setY(y);
    }
    
    protected void moveDown()
    {
        y = owner.getComponentMap().get("TransformComponent").getY();
        y++;
        owner.getComponentMap().get("TransformComponent").setY(y);
    }
    
    protected void moveLeft()
    {
        x = owner.getComponentMap().get("TransformComponent").getX();
        x--;
        owner.getComponentMap().get("TransformComponent").setX(x);
    }
    
    protected void moveRight()
    {
        x = owner.getComponentMap().get("TransformComponent").getX();
        x++;
        owner.getComponentMap().get("TransformComponent").setY(x);
    }
    
    protected void resetImage()
    {
        owner.getComponentMap().get("Character2DRenderComponent").resetAnimation();
    }

//    @Override
//    public void attachControls(JFrame game)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public KeyAdapter getControls()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
