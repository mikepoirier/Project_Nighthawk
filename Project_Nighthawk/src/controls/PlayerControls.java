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
                    System.exit(0);
            }
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT)
            {
                moveLeft(-1);
            }
            if (keyCode == e.VK_RIGHT)
            {
                moveRight(1);
            }
            if (keyCode == e.VK_UP)
            {
                moveUp(-1);
            }
            if (keyCode == e.VK_DOWN)
            {
                moveDown(1);
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT)
            {
                moveLeft(0);
            }
            if (keyCode == KeyEvent.VK_RIGHT)
            {
                moveRight(0);
            }
            if (keyCode == KeyEvent.VK_UP)
            {
                moveUp(0);
            }
            if (keyCode == KeyEvent.VK_DOWN)
            {
                moveDown(0);
            }
        }
    };

    @Override
    public KeyAdapter getControls()
    {
        return controls;
    }
}
