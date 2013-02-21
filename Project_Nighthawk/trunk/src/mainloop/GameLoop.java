/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainloop;

import graphics2D.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cody
 */
public class GameLoop extends Thread {
    private final Map map;
    private final GameLayout layout;
    
    public GameLoop(Map map, GameLayout layout) {
        this.map = map;
        this.layout = layout;
    }
    
    @Override
    public void run() {
        
        map.init();
        
        while (!map.isEnded()) {
            map.update();
            layout.repaint();
            try {
                Thread.sleep(map.getDelayTiming());
            } catch (InterruptedException ex) {
                Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
