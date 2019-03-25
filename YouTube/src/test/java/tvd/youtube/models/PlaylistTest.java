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
import util.VideoStatus;

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
    
    @Test
    public void addVideo(){
        User u = new User("user1", "test", "test", LocalDate.now(), "user");
        Video v = new Video("playlist unittest", "video about unit testing", LocalDateTime.now(), u, VideoStatus.Public);
        Playlist p = new Playlist("Testlist",u);
        List<Video> fakeplaylist = new ArrayList<>();
        fakeplaylist.add(v);
        p.addVideo(v);
        assertEquals(fakeplaylist, p.getVideos());
    }
    
    
    
}
