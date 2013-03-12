/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainloop;

import actors.Actor;
import actors.ActorFactory;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import resourceCache.ResourceCache;

/**
 *
 * @author Mike
 */
public class TestWorld extends JFrame implements Runnable {

//    Rectangle player = new Rectangle(30, 50, 25, 25);
    static ResourceCache rc;
    private ActorFactory af;
    private Actor player;
    private Image actorImage;
    private int x;
    private int y;
    private Rectangle object;
    private Image dbImage;
    private Graphics dbg;
    int xDirection, yDirection;

    public TestWorld() {
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(new TestWorld.AL());
    }
    
    public void init() {
        rc = ResourceCache.getInstance();
        af = ActorFactory.getInstance();
        rc.setResourceLocation("C:/Users/Mike/Documents/NetBeansProjects/Project_Nighthawk(Master)/Assets/Images");
        rc.upload("SMikeWalk.zip");
        rc.upload("SRobWalk.zip");
        player = af.createActor("C:/Users/Mike/Documents/NetBeansProjects/Project_Nighthawk(Master)/Assets/Actors/player_2D.xml");
        //object = new Rectangle(275, 175, 25, 25);
    }

    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    private void paintComponent(Graphics g) {
        g.setColor(Color.RED);
//        g.fillRect(player.x, player.y, player.width, player.height);
        
        g.drawImage(actorImage, x, y, rootPane);
        repaint();
    }

    public void move() {
        x = player.getComponentMap().get("TransformComponent").getX();
        y = player.getComponentMap().get("TransformComponent").getY();
        x += xDirection;
        y += yDirection;
        player.getComponentMap().get("TransformComponent").setX(x);
        player.getComponentMap().get("TransformComponent").setY(y);
        if (xDirection != 0 || yDirection != 0) {
            actorImage = player.getComponentMap().get(
                    "Character2DRenderComponent").getAnimation();
        } else {
            actorImage = player.getComponentMap().get(
                    "Character2DRenderComponent").getStillImage();
        }
    }

    public void setYDirection(int ydir) {
        yDirection = ydir;
    }

    public void setXDirection(int xdir) {
        xDirection = xdir;
    }

    public class AL extends KeyAdapter {
        
        @Override
        public void keyTyped(KeyEvent e)
        {
            switch (e.getKeyChar()) {
                case 'Q':
                    System.exit(0);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {
                setXDirection(-1);
            }
            if (keyCode == e.VK_RIGHT) {
                setXDirection(1);
            }
            if (keyCode == e.VK_UP) {
                setYDirection(-1);
            }
            if (keyCode == e.VK_DOWN) {
                setYDirection(1);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {
                setXDirection(0);
            }
            if (keyCode == e.VK_RIGHT) {
                setXDirection(0);
            }
            if (keyCode == e.VK_UP) {
                setYDirection(0);
            }
            if (keyCode == e.VK_DOWN) {
                setYDirection(0);
            }
        }
    }

    public static void main(String[] args) {
//        iu.init("../../Assets/Images");
        TestWorld main = new TestWorld();
        main.init();
        Thread t = new Thread(main);
        t.start();
//        Thread t1 = new Thread(AI);
//        t1.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                long lTime = System.nanoTime();
                move();
                lTime = System.nanoTime() - lTime;

                long lSleep = (long) (1000f / 60f) - (lTime / 1000000l);
                if (lSleep > 0) {
                    Thread.sleep(lSleep);
                } else {
                    System.out.println("Frame Rate Failure: " + lSleep);
                    lSleep = 0;
                }
                Thread.sleep(lSleep);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}