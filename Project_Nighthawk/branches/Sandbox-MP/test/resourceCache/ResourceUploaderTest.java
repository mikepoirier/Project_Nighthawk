/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceCache;

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
public class ResourceUploaderTest {
    
    public ResourceUploaderTest() {
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
//     * Test of getInstance method, of class ResourceUploader.
//     */
//    @Test
//    public void testGetInstance() {
//        System.out.println("getInstance");
//        ResourceUploader expResult = null;
//        ResourceUploader result = ResourceUploader.getInstance();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of upload method, of class ResourceUploader.
     */
    @Test
    public void testUpload() {
        System.out.println("Upload Test:");
        ResourceUploader ru = ResourceUploader.getInstance();
        ru.setResourceLocation("../../Assets/Images");
        ru.upload("SMikeWalk.zip");
        System.out.println("Passed!\n");
    }

//    /**
//     * Test of setResourceLocation method, of class ResourceUploader.
//     */
//    @Test
//    public void testSetResourceLocation() {
//        System.out.println("setResourceLocation");
//        String resourceLocation = "";
//        ResourceUploader instance = null;
//        instance.setResourceLocation(resourceLocation);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
