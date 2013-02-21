/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2D;

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
public class ImageUploaderTest {
    
    public ImageUploaderTest() {
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
     * Test of init method, of class ImageUploader.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        String imagesDirectory = "../../Assets/Images";
        ImageUploader instance = ImageUploader.getInstance();
        instance.init(imagesDirectory);
        System.out.println(instance.getImages().keySet().toString());
    }
    
//    @Test
//    public void testParseZipFile() {
//        
//    }
}
