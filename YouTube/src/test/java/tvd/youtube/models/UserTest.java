/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.models;

import java.time.LocalDate;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        User instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = null;
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthday method, of class User.
     */
    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        User instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getBirthday();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirthday method, of class User.
     */
    @Test
    public void testSetBirthday() {
        System.out.println("setBirthday");
        LocalDate birthday = null;
        User instance = null;
        instance.setBirthday(birthday);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class User.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        User instance = null;
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class User.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        User instance = null;
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVideos method, of class User.
     */
    @Test
    public void testGetVideos() {
        System.out.println("getVideos");
        User instance = null;
        ArrayList<Video> expResult = null;
        ArrayList<Video> result = instance.getVideos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVideos method, of class User.
     */
    @Test
    public void testSetVideos() {
        System.out.println("setVideos");
        ArrayList<Video> videos = null;
        User instance = null;
        instance.setVideos(videos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlaylists method, of class User.
     */
    @Test
    public void testGetPlaylists() {
        System.out.println("getPlaylists");
        User instance = null;
        ArrayList<Playlist> expResult = null;
        ArrayList<Playlist> result = instance.getPlaylists();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlaylists method, of class User.
     */
    @Test
    public void testSetPlaylists() {
        System.out.println("setPlaylists");
        ArrayList<Playlist> playlists = null;
        User instance = null;
        instance.setPlaylists(playlists);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReactions method, of class User.
     */
    @Test
    public void testGetReactions() {
        System.out.println("getReactions");
        User instance = null;
        ArrayList<Reaction> expResult = null;
        ArrayList<Reaction> result = instance.getReactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReactions method, of class User.
     */
    @Test
    public void testSetReactions() {
        System.out.println("setReactions");
        ArrayList<Reaction> reactions = null;
        User instance = null;
        instance.setReactions(reactions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubscribed method, of class User.
     */
    @Test
    public void testGetSubscribed() {
        System.out.println("getSubscribed");
        User instance = null;
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getSubscribed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubscribed method, of class User.
     */
    @Test
    public void testSetSubscribed() {
        System.out.println("setSubscribed");
        ArrayList<User> subscribed = null;
        User instance = null;
        instance.setSubscribed(subscribed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubscribers method, of class User.
     */
    @Test
    public void testGetSubscribers() {
        System.out.println("getSubscribers");
        User instance = null;
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getSubscribers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubscribers method, of class User.
     */
    @Test
    public void testSetSubscribers() {
        System.out.println("setSubscribers");
        ArrayList<User> subscribers = null;
        User instance = null;
        instance.setSubscribers(subscribers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class User.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User u = null;
        User instance = null;
        instance.update(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
