/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import utilities.MersenneTwisterFast;

/**
 *
 * @author Cody & Mike
 */
public class AIControlsOld implements Runnable {
    
    // I'm going to start changing this to work with the actor class until you
    // want to take over. -Mike
    
    Rectangle AI;
    
    int xDirection, yDirection;
    
    boolean resting = false;
    boolean shouldSetRandDir = true;
    
    public AIControlsOld(Rectangle r) {
        AI = r;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        if(AI != null)
            g.fillRect(AI.x, AI.y, AI.width, AI.height);
    }
    
    //Choose random direction
    public int chooseRandomDirection() {
        // I changed this to use the random generator that I included with the
        // engine.
        MersenneTwisterFast rand = new MersenneTwisterFast(System.nanoTime());
        int[] randDirections = new int[3];
        randDirections[0] = 0;
        randDirections[1] = 1;
        randDirections[2] = -1;
        int randChoice = rand.nextInt(3);
        return randDirections[randChoice];
    }
    //Move in that direction
    public void setXDirection(int dir) {
        xDirection = dir;
    }
    
    public void setYDirection(int dir) {
        yDirection = dir;
    }
    
    public void move(){
        AI.x += xDirection;
        AI.y += yDirection;
    }
    //In Run method, move in that direction and then wait
    @Override
    public void run() {
        try{
            while(true){
                if(!resting){
                    if(shouldSetRandDir) {
                        setXDirection(chooseRandomDirection());
                        setYDirection(chooseRandomDirection());
                        shouldSetRandDir = false;
                    }
                    long start = System.currentTimeMillis();
                    long end = start + 1*1000;
                    while(System.currentTimeMillis() < end) {
                        move();
                        Thread.sleep(10);
                    }
                    resting = true;
                }
                else{
                    Thread.sleep(3000);
                    shouldSetRandDir = true;
                    resting = false;
                }
            }
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}