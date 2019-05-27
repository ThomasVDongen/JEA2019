/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tvd.youtube.models.Reaction;
import tvd.youtube.models.Video;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped
@JPA
public class ReactionDAOJPA extends EntityDAO<Reaction> implements ReactionDAO {

    @PersistenceContext(unitName = "YoutubePU")
    EntityManager em;

    public ReactionDAOJPA() {
        super(Reaction.class);
    }

    @Override
    public List<Reaction> getAllReactions() {
        Query query = em.createQuery("SELECT R FROM Reaction R");
        return query.getResultList();
    }

    @Override
    public List<Reaction> getAllReactionsFromVideo(Video video) {
        Query query = em.createQuery("SELECT r FROM Reaction r where r.video = :video");
        query.setParameter("video", video);
        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Reaction find(int id) {
        return super.find(id);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
