/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import actors.Actor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mike
 */
public class PlayerControls extends BaseControls
{

    public PlayerControls()
    {
        
    }

    public PlayerControls(Actor owner)
    {
        super.setOwner(owner);
    }
//    public void attachControls(JFrame game)
//    {
//        game.addKeyListener(controls);
//    }
    KeyAdapter controls = new KeyAdapter()
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            switch (e.getKeyChar())
            {
                case 'Q':
                    System.out.println("\u001B[35mSystem Exiting! Goodbye.");
                    System.exit(0);
            }
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT)
            {
                movingLeft = true;
            }
            if (keyCode == KeyEvent.VK_RIGHT)
            {
                movingRight = true;
            }
            if (keyCode == KeyEvent.VK_UP)
            {
                movingUp = true;
            }
            if (keyCode == KeyEvent.VK_DOWN)
            {
                movingDown = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT)
            {
                movingLeft = false;
            }
            if (keyCode == KeyEvent.VK_RIGHT)
            {
                movingRight = false;
            }
            if (keyCode == KeyEvent.VK_UP)
            {
                movingUp = false;
            }
            if (keyCode == KeyEvent.VK_DOWN)
            {
                movingDown = false;
            }
        }
    };

    @Override
    public KeyAdapter getControls()
    {
        return controls;
    }
}