/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import graphics2D.Map;

/**
 *
 * @author Mike
 */
public class CameraComponent extends BaseActorComponent implements IComponent{
    
    private Map map = null;

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String getType() {
        return "CameraComponent";
    }
    
}
