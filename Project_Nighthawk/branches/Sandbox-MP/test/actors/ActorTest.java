/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import java.util.Map;
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
public class ActorTest {
    
    public ActorTest() {
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

    /**
     * Test of getmActorID method, of class Actor.
     */
    @Test
    public void testGetmActorID() {
        System.out.println("getmActorID");
        Actor instance = null;
        int expResult = 0;
        int result = instance.getmActorID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setmActorID method, of class Actor.
     */
    @Test
    public void testSetmActorID() {
        System.out.println("setmActorID");
        int mActorID = 0;
        Actor instance = null;
        instance.setmActorID(mActorID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getmType method, of class Actor.
     */
    @Test
    public void testGetmType() {
        System.out.println("getmType");
        Actor instance = null;
        String expResult = "";
        String result = instance.getmType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setmType method, of class Actor.
     */
    @Test
    public void testSetmType() {
        System.out.println("setmType");
        String mType = "";
        Actor instance = null;
        instance.setmType(mType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addComponent method, of class Actor.
     */
    @Test
    public void testAddComponent() {
        System.out.println("addComponent");
        BaseActorComponent ac = null;
        String componentName = "";
        Actor instance = null;
        instance.addComponent(ac, componentName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComponentMap method, of class Actor.
     */
    @Test
    public void testGetComponentMap() {
        System.out.println("getComponentMap");
        Actor instance = null;
        Map expResult = null;
        Map result = instance.getComponentMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Actor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Actor instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
