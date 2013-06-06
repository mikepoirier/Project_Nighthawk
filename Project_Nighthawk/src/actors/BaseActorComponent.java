/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Mike
 */
public class BaseActorComponent implements IComponent
{

    private int componentID;
    private Actor owner;
    private String type = "BaseComponent";

    public int getComponentID()
    {
        return componentID;
    }

    public void setComponentID(int componentID)
    {
        this.componentID = componentID;
    }

    public Actor getOwner()
    {
        return owner;
    }

    public void setOwner(Actor owner)
    {
        this.owner = owner;
    }

    @Override
    public String toString()
    {
        return "ID: " + componentID + ", Owner ID: " + owner.getmActorID();
    }

    @Override
    public String getType()
    {
        return type;
    }

    public synchronized int getX()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public synchronized void setX(int x)
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public synchronized int getY()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public synchronized void setY(int y)
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public String getImageZipLocation()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setImageZipLocation(String imageLocation)
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public String getAnimationLocation()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setAnimationLocation(String animationLocation)
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public BufferedImage[] getCharacterAnimation()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setCharacterAnimation(BufferedImage[] characterAnimation)
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public BufferedImage getStillImage()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public BufferedImage getAnimation()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public boolean isAnimationEmpty()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void attachControls(JFrame game)
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setControlsOwner(Actor owner)
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void resetAnimation()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void animate()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public BufferedImage getCurrentImage()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void move()
    {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }
}