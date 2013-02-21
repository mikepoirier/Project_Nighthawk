/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2D;

import actors.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Mike & Cody
 */
abstract public class Map implements KeyListener, MouseListener, MouseMotionListener{
    
    protected int width;
    protected int height;
    protected int delayTiming;
    protected String gameName;
    protected boolean ended;
    
    // I think we should use this instead of a List because this way, we can get
    // a specific actor out of the map if we need to.  If we need to iterate
    // through it, we can call actorMap.values().iterator();
    // The values() returns a Collection of the Actors in the Map if you needed
    // that for some reason.
    java.util.Map<String, Actor> actorMap = new HashMap<>();
    BufferedImage background = null;
    
    // We'll need to change this to work with our Image Uploader
    public Map (int width, int height, String backGroundLocation) throws IOException {
        this.width = width;
        this.height = height;
        this.background = ImageIO.read(getClass().getResource(backGroundLocation));
    }
    
    public int getDelayTiming() {
        return delayTiming;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public String getGameName() {
        return gameName;
    }
    
    public void setDelayTiming(int delayTiming){
        this.delayTiming = delayTiming;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setGameName(String heading) {
        this.gameName = heading;
    }
    
    public boolean isEnded() {
        return ended;
    }
    abstract public void init();
    abstract public void update();
    abstract public void draw(Graphics g);
    
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public void mouseDragged(MouseEvent e) {
    }
    
    public void mouseMoved(MouseEvent e) {
    }
}
