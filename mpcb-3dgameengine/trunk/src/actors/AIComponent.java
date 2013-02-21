/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import actors.IComponent;
/**
 *
 * @author Cody
 */

// This needs to be moved to the actors package because an AI will just be another
// instance of an actor with an AIComponent.
public class AIComponent implements IComponent{
    
    private int componentID;
    private Actor ownerAI;
    private String type = "BaseComponent";
    
    @Override
    public String toString()
    {
        return "ID: " + componentID + ", Owner " + ownerAI;
    }
    
    @Override
    public String getType() {
        return type;
    }
}
