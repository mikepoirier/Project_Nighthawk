/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import java.awt.Graphics;
import java.awt.Image;
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
    private JFrame game;
    
    public Actor(int id, String type, JFrame game)
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
    
    public void update(JFrame game, Graphics g)
    {
        Image imageToUpdate = componentMap.get("Character2DRenderComponent").getAnimation();
        Integer xToUpdate = componentMap.get("TransformComponent").getX();
        int yToUpdate = this.componentMap.get("TransformComponent").getY();
        
        if(g == null)
        {
            return;
        }
        g.drawImage(imageToUpdate, xToUpdate, yToUpdate, game.getRootPane());
        //game.repaint();
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
