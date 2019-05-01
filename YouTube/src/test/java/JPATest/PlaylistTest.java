/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPATest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import tvd.youtube.DAO.PlaylistDAOJPA;
import tvd.youtube.DAO.UserDAOJPA;
import tvd.youtube.DAO.VideoDAOJPA;
import tvd.youtube.models.Playlist;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import tvd.youtube.services.PlaylistService;
import tvd.youtube.services.UserService;
import tvd.youtube.services.VideoService;
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

    private void setupEntityManager() {
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
    }
    
    
     @Test
    public void createPlaylist() {
        setupEntityManager();
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), "user");
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
        List<Playlist> playlists = playlistService.getPlaylistsbyUser(user);
        em.close();
        emf.close();
        assertNotNull(playlists);

    }
    
    @Test
    public void editPlaylist(){
        setupEntityManager();
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), "user");
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
}
