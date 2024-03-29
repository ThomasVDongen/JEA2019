/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import util.VideoStatus;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped
@JPA
public class VideoDAOJPA extends EntityDAO<Video> implements VideoDAO {

    @PersistenceContext(unitName = "YoutubePU")
    EntityManager em;

    public VideoDAOJPA() {
        super(Video.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public void setEntityManager(EntityManager em) {
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
        for (Video v : videos) {
            em.merge(v);
        }
    }

    @Override
    public List<Video> getAllPublic() {
        Query q = em.createQuery("Select V from Video v where v.status= :public");
        q.setParameter("public", VideoStatus.Public);
        return q.getResultList();
    }

    @Override
    public List<Video> getTrending() {
        Query q = em.createQuery("Select V from Video v ORDER BY v.views DESC");
        return q.getResultList();
    }

    @Override
    public List<Video> getSubscriptions(User u) {
        List<Video> videos = new ArrayList<>();
        Query q = em.createNativeQuery("Select u.* from User u join user_user uu on u.id = uu.subscribed_ID where uu.subscribers_ID = ?userId", User.class);
        q.setParameter("userId", u.getId());
        List<User> users = (List<User>)q.getResultList();
        for (User user : users){
            videos.addAll(this.getVideosByUser(user));
        }
        return videos;
    }

    @Override
    public List<Video> search(String title) {
       Query q = em.createQuery("Select v from Video v where lower(v.name) like :title");
       q.setParameter("title", "%"+ title + "%");
       return q.getResultList();
    }
}
