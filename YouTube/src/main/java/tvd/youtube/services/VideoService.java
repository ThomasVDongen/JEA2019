/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.services;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tvd.youtube.DAO.JPA;
import tvd.youtube.DAO.VideoDAO;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class VideoService {

    @Inject
    @JPA
    private VideoDAO dao;

    public VideoService() {
    }

    @PermitAll()
    public void create(Video v) {
        dao.create(v);
    }

    @PermitAll()
    public void remove(Video v) {
        dao.remove(v);
    }

    @PermitAll()
    public void edit(Video v) {
        dao.edit(v);
    }

    @PermitAll()
    public Video find(int id) {
        return dao.find(id);
    }

    @PermitAll()
    public List<Video> getAllVideos() {
        return dao.getAllVideos();
    }

    @PermitAll()
    public List<Video> getVideosByUser(User user) {
        return dao.getVideosByUser(user);
    }

    @PermitAll()
    public void saveVideos(List<Video> videos) {
        dao.saveVideos(videos);
    }

    public void setDAO(VideoDAO dao) {
        this.dao = dao;
    }

    @PermitAll()
    public List<Video> getAllPublic() {
        return dao.getAllPublic();
    }

    @PermitAll()
    public List<Video> getTrending() {
        return dao.getTrending();
    }

    @PermitAll()
    public List<Video> getSubscriptions(User u) {
        return dao.getSubscriptions(u);
    }
    @PermitAll()
    public List<Video> search(String title) {
        return dao.search(title);
    }

}
