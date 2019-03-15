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
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped @JPA
public class ReactionDAOJPA extends EntityDAO<Reaction> implements ReactionDAO {

    @PersistenceContext
    EntityManager em;

    public ReactionDAOJPA() {
        super(Reaction.class);
    }
    
    @Override
    public List<Reaction> getAllReactions() {
        Query query = em.createQuery("SELECT R FROM REACTION R");
        return query.getResultList();
    }

    @Override
    public List<Reaction> getAllReactionsFromVideo(int videoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Reaction find(int id) {
        return super.find(id);
    }
}
