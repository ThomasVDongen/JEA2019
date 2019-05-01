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
import tvd.youtube.models.Playlist;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped @JPA
public class PlaylistDAOJPA extends EntityDAO<Playlist> implements PlaylistDAO{
    @PersistenceContext
    EntityManager em;

    public PlaylistDAOJPA() {
        super(Playlist.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        Query query = em.createQuery("Select P from Playlist P");
        return query.getResultList();
    }

    @Override
    public List<Playlist> getAllPlaylistsByUser(User u) {
        Query q = em.createQuery("Select p from Playlist p where p.creator = :user");
        q.setParameter("user", u);
        return q.getResultList();
    }

    @Override
    public Playlist find(int id) {
         return super.find(id);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
}
