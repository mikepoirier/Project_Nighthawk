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
import javax.swing.JPanel;
import resourceCache.ResourceCache;

/**
 *
 * @author Mike
 */
public class TestWorld extends JPanel implements Runnable
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
//        setResizable(false);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        player = af.createActor(new JFrame(), "../Assets/Actors/player_2D.xml");
        //object = new Rectangle(275, 175, 25, 25);
    }

//    @Override
//    public void paint(Graphics g)
//    {
//        this.gameGraphics = g;
//        dbImage = createImage(getWidth(), getHeight());
//        dbg = dbImage.getGraphics();
//        paintComponent(dbg);
//        g.drawImage(dbImage, 0, 0, this);
//    }
//
//    private void paintComponent(Graphics g)
//    {
//        updatePlayers(g);
//        repaint();
//    }

    

    @Override
    public void run()
    {
        try
        {
            this.gameGraphics = this.getGraphics();
            dbImage = createImage(getWidth(), getHeight());
            dbg = dbImage.getGraphics();
//            paintComponent(dbg);
            gameGraphics.drawImage(dbImage, 0, 0, this);
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
            current.update(new JFrame(), g);
        }
        repaint();
    }
}