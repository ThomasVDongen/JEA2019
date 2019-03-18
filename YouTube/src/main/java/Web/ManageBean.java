package Web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import tvd.youtube.services.VideoService;
import util.VideoStatus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laptop_Thomas
 */
@SessionScoped
@Named("manage")
public class ManageBean implements Serializable {

    private List<Video> allVideos;
    private User currentUser;
    private List<VideoStatus> allStatus;
    private FacesContext fc = FacesContext.getCurrentInstance();

    public List<Video> getAllVideos() {
        return allVideos;
    }

    public void setAllVideos(List<Video> allVideos) {
        this.allVideos = allVideos;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<VideoStatus> getAllStatus() {
        return allStatus;
    }

    public void setAllStatus(List<VideoStatus> allStatus) {
        this.allStatus = allStatus;
    }
    
    @Inject
    VideoService vs;

    @PostConstruct
    private void init() {
        this.allVideos = vs.getAllVideos();
        this.allStatus = Arrays.asList(VideoStatus.values());
    }

    public void save() {
        vs.saveVideos(allVideos);
    }
    
    public void deleteVideo(int videoid){ 
        for (Video v : allVideos){
            if (v.getId() == videoid){
                vs.remove(v);
            }
        }
    }

}
