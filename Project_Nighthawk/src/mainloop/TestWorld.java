/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainloop;

import actors.Actor;
import actors.ActorFactory;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JFrame;
import resourceCache.ResourceCache;

/**
 *
 * @author Mike
 */
public class TestWorld extends JFrame implements Runnable
{

//    Rectangle player = new Rectangle(30, 50, 25, 25);
    static ResourceCache rc;
    private ActorFactory af;
    private Actor player;
    private Image actorImage;
    private int x;
    private int y;
    private Rectangle object;
    private Image dbImage;
    private Graphics dbg, gameGraphics;
    //int xDirection, yDirection;

    public TestWorld()
    {
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //addKeyListener(new TestWorld.AL());
    }

    public void init()
    {
        rc = ResourceCache.getInstance();
        af = ActorFactory.getInstance();
        rc.setResourceLocation("../Assets/Images");
        rc.upload("SMikeWalk.zip");
        rc.upload("SRobWalk.zip");
        player = af.createActor(this, "../Assets/Actors/player_2D.xml");
        //object = new Rectangle(275, 175, 25, 25);
    }

    @Override
    public void paint(Graphics g)
    {
        this.gameGraphics = g;
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    private void paintComponent(Graphics g)
    {
//        g.setColor(Color.RED);
//        g.fillRect(player.x, player.y, player.width, player.height);
        updatePlayers(g);
        //g.drawImage(actorImage, x, y, rootPane);
        repaint();
    }

//    public void move()
//    {
//        x = player.getComponentMap().get("TransformComponent").getX();
//        y = player.getComponentMap().get("TransformComponent").getY();
//        x += xDirection;
//        y += yDirection;
//        player.getComponentMap().get("TransformComponent").setX(x);
//        player.getComponentMap().get("TransformComponent").setY(y);
//        if (xDirection != 0 || yDirection != 0)
//        {
//            actorImage = player.getComponentMap().get(
//                    "Character2DRenderComponent").getAnimation();
//        }
//        else
//        {
//            actorImage = player.getComponentMap().get(
//                    "Character2DRenderComponent").getStillImage();
//        }
//    }
//
//    public void setYDirection(int ydir)
//    {
//        yDirection = ydir;
//    }
//
//    public void setXDirection(int xdir)
//    {
//        xDirection = xdir;
//    }
//
//    public class AL extends KeyAdapter
//    {
//
//        @Override
//        public void keyTyped(KeyEvent e)
//        {
//            switch (e.getKeyChar())
//            {
//                case 'Q':
//                    System.exit(0);
//            }
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e)
//        {
//            int keyCode = e.getKeyCode();
//            if (keyCode == e.VK_LEFT)
//            {
//                setXDirection(-1);
//            }
//            if (keyCode == e.VK_RIGHT)
//            {
//                setXDirection(1);
//            }
//            if (keyCode == e.VK_UP)
//            {
//                setYDirection(-1);
//            }
//            if (keyCode == e.VK_DOWN)
//            {
//                setYDirection(1);
//            }
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e)
//        {
//            int keyCode = e.getKeyCode();
//            if (keyCode == e.VK_LEFT)
//            {
//                setXDirection(0);
//            }
//            if (keyCode == e.VK_RIGHT)
//            {
//                setXDirection(0);
//            }
//            if (keyCode == e.VK_UP)
//            {
//                setYDirection(0);
//            }
//            if (keyCode == e.VK_DOWN)
//            {
//                setYDirection(0);
//            }
//        }
//    }
    public static void main(String[] args)
    {
        TestWorld main = new TestWorld();
        main.init();
        Thread t = new Thread(main);
        t.start();
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                long lTime = System.nanoTime();
                updatePlayers(gameGraphics);
                lTime = System.nanoTime() - lTime;

                long lSleep = (long) (1000f / 60f) - (lTime / 1000000l);
                if (lSleep > 0)
                {
                    Thread.sleep(lSleep);
                }
                else
                {
                    System.out.println("Frame Rate Failure: " + lSleep);
                    lSleep = 0;
                }
                Thread.sleep(lSleep);
            }
        } catch (Exception e)
        {
            System.err.println("Error in the run method in TestWorld.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void updatePlayers(Graphics g)
    {
        List<Actor> actors = af.getActorList();
        for (Actor current : actors)
        {
            current.update(this, g);
        }
        repaint();
    }
}