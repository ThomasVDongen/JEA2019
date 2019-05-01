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
import tvd.youtube.DAO.UserDAOJPA;
import tvd.youtube.DAO.VideoDAOJPA;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import tvd.youtube.services.UserService;
import tvd.youtube.services.VideoService;
import util.VideoStatus;

/**
 *
 * @author Laptop_Thomas
 */
public class VideoTest {

    VideoDAOJPA videoDao;
    UserDAOJPA userDao;
    UserService userService;
    VideoService videoService;
    EntityManager em;
    EntityManagerFactory emf;

    public VideoTest() {

    }

    private void setupEntityManager() {
        emf = Persistence.createEntityManagerFactory("YoutubeTestPU");
        em = emf.createEntityManager();
        videoDao = new VideoDAOJPA();
        userDao = new UserDAOJPA();
        userService = new UserService();
        videoService = new VideoService();
        videoDao.setEntityManager(em);
        userDao.setEntityManager(em);
        videoService.setDAO(videoDao);
        userService.setDAO(userDao);
    }

    @Test
    public void createVideo() {
        setupEntityManager();
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), "user");
        Video v = new Video("Video 1", "Video for test purposes only", LocalDateTime.now(), user, VideoStatus.Public);
        user.postVideo(v);
        em.getTransaction().begin();
        userService.create(user);
        //videoService.create(v);
        em.getTransaction().commit();
        User test = userService.getUserByName("user1");
        List<Video> videos = videoService.getVideosByUser(test);
        em.close();
        emf.close();
        assertNotNull(videos);

    }
    
    @Test
    public void blockVideo(){
        setupEntityManager();
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), "user");
        Video v = new Video("video2", "Video for test purposes only", LocalDateTime.now(), user, VideoStatus.Public);
        user.postVideo(v);
        em.getTransaction().begin();
        userService.create(user);
        em.getTransaction().commit();
        em.getTransaction().begin();
        v.setStatus(VideoStatus.Blocked);
        videoService.edit(v);
        em.getTransaction().commit();
        
        List<Video> videos = videoService.getVideosByUser(user);
        assertEquals(VideoStatus.Blocked, videos.get(0).getStatus());
        
    }
}
