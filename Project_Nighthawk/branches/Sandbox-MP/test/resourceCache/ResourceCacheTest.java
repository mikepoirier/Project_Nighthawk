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

/**
 *
 * @author Mike
 */
public class ResourceCacheTest {
    
    public ResourceCacheTest() {
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
//     * Test of getInstance method, of class ResourceCache.
//     */
//    @Test
//    public void testGetInstance() {
//        System.out.println("getInstance");
//        ResourceCache expResult = null;
//        ResourceCache result = ResourceCache.getInstance();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of add method, of class ResourceCache.
//     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        Object key = null;
//        Object value = null;
//        ResourceCache instance = null;
//        instance.add(key, value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of get method, of class ResourceCache.
//     */
//    @Test
//    public void testGet() {
//        System.out.println("get");
//        Object key = null;
//        ResourceCache instance = null;
//        Object expResult = null;
//        Object result = instance.get(key);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of size method, of class ResourceCache.
//     */
//    @Test
//    public void testSize() {
//        System.out.println("size");
//        ResourceCache instance = null;
//        int expResult = 0;
//        int result = instance.size();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of clear method, of class ResourceCache.
//     */
//    @Test
//    public void testClear() {
//        System.out.println("clear");
//        ResourceCache instance = null;
//        boolean expResult = false;
//        boolean result = instance.clear();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of upload method, of class ResourceCache.
     */
//    @Test
//    public void testUpload() {
//        System.out.println("Upload Test:");
//        ResourceCache rc = ResourceCache.getInstance();
//        rc.setResourceLocation("../../Assets/Images");
//        rc.upload("SMikeWalk.zip");
//        rc.upload("SRobWalk.zip");
//        rc.upload("foo.zip");
//        System.out.println("Passed!\n");
//    }
    
    @Test
    public void testParseImages() {
        System.out.println("Parse Images Test:");
        ResourceCache rc = ResourceCache.getInstance();
        rc.setResourceLocation("../../Assets/Images");
        rc.upload("SMikeWalk.zip");
        rc.upload("SRobWalk.zip");
        rc.parseImages("SMikeWalk");
        rc.parseImages("SRobWalk");
        System.out.println("Passed!\n");
    }
}
