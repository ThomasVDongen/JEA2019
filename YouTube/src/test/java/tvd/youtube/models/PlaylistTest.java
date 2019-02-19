/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.models;

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
public class PlaylistTest {
    
    public PlaylistTest() {
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
     * Test of getId method, of class Playlist.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Playlist instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Playlist.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Playlist instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Playlist.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Playlist instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Playlist.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Playlist instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVideos method, of class Playlist.
     */
    @Test
    public void testGetVideos() {
        System.out.println("getVideos");
        Playlist instance = null;
        ArrayList<Video> expResult = null;
        ArrayList<Video> result = instance.getVideos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVideos method, of class Playlist.
     */
    @Test
    public void testSetVideos() {
        System.out.println("setVideos");
        ArrayList<Video> videos = null;
        Playlist instance = null;
        instance.setVideos(videos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreator method, of class Playlist.
     */
    @Test
    public void testGetCreator() {
        System.out.println("getCreator");
        Playlist instance = null;
        User expResult = null;
        User result = instance.getCreator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreator method, of class Playlist.
     */
    @Test
    public void testSetCreator() {
        System.out.println("setCreator");
        User creator = null;
        Playlist instance = null;
        instance.setCreator(creator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Playlist.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Playlist p = null;
        Playlist instance = null;
        instance.update(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
