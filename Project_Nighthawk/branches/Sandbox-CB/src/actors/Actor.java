/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mike
 */
public class Actor {
    
    private int mActorID;
    private String mType;
    private Map<String, BaseActorComponent> componentMap = new HashMap<>();
    
    public Actor(int id, String type)
    {
        mActorID = id;
        mType = type;
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
