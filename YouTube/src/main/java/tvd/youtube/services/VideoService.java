/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.services;

import Filter.JWTTokenNeeded;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import jwt.UserType;
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

    @JWTTokenNeeded(UserType.USER)
    public void create(Video v) {
        dao.create(v);
    }
    @JWTTokenNeeded(UserType.USER)
    public void remove(Video v) {
        dao.remove(v);
    }
    @JWTTokenNeeded(UserType.USER)
    public void edit(Video v) {
        dao.edit(v);
    }
    @JWTTokenNeeded(UserType.USER)
    public Video find(int id) {
        return dao.find(id);
    }
    @JWTTokenNeeded(UserType.USER)
    public List<Video> getAllVideos() {
        return dao.getAllVideos();
    }
    @JWTTokenNeeded(UserType.USER)
    public List<Video> getVideosByUser(User user) {
        return dao.getVideosByUser(user);
    }
    @JWTTokenNeeded(UserType.USER)
    public void saveVideos(List<Video> videos) {
        dao.saveVideos(videos);
    }

    public void setDAO(VideoDAO dao) {
        this.dao = dao;
    }
    @JWTTokenNeeded(UserType.USER)
    public List<Video> getAllPublic() {
        return dao.getAllPublic();
    }

}
