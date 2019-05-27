/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped
@JPA
public class UserDAOJPA extends EntityDAO<User> implements UserDAO {

    @PersistenceContext(unitName = "YoutubePU")
    EntityManager em;

    public UserDAOJPA() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public User find(int id) {
        return super.find(id);
    }

    @Override
    public List<User> getAllUsers() {
        Query query = em.createQuery("Select u from User u");
        return query.getResultList();
    }

    public User getUserByName(String name) {
        Query query = em.createQuery("SELECT u FROM User u where u.name = :name");
        query.setParameter("name", name);
        return (User) query.getSingleResult();
    }

    //method for testing with entiymanager
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public User authenticate(String username, String password) {
        Query query = em.createQuery("Select u from User u where u.name = :name and u.password = :password");
        query.setParameter("name", username);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }

    @Override
    public boolean getSubscribed(int userId, int check) {
        try {
            Query q = em.createNativeQuery("Select u.* from User u join user_user uu on u.id = uu.subscribed_ID where uu.subscribed_ID = ?userId and uu.subscribers_ID = ?check", User.class);
            q.setParameter("userId", userId);
            q.setParameter("check", check);
            User u = (User) q.getSingleResult();
            System.out.println("true");
            return true;
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public void unsubscribe(int userId, int currentUser) {
        Query q = em.createNativeQuery("Delete uu.* from user_user uu where uu.subscribers_ID = ?currentUser and uu.subscribed_ID = ?userId");
        q.setParameter("currentUser", currentUser);
        q.setParameter("userId", userId);
        System.out.println("unsubscribe");
        q.executeUpdate();
    }

    @Override
    public long getSubCount(int user) {
        Query q = em.createNativeQuery("SELECT count(*) FROM youtube.user_user where subscribed_ID = ?id");
        q.setParameter("id", user);
        System.out.println(q.getSingleResult());
        return (long) q.getSingleResult();

    }

}
