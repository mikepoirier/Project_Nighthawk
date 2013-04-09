/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mike
 */
public class GameWindow extends JFrame
{
    
    Dimension d;
    String name;
    
    public GameWindow()
    {
        init();
    }
    
    public GameWindow(Dimension d)
    {
        this.d = d;
        init();
    }
    
    private void init()
    {
        d = new Dimension(600, 400);
        name = "Project Nighthawk";
        setSize(d);
        setTitle(name);
        setIgnoreRepaint(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addJPanel(JPanel panel)
    {
        add(panel);
        validate();
    }
    
}
