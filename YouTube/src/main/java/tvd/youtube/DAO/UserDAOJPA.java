/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped @JPA
public class UserDAOJPA extends EntityDAO<User> implements UserDAO{

    @PersistenceContext
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
    
    public User getUserByName(String name){
        Query query = em.createQuery("SELECT u FROM User u where u.name = :name");
        query.setParameter("name", name);
        return (User) query.getSingleResult();
    }

    //method for testing with entiymanager
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
}
