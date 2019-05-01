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
import tvd.youtube.models.Video;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped @JPA
public class VideoDAOJPA extends EntityDAO<Video> implements VideoDAO{
    
    @PersistenceContext
    EntityManager em;

    public VideoDAOJPA() {
        super(Video.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public void setEntityManager(EntityManager em){
        this.em = em;
    }

    @Override
    public Video find(int id) {
        return super.find(id);
    }

    @Override
    public List<Video> getAllVideos() {
        Query q = em.createQuery("Select V from Video v");
        return q.getResultList();
    }

    @Override
    public List<Video> getVideosByUser(User user) {
        Query q = em.createQuery("Select V from Video v where v.uploader = :userid");
        q.setParameter("userid", user);
        return q.getResultList();
    }

    @Override
    public void saveVideos(List<Video> videos) {
        for (Video v : videos){
            em.merge(v);
        }
    }
    
}
