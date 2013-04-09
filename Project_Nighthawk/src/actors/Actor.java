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
import javax.swing.JFrame;

/**
 *
 * @author Mike
 */
public class Actor {
    
    private int mActorID;
    private String mType;
    private Map<String, BaseActorComponent> componentMap = new HashMap<>();
    private GameWindow game;
    
    public Actor(int id, String type, GameWindow game)
    {
        mActorID = id;
        mType = type;
        this.game = game;
    }
    
    protected void init()
    {
        switch(mType)
        {
            case "Character":
                this.componentMap.get("ControlsComponent").attachControls(game);
                this.componentMap.get("ControlsComponent").setControlsOwner(this);
        }
    }
    
    public void update()
    {
        componentMap.get("ControlsComponent").move();
    }
    
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
        
        g2d.drawImage(imageToUpdate, xToDraw, yToDraw, game);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    public int getmActorID() {
        return mActorID;
    }

    public void setmActorID(int mActorID) {
        this.mActorID = mActorID;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }
    
    void addComponent(BaseActorComponent ac, String componentName)
    {
        ac.setOwner(this);
        componentMap.put(componentName, ac);
    }

    public Map<String, BaseActorComponent> getComponentMap() {
        return componentMap;
    }
    
    @Override
    public String toString()
    {
        return "Actor ID: " + mActorID + "\nActor Type: " + mType + 
                "\nComponents: " + componentMap.toString();
    }
    
}
