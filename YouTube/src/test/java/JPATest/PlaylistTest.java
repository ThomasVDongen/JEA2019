/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPATest;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import tvd.youtube.DAO.PlaylistDAOJPA;
import tvd.youtube.DAO.ReactionDAOJPA;
import tvd.youtube.DAO.UserDAOJPA;
import tvd.youtube.DAO.VideoDAOJPA;
import tvd.youtube.models.Playlist;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import tvd.youtube.services.PlaylistService;
import tvd.youtube.services.ReactionService;
import tvd.youtube.services.UserService;
import tvd.youtube.services.VideoService;
import util.DatabaseCleaner;
import util.Role;
import util.VideoStatus;

/**
 *
 * @author Laptop_Thomas
 */
public class PlaylistTest {

    VideoDAOJPA videoDao;
    UserDAOJPA userDao;
    UserService userService;
    VideoService videoService;
    PlaylistService playlistService;
    PlaylistDAOJPA playlistDao;
    EntityManager em;
    EntityManagerFactory emf;

    @Test
    public void createPlaylist() {
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), Role.user);
        Video v = new Video("Video 1", "Video for test purposes only", LocalDateTime.now(), user, VideoStatus.Public);
        user.postVideo(v);
        Playlist p = new Playlist("Videos from user1", user);
        p.addVideo(v);
        user.createPlaylist(p);
        em.getTransaction().begin();
        userService.create(user);
        //videoService.create(v);
        em.getTransaction().commit();
        User test = userService.getUserByName("user1");
        List<Playlist> playlists = playlistService.getPlaylistsbyUser(test);
        em.close();
        emf.close();
        assertNotNull(playlists);

    }

    @Test
    public void editPlaylist() {
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), Role.user);
        Video v = new Video("video2", "Video for test purposes only", LocalDateTime.now(), user, VideoStatus.Public);
        user.postVideo(v);
        Playlist p = new Playlist("Videos from user1", user);
        p.addVideo(v);
        em.getTransaction().begin();
        userService.create(user);
        em.getTransaction().commit();
        em.getTransaction().begin();
        p.setName("test naam");
        playlistService.edit(p);
        em.getTransaction().commit();

        List<Playlist> playlists = playlistService.getPlaylistsbyUser(user);
        assertEquals("test naam", playlists.get(0).getName());

    }
    
     @Before
    public void cleanDatabase() {
        emf = Persistence.createEntityManagerFactory("YoutubeTestPU");
        em = emf.createEntityManager();
        videoDao = new VideoDAOJPA();
        userDao = new UserDAOJPA();
        playlistDao = new PlaylistDAOJPA();
        userService = new UserService();
        videoService = new VideoService();
        playlistService = new PlaylistService();
        videoDao.setEntityManager(em);
        userDao.setEntityManager(em);
        playlistDao.setEntityManager(em);
        videoService.setDAO(videoDao);
        userService.setDAO(userDao);
        playlistService.setDAO(playlistDao);
        
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
            Logger.getLogger(ReactionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
