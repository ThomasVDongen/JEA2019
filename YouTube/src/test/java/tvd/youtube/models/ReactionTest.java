/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.Role;
import util.VideoStatus;

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
     * Test of react method, of class Reaction.
     */
    @Test
    public void testReact() {
        User u = new User("user1", "test", "test", LocalDate.now(), Role.user);
        Video v = new Video("How to test reactions", "description", LocalDateTime.now(), u, VideoStatus.Public);
        Reaction r = new Reaction("Ben het echt niet eens met deze mening", u, v);
        Reaction instance = new Reaction("Wat een mooie video", u, v);
        instance.react(r);
        List<Reaction> reactions = new ArrayList<>();
        reactions.add(r);
        assertEquals(reactions, instance.getReactions());
    }
    
}
