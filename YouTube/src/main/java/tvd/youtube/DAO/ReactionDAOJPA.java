/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class ReactionDAOJPA extends EntityDAO<Reaction> implements ReactionDAO{
    
    EntityManager em;

    public ReactionDAOJPA() {
        super(Reaction.class);
    }


    @Override
    public void react(Reaction reaction) {
        em.persist(reaction);
    }

    @Override
    public List<Reaction> getAllReactions() {
        Query query = em.createNamedQuery("SELECT R FROM REACTION R");
        return query.getResultList();
    }

    @Override
    public ArrayList<Reaction> getAllReactionsFromVideo(int videoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
