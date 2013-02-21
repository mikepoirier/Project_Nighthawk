/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2D;

import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mike
 */
public class AnimationTest {
    
    public AnimationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Test of getImages method, of class Animation.
//     */
//    @Test
//    public void testGetImages() {
//        System.out.println("getImages");
//        Animation instance = new Animation();
//        BufferedImage[] expResult = null;
//        BufferedImage[] result = instance.getImages();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addImages method, of class Animation.
     */
    @Test
    public void testAddImages() {
        System.out.println("addImages");
        String fileName = "../../Assets/Images/SMikeWalk.zip";
        Animation instance = new Animation();
        instance.addImages(fileName);
    }
}
