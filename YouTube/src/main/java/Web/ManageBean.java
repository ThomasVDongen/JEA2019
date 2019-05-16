package Web;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import tvd.youtube.services.UserService;
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

        
    @Inject
    VideoService vs;
    @Inject
    UserService us;
    
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


    @PostConstruct
    private void init() {
        this.generateVideos();
        this.allVideos = vs.getAllVideos();
        this.allStatus = Arrays.asList(VideoStatus.values());
    }

    public void save() {
        vs.saveVideos(allVideos);
        this.reload();
    }
    
    public void deleteVideo(int videoid){
        for (Video v : allVideos){
            if (v.getId() == videoid){
                vs.remove(v);
            }
        }
        this.allVideos = vs.getAllVideos();
        this.reload();
    }
    
    private void generateVideos(){
        User u = new User("user1", "test", "test", LocalDate.now(), "user");
        Video v1 = new Video("How to ", "how to java ee", LocalDateTime.now(), u, VideoStatus.Public);
        Video v2 = new Video("test", "test", LocalDateTime.now(), u, VideoStatus.Public);
        u.getVideos().add(v1);
        u.getVideos().add(v2);
        vs.saveVideos(u.getVideos());
    }
    
    public void reload() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException ex) {
            Logger.getLogger(ManageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
