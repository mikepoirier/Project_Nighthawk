/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import gameView.GameWindow;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mike
 */
public class Actor {
    
    private int mActorID;
    private String mType, resource;
    private Map<String, BaseActorComponent> componentMap;
    private GameWindow game; // TODO: remove this and create a better way to get components to recognize the game window or what ever this does...
    
    public Actor(int id)
    {
        // TODO: create some sort of logging code and log the creation of an actor
        
        this.componentMap = new HashMap<>();
        this.mActorID = id;
        this.mType = "Unknown";
        this.resource = "Unknown";
    }
    
    protected void init()
    {
        switch(mType)
        {
            case "Character":
                this.componentMap.get("ControlsComponent").attachControls(game);// to be removed, figure out how to link to game window, probably different implementation of controls through game UI
                this.componentMap.get("ControlsComponent").setControlsOwner(this);
        }
    }
    
    protected void postInit()
    {
        //TODO: call postInit() on all components
    }
    
    public void destroy()
    {
        // TODO: Log this
        componentMap.clear();
    }
    
    public void update(long delta)
    {
        // TODO: redo the code here for more accurate updates, call update() on all components instead
        componentMap.get("ControlsComponent").move();
    }
    
    public String toXml()
    {
        // TODO: create an xml string from this actor instance so it can be saved out to a file.
        
        return null;
    }
    
    // TODO: put this somewhere else, not all actors will be drawn
    public void draw(Image offscreenImage)
    {
        Graphics2D g2d = (Graphics2D) offscreenImage.getGraphics();
        BufferedImage imageToUpdate = componentMap.get("Character2DRenderComponent").getCurrentImage();
        int xToDraw = componentMap.get("TransformComponent").getX();
        int yToDraw = componentMap.get("TransformComponent").getY();
        
        if(g2d == null)
        {
            System.out.println("\u001B[33mNull graphics passed.");
            return;
        }
        
        g2d.drawImage(imageToUpdate, xToDraw, yToDraw, game); // figure out where to put this/how to handle this once 'game' is removed
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    public int getmActorID() {
        return mActorID;
    }

    public String getmType() {
        return mType;
    }
    
    void addComponent(BaseActorComponent ac, String componentName)
    {
        // TODO: Log this
        ac.setOwner(this);
        componentMap.put(componentName, ac);
    }

    public Map<String, BaseActorComponent> getComponentMap() {
        return componentMap;
    }
    
    public BaseActorComponent getComponent(int id)
    {
        //TODO: find the component by the id
        return null;
    }
    
    public BaseActorComponent getComponent(String name)
    {
        // TODO: might switch how the map holds the components which might change this method
        return componentMap.get(name);
    }
    
    @Override
    public String toString()
    {
        return "Actor ID: " + mActorID + "\nActor Type: " + mType + 
                "\nComponents: " + componentMap.toString();
    }
    
}