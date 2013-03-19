/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import graphics2D.ImageUploader;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Mike
 */
public class ActorFactoryTest {
    
    public ActorFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ImageUploader iu = ImageUploader.getInstance();
        iu.init("../../Assets/Images");
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Test of getInstance method, of class ActorFactory.
//     */
//    @Test
//    public void testGetInstance() {
//        System.out.println("getInstance");
//        ActorFactory instance = null;
//        ActorFactory expResult = null;
//        ActorFactory result = instance.getInstance();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of createActor method, of class ActorFactory.
     */
    @Test
    public void testCreateActor() {
        System.out.println("createActor Test:");
        String fileName = "../../Assets/Actors/player_2D.xml";
        ActorFactory instance = ActorFactory.getInstance();
        Actor actor = instance.createActor(null, fileName);
        System.out.println(actor.toString());
        System.out.println("Transform Component Details: " + actor.getComponentMap().get("TransformComponent").toString());
        Actor actor2 = instance.createActor(null, fileName);
        System.out.println(actor2.toString());
        System.out.println("Transform Component Details: " + actor2.getComponentMap().get("TransformComponent").toString());
        assertFalse(actor.getmActorID() == actor2.getmActorID());
        System.out.println("Passed!\n");
    }
}
