/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import graphics2D.Map;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mike
 */
public class BaseActorComponent implements IComponent{
    
    private int componentID;
    private Actor owner;
    private String type = "BaseComponent";

    public int getComponentID() {
        return componentID;
    }

    public void setComponentID(int componentID) {
        this.componentID = componentID;
    }

    public Actor getOwner() {
        return owner;
    }

    public void setOwner(Actor owner) {
        this.owner = owner;
    }
    
    @Override
    public String toString()
    {
        return "ID: " + componentID + ", Owner ID: " + owner.getmActorID();
    }

    @Override
    public String getType() {
        return type;
    }

    public int getX() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setX(int x) {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public int getY() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setY(int y) {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public Map getMap() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setMap(Map map) {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public String getImageZipLocation() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setImageZipLocation(String imageLocation) {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public String getAnimationLocation() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setAnimationLocation(String animationLocation) {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public BufferedImage[] getCharacterAnimation() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public void setCharacterAnimation(BufferedImage[] characterAnimation) {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }

    public BufferedImage getStillImage() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }
    
    public BufferedImage getAnimation() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }
    
    public boolean isAnimationEmpty() {
        throw new UnsupportedOperationException("Not supported. This is the base class, use the correct component to access the method.");
    }
}
