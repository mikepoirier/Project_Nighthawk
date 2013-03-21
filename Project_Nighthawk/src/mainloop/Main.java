/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainloop;

import javax.swing.JFrame;

/**
 *
 * @author Mike
 */
public class Main
{
    JFrame frame = new JFrame("Test World");
    TestWorld world = new TestWorld();
    
    public Main()
    {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(world);
    }
    
    public static void main(String[] args)
    {
        Main game = new Main();
    }
}
