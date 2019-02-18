/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
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
    public void edit(User u){
        super.edit(u);
    }
    
    @Override
    public void remove(User u){
        super.remove(u);
    }
    
    @Override
    public void create(User u){
        super.create(u);
    }

    @Override
    public List<User> getAllUsers() {
        Query query = em.createQuery("Select u from User u");
        return query.getResultList();
    }
    
}
