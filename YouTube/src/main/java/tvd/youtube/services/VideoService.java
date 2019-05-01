/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.services;

import java.util.List;
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
public class VideoService{
    
    @Inject @JPA
    private VideoDAO dao;

    public VideoService() {
    }

    public void create(Video v) {
        dao.create(v);
    }

    public void remove(Video v) {
        dao.remove(v);
    }

    public void edit(Video v) {
        dao.edit(v);
    }

    public Video find(int id) {
        return dao.find(id);
    }

    public List<Video> getAllVideos() {
       return dao.getAllVideos();
    }
    
    public List<Video> getVideosByUser(User user) {
        return dao.getVideosByUser(user);
    }
    
    public void saveVideos(List<Video> videos){
        dao.saveVideos(videos);
    }

    public void setDAO(VideoDAO dao) {
        this.dao = dao;
    }
    
}
