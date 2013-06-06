/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import controls.AIControls;
import controls.IControls;
import controls.PlayerControls;
import gameView.GameWindow;
import javax.swing.JFrame;

/**
 *
 * @author Mike
 */
public class ControlsComponent extends BaseActorComponent implements IComponent
{
    private IControls controls;
    private final String TYPE = "ControlsComponent";
    
    public ControlsComponent(String actorType, GameWindow gw)
    {
        switch(actorType)
        {
            case "player":
                controls = new PlayerControls(gw);
                break;
            case "ai":
                controls = new AIControls(gw);
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
    
    /**
     * Moves the character.
     */
    @Override
    public void move()
    {
        // Tests to make sure that the controls have been attached to the correct
        // actor.
        if(controls.getOwner() == null)
        {
            controls.setOwner(this.getOwner());
        }
        
        // Moves the character
        controls.move();
    }
    
    @Override
    public void attachControls(JFrame game)
    {
        game.addKeyListener(controls.getControls());
    }
    
    @Override
    public void setControlsOwner(Actor owner)
    {
        controls.setOwner(super.getOwner());
    }
}