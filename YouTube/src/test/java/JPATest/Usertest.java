/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPATest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tvd.youtube.DAO.UserDAOJPA;
import tvd.youtube.models.User;
import tvd.youtube.services.UserService;

/**
 *
 * @author Laptop_Thomas
 */
public class Usertest {

    UserDAOJPA dao;
    UserService service;
    EntityManager em;
    EntityManagerFactory emf;

    public Usertest() {
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

    private void setupEntityManager() {
        emf = Persistence.createEntityManagerFactory("YoutubeTestPU");
        em = emf.createEntityManager();
        dao = new UserDAOJPA();
        service = new UserService();
        dao.setEntityManager(em);
        service.setDAO(dao);
    }

    @Test
    public void createUser() {
        setupEntityManager();
        String username = "name";
        User user = new User(username, "email", "password", LocalDate.of(1996, Month.APRIL, 27), "user");
        em.getTransaction().begin();
        service.create(user);
        em.getTransaction().commit();
        User user2 = service.getUserByName(username);
        em.close();
        emf.close();
        assertNotNull(user2);
        assertEquals(user.getName(), user2.getName());

    }

    @Test
    public void followUser(){
        setupEntityManager();
        User user = new User("user1", "email", "password", LocalDate.of(1996, Month.APRIL, 27), "user");
        User user2 = new User("user2", "email2", "password", LocalDate.of(1998, Month.NOVEMBER, 25), "user");
        em.getTransaction().begin();
        service.create(user);
        service.create(user2);
        user.subscribeTo(user2);
        em.getTransaction().commit();
        User usertest = service.getUserByName("user1");
        User usertest2 = service.getUserByName("user2");
        em.close();
        emf.close();
        assertNotNull(usertest.getSubscribed());
        assertNotNull(usertest2.getSubscribers());
        List<User> testusers1 = new ArrayList<>();
        List<User> testusers2 = new ArrayList<>();
        testusers1.add(user);
        testusers2.add(user2);
        assertEquals(testusers1, usertest2.getSubscribers());
        assertEquals(testusers2, usertest.getSubscribed());
    }
}
