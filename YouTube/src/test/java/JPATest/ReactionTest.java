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
import tvd.youtube.DAO.ReactionDAOJPA;
import tvd.youtube.DAO.UserDAOJPA;
import tvd.youtube.DAO.VideoDAOJPA;
import tvd.youtube.models.Reaction;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
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
public class ReactionTest {

    UserDAOJPA userdao;
    ReactionDAOJPA reactiondao;
    UserService userservice;
    VideoService videoService;
    VideoDAOJPA videoDAO;
    ReactionService reactionservice;
    EntityManager em;
    EntityManagerFactory emf;
    User user;
    
    
    @Test
    public void react() {
        user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27),Role.user);
        Video v = new Video("Video 1", "Video for test purposes only", LocalDateTime.now(), user, VideoStatus.Public);
        user.postVideo(v);
        Reaction r = new Reaction("what a great test", user, v);
        user.react(r, v);
        em.getTransaction().begin();
        userservice.create(user);
        em.getTransaction().commit();
        List<Reaction> reactions = reactionservice.getAllReactionsFromVideo(v.getId());
        em.close();
        emf.close();
        assertNotNull(reactions);
    }
    
    @Test
    public void editreaction(){
        user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), Role.user);
        Video v = new Video("video2", "Video for test purposes only", LocalDateTime.now(), user, VideoStatus.Public);
        user.postVideo(v);
        Reaction r = new Reaction("what a great test", user, v);
        user.react(r, v);
        em.getTransaction().begin();
        userservice.create(user);
        em.getTransaction().commit();
        em.getTransaction().begin();
        String teststring = "this test is going really well";
        r.setText(teststring);
        reactionservice.edit(r);
        em.getTransaction().commit();
        
        List<Reaction> reactions = reactionservice.getAllReactionsFromVideo(v.getId());
        assertEquals(teststring, reactions.get(0).getText());
    }

    @Before
    public void cleanDatabase() {
        emf = Persistence.createEntityManagerFactory("YoutubeTestPU");
        em = emf.createEntityManager();
        userdao = new UserDAOJPA();
        reactiondao = new ReactionDAOJPA();
        videoDAO = new VideoDAOJPA();
        reactionservice = new ReactionService();
        userservice = new UserService();
        videoService = new VideoService();
        videoDAO.setEntityManager(em);
        reactiondao.setEntityManager(em);
        userdao.setEntityManager(em);
        userservice.setDAO(userdao);
        reactionservice.setDAO(reactiondao);
        videoService.setDAO(videoDAO);
        reactionservice.setVideoService(videoService);
        
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
            Logger.getLogger(ReactionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
