/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;
/**
 *
 * @author Cody
 */
public class AIComponent extends BaseActorComponent implements IComponent{
    
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
