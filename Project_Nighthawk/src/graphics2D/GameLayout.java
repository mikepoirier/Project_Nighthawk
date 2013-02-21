/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2D;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Cody
 */
public class GameLayout extends JComponent {
    private final Map map;
    
    public GameLayout(Map map) {
        this.map = map;
        addKeyListener(this.map);
        addMouseListener(this.map);
        addMouseMotionListener(this.map);
        requestFocus();
    }
    
    public void paintComponent(Graphics g) {
        map.draw(g);
    }
}
