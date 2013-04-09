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
    private int x,
            y,
            xDirection,
            yDirection;
    boolean movingLeft = false,
            movingRight = false,
            movingUp = false,
            movingDown = false;

    public void attachControls(JFrame game)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KeyAdapter getControls()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void move()
    {
        applyDirection();
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
        } catch (Exception e)
        {
            System.err.println("Localized message: " + e.getLocalizedMessage());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     *  Sets the animation direction based on the controls input
     */
    public void applyDirection()
    {
        // Neutralizes simultaneous commands from left and right and if neither
        // are pressed.
        
        if (movingLeft && movingRight)
        {
            xDirection = 0;
            return;
        }

        // Neutralizes simultaneous commands from up and down and if neither
        // are pressed.
        
        if (movingUp && movingDown)
        {
            yDirection = 0;
            return;
        }
        
        // Applies the appropriate direction

        if (movingLeft)
        {
            System.out.println("Moving Left");
            xDirection = -1;
        }
        if (movingRight)
        {
            System.out.println("Moving Right");
            xDirection = 1;
        }

        if (movingUp)
        {
            System.out.println("Moving Up");
            yDirection = -1;
        }
        if (movingDown)
        {
            System.out.println("Moving Down");
            yDirection = 1;
        }
        
        if (!movingLeft && !movingRight)
        {
            xDirection = 0;
        }
        
        if (!movingUp && !movingDown)
        {
            yDirection = 0;
        }
    }

    @Override
    public void setOwner(Actor owner)
    {
        this.owner = owner;
    }
}