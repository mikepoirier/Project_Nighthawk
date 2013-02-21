/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2D;

import javax.swing.JFrame;
import mainloop.*;

/**
 *
 * @author Mike & Cody
 */
public class View {

    static public void start(Map map) {
        JFrame frame = new JFrame(map.getGameName());
        frame.setSize(map.getWidth(), map.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameLayout layout = new GameLayout(map);
        frame.add(layout);
        frame.setVisible(true);
        GameLoop loop = new GameLoop(map, layout);
        loop.start();
    }
}
