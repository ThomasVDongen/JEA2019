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

    @Test
    public void testSubscribeTo() {
        User u = new User("user1", "test", "test", LocalDate.now(),Role.user);
        User u2 = new User("user2", "test2", "test2", LocalDate.now(), Role.user);
        u2.subscribeTo(u);
        List<User> testSubscribers = new ArrayList<>();
        testSubscribers.add(u2);
        assertEquals(testSubscribers, u.getSubscribers());
    }
    

    
    
}
