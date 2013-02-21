/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.Collection;
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
public class CacheTest {
    
    public CacheTest() {
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
     * Test of get method, of class Cache.
     */
    @Test
    public void testGet() {
        System.out.println("*cache.get(K) test*");
        Cache<String, Integer> cache = new Cache(2);
        cache.put("One", 1);
        cache.put("Two", 2);
        int result = cache.get("One");
        assertTrue("Failed! First result does not equal expected.\n", result == 1);
        result = cache.get("Two");
        assertTrue("Failed! Second result does not equal expected.\n", result == 2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of put method, of class Cache.
     */
    @Test
    public void testPut() {
        System.out.println("*cache.put(K,V) test*");
        Cache<String, Integer> cache = new Cache(2);
        cache.put("One", 1);
        cache.put("Two", 2);
        int result = cache.get("One");
        assertTrue("Failed! First result does not equal expected.\n", result == 1);
        result = cache.get("Two");
        assertTrue("Failed! Second result does not equal expected.\n", result == 2);
        System.out.println(cache.getAll());
        System.out.println("Passed test within cache capacity.");
        cache.put("Three", 3);
        assertNull("Failed! Last used entry was not removed.\n", cache.get("One"));
        assertTrue("Failed! Entry does not exist in cache.\n", cache.get("Two") == 2);
        assertTrue("Failed! Entry does not exist in cache.\n", cache.get("Three") == 3);
        System.out.println(cache.getAll());
        System.out.println("Passed test outside cache capacity.");
        System.out.println("Passed!\n");
    }

    /**
     * Test of clear method, of class Cache.
     */
    @Test
    public void testClear() {
        System.out.println("*cache.clear() test*");
        Cache<String, Integer> cache = new Cache(2);
        cache.put("One", 1);
        cache.put("Two", 2);
        int result = cache.get("One");
        assertTrue("Failed! First result does not equal expected.\n", result == 1);
        result = cache.get("Two");
        assertTrue("Failed! Second result does not equal expected.\n", result == 2);
        cache.clear();
        assertTrue("Failed! Cache was not cleared.\n", cache.size() == 0);
        System.out.println("Passed!\n");
    }

    /**
     * Test of size method, of class Cache.
     */
    @Test
    public void testSize() {
        System.out.println("*cache.size() test*");
        Cache<String, Integer> cache = new Cache(2);
        cache.put("One", 1);
        cache.put("Two", 2);
        assertTrue("Failed! Cache size does not equal expected.\n", cache.size() == 2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of getAll method, of class Cache.
     */
    @Test
    public void testGetAll() {
        System.out.println("*cache.getAll() test*");
        Cache<String, Integer> cache = new Cache(2);
        cache.put("One", 1);
        cache.put("Two", 2);
        assertNotNull("Failed! Cache contents do not equal expected.\n", cache.getAll());
        System.out.println("Passed!\n");
    }
}
