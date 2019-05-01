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
import tvd.youtube.DAO.ReactionDAOJPA;
import tvd.youtube.DAO.UserDAOJPA;
import tvd.youtube.models.Reaction;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import tvd.youtube.services.ReactionService;
import tvd.youtube.services.UserService;
import util.VideoStatus;

/**
 *
 * @author Laptop_Thomas
 */
public class ReactionTest {

    UserDAOJPA userdao;
    ReactionDAOJPA reactiondao;
    UserService userservice;
    ReactionService reactionservice;
    EntityManager em;
    EntityManagerFactory emf;

    private void setupEntityManager() {
        emf = Persistence.createEntityManagerFactory("YoutubeTestPU");
        em = emf.createEntityManager();
        userdao = new UserDAOJPA();
        reactiondao = new ReactionDAOJPA();
        reactionservice = new ReactionService();
        userservice = new UserService();
        reactiondao.setEntityManager(em);
        userdao.setEntityManager(em);
        userservice.setDAO(userdao);
        reactionservice.setDAO(reactiondao);
    }
    
    
    @Test
    public void react() {
        setupEntityManager();
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), "user");
        Video v = new Video("Video 1", "Video for test purposes only", LocalDateTime.now(), user, VideoStatus.Public);
        user.postVideo(v);
        Reaction r = new Reaction("what a great test", user, v);
        user.react(r, v);
        em.getTransaction().begin();
        userservice.create(user);
        em.getTransaction().commit();
        List<Reaction> reactions = reactionservice.getAllReactionsFromVideo(v);
        em.close();
        emf.close();
        assertNotNull(reactions);

    }
    
    @Test
    public void editreaction(){
        setupEntityManager();
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), "user");
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
        
        List<Reaction> reactions = reactionservice.getAllReactionsFromVideo(v);
        assertEquals(teststring, reactions.get(0).getText());
        
    }
    
    
}
