/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.models;

import java.time.LocalDateTime;
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
public class ReactionTest {
    
    public ReactionTest() {
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
     * Test of getText method, of class Reaction.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        Reaction instance = null;
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class Reaction.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "";
        Reaction instance = null;
        instance.setText(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSender method, of class Reaction.
     */
    @Test
    public void testGetSender() {
        System.out.println("getSender");
        Reaction instance = null;
        User expResult = null;
        User result = instance.getSender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSender method, of class Reaction.
     */
    @Test
    public void testSetSender() {
        System.out.println("setSender");
        User sender = null;
        Reaction instance = null;
        instance.setSender(sender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Reaction.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Reaction instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Reaction.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Reaction instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVideo method, of class Reaction.
     */
    @Test
    public void testGetVideo() {
        System.out.println("getVideo");
        Reaction instance = null;
        Video expResult = null;
        Video result = instance.getVideo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVideo method, of class Reaction.
     */
    @Test
    public void testSetVideo() {
        System.out.println("setVideo");
        Video video = null;
        Reaction instance = null;
        instance.setVideo(video);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class Reaction.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Reaction instance = null;
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime method, of class Reaction.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        LocalDateTime time = null;
        Reaction instance = null;
        instance.setTime(time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Reaction.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Reaction r = null;
        Reaction instance = null;
        instance.update(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
