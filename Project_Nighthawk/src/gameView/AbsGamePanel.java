/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Mike
 */
public abstract class AbsGamePanel extends JPanel
{
    Dimension d;
    BufferedImage offscreen;
    Graphics bufferGraphics;
    
    protected void init(Dimension d)
    {
        if(d == null)
        {
            d = new Dimension(600, 400);
        }
        this.d = d;
        setPreferredSize(d);
        setDoubleBuffered(true);
        setIgnoreRepaint(true);
        setBackground(Color.GRAY);
        offscreen = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
        bufferGraphics = offscreen.getGraphics();
    }
    
    @Override
    public void update(Graphics g)
    {
        paint(g);
    }
    
    @Override
    public abstract void paint(Graphics g);

    public Dimension getD()
    {
        return d;
    }

    public void setDimention(Dimension d)
    {
        this.d = d;
    }
}
