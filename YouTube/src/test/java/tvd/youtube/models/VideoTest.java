/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laptop_Thomas
 */
public class VideoTest {
    
    public VideoTest() {
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
     * Test of getId method, of class Video.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Video instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Video.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Video instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Video.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Video instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Video.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Video instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Video.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Video instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Video.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Video instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUploadTime method, of class Video.
     */
    @Test
    public void testGetUploadTime() {
        System.out.println("getUploadTime");
        Video instance = null;
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getUploadTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUploadTime method, of class Video.
     */
    @Test
    public void testSetUploadTime() {
        System.out.println("setUploadTime");
        LocalDateTime uploadTime = null;
        Video instance = null;
        instance.setUploadTime(uploadTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReactions method, of class Video.
     */
    @Test
    public void testGetReactions() {
        System.out.println("getReactions");
        Video instance = null;
        ArrayList<Reaction> expResult = null;
        ArrayList<Reaction> result = instance.getReactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReactions method, of class Video.
     */
    @Test
    public void testSetReactions() {
        System.out.println("setReactions");
        ArrayList<Reaction> reactions = null;
        Video instance = null;
        instance.setReactions(reactions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
