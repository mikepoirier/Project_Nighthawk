/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.MersenneTwisterFast;

/**
 *
 * @author Mike
 */
public class MersenneTwisterFastTest {
    
    public MersenneTwisterFastTest() {
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
//     * Test of clone method, of class MersenneTwisterFast.
//     */
//    @Test
//    public void testClone() {
//        System.out.println("clone");
//        MersenneTwisterFast instance = new MersenneTwisterFast();
//        Object expResult = null;
//        Object result = instance.clone();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stateEquals method, of class MersenneTwisterFast.
//     */
//    @Test
//    public void testStateEquals() {
//        System.out.println("stateEquals");
//        Object o = null;
//        MersenneTwisterFast instance = new MersenneTwisterFast();
//        boolean expResult = false;
//        boolean result = instance.stateEquals(o);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of readState method, of class MersenneTwisterFast.
//     */
//    @Test
//    public void testReadState() throws Exception {
//        System.out.println("readState");
//        DataInputStream stream = null;
//        MersenneTwisterFast instance = new MersenneTwisterFast();
//        instance.readState(stream);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of writeState method, of class MersenneTwisterFast.
//     */
//    @Test
//    public void testWriteState() throws Exception {
//        System.out.println("writeState");
//        DataOutputStream stream = null;
//        MersenneTwisterFast instance = new MersenneTwisterFast();
//        instance.writeState(stream);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setSeed method, of class MersenneTwisterFast.
//     */
//    @Test
//    public void testSetSeed_long() {
//        System.out.println("setSeed");
//        long seed = 0L;
//        MersenneTwisterFast instance = new MersenneTwisterFast();
//        instance.setSeed(seed);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setSeed method, of class MersenneTwisterFast.
//     */
//    @Test
//    public void testSetSeed_intArr() {
//        System.out.println("setSeed");
//        int[] array = null;
//        MersenneTwisterFast instance = new MersenneTwisterFast();
//        instance.setSeed(array);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of nextInt method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextInt_0args() {
        System.out.println("nextInt Test:");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        int result1 = rand.nextInt();
        int result2 = rand.nextInt();
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextShort method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextShort() {
        System.out.println("nextShort");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        short result1 = rand.nextShort();
        short result2 = rand.nextShort();
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextChar method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextChar() {
        System.out.println("nextChar");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        char result1 = rand.nextChar();
        char result2 = rand.nextChar();
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextBoolean method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextBoolean_0args() {
        System.out.println("nextBoolean()");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        boolean result1 = rand.nextBoolean();
        boolean result2 = rand.nextBoolean();
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextBoolean method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextBoolean_float() {
        System.out.println("nextBoolean(Float)");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        boolean result1 = rand.nextBoolean(1.0f);
        boolean result2 = rand.nextBoolean(0.0f);
        boolean result3 = rand.nextBoolean(0.5f);
        assertTrue("Failed!", result1);
        assertFalse("Failed!", result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextBoolean method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextBoolean_double() {
        System.out.println("nextBoolean(Double)");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        boolean result1 = rand.nextBoolean(1.0d);
        boolean result2 = rand.nextBoolean(0.0d);
        boolean result3 = rand.nextBoolean(0.5d);
        assertTrue("Failed!", result1);
        assertFalse("Failed!", result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextByte method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextByte() {
        System.out.println("nextByte");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        byte result1 = rand.nextByte();
        byte result2 = rand.nextByte();
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

//    /**
//     * Test of nextBytes method, of class MersenneTwisterFast.
//     */
//    @Test
//    public void testNextBytes() {
//        System.out.println("nextBytes");
//        MersenneTwisterFast rand = new MersenneTwisterFast();
//        int result1 = rand.nextInt();
//        int result2 = rand.nextInt();
//        assertTrue(result1 != result2);
//        System.out.println("Result 1: " + result1);
//        System.out.println("Result 2: " + result2);
//        System.out.println("Passed!\n");
//    }

    /**
     * Test of nextLong method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextLong_0args() {
        System.out.println("nextLong()");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        long result1 = rand.nextLong();
        long result2 = rand.nextLong();
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextLong method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextLong_long() {
        System.out.println("nextLong(long)");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        long result1 = rand.nextLong(4223372036854775807l);
        long result2 = rand.nextLong(4223372036854775807l);
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextDouble method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextDouble_0args() {
        System.out.println("nextDouble()");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        double result1 = rand.nextDouble();
        double result2 = rand.nextDouble();
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextDouble method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextDouble_boolean_boolean() {
        System.out.println("nextDouble(Boolean, Boolean)");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        double result1 = rand.nextDouble(true, true);
        double result2 = rand.nextDouble(false, false);
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextGaussian method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextGaussian() {
        System.out.println("nextGaussian");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        double result1 = rand.nextGaussian();
        double result2 = rand.nextGaussian();
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextFloat method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextFloat_0args() {
        System.out.println("nextFloat()");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        float result1 = rand.nextFloat();
        float result2 = rand.nextFloat();
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextFloat method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextFloat_boolean_boolean() {
        System.out.println("nextFloat(boolean, boolean)");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        float result1 = rand.nextFloat(true, true);
        float result2 = rand.nextFloat(false, false);
        assertTrue("Failed!", result1 != result2);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

    /**
     * Test of nextInt method, of class MersenneTwisterFast.
     */
    @Test
    public void testNextInt_int() {
        System.out.println("nextInt(int)");
        MersenneTwisterFast rand = new MersenneTwisterFast();
        int result1 = rand.nextInt(1);
        int result2 = rand.nextInt(101);
        assertTrue("Failed!", result1 == 0);
        assertTrue("Failed!", result1 < 101);
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Passed!\n");
    }

//    /**
//     * Test of main method, of class MersenneTwisterFast.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        MersenneTwisterFast.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
