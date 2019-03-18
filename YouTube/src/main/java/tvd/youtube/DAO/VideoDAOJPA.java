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
    public List<Video> getVideosByUser(int userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveVideos(List<Video> videos) {
        for (Video v : videos){
            em.merge(v);
        }
    }
    
}
