/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import controls.AIControls;
import controls.IControls;
import controls.PlayerControls;
import javax.swing.JFrame;

/**
 *
 * @author Mike
 */
public class ControlsComponent extends BaseActorComponent implements IComponent
{
    IControls controls;
    private final String TYPE = "ControlsComponent";
    
    public ControlsComponent(String actorType)
    {
        switch(actorType)
        {
            case "player":
                controls = new PlayerControls();
                //game.addKeyListener(controls.getControls());
                break;
            case "ai":
                controls = new AIControls();
                break;
            default:
                System.err.println("Could not find controls for \"" + actorType +
                        "\". Please specify a valid actor type.");
                break;
        }
                
    }
    
    @Override
    public String getType()
    {
        return TYPE;
    }
    
    @Override
    public void attachControls(JFrame game)
    {
        game.addKeyListener(controls.getControls());
    }
    
    public void setControlsOwner(Actor owner)
    {
        controls.setOwner(super.getOwner());
    }
}
