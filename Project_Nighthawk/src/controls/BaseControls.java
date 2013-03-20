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
    private int x, y, xDirection, yDirection;

//    public Actor getActor()
//    {
//        return owner;
//    }
    @Override
    public void setOwner(Actor owner)
    {
        this.owner = owner;
    }

    protected void moveUp(int distance)
    {
        yDirection = distance;
        move();
    }

    protected void moveDown(int distance)
    {
        yDirection = distance;
        move();
    }

    protected void moveLeft(int distance)
    {
        xDirection = distance;
        move();
    }

    protected void moveRight(int distance)
    {
        xDirection = distance;
        move();
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

    public void move()
    {
        try
        {
            x = owner.getComponentMap().get("TransformComponent").getX();
            y = owner.getComponentMap().get("TransformComponent").getY();
            x += xDirection;
            y += yDirection;
            owner.getComponentMap().get("TransformComponent").setX(x);
            owner.getComponentMap().get("TransformComponent").setY(y);

            if (xDirection != 0 || yDirection != 0)
            {
                owner.getComponentMap().get("Character2DRenderComponent").animate();
            }
            else
            {
                owner.getComponentMap().get("Character2DRenderComponent").resetAnimation();
            }
        }
        catch(Exception e)
        {
            System.err.println("Localized message: " + e.getLocalizedMessage());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();          
        }
    }
}
