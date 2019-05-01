/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped @Default
public class VideoDAOColl implements VideoDAO{
    
   Map<Integer, Video> videomap;

    public VideoDAOColl() {
        this.videomap = new HashMap<>();
    }

    @Override
    public void create(Video v) {
        this.videomap.put(v.getId(), v);
    }

    @Override
    public void remove(Video v) {
        this.videomap.remove(v.getId());
    }

    @Override
    public void edit(Video v) {
        this.videomap.replace(v.getId(), v);        
    }

    @Override
    public Video find(int id) {
        for (Video video : this.videomap.values()){
            if (id == video.getId()){
                return video;
            }
        }
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return new ArrayList<>(this.videomap.values());
    }

    @Override
    public List<Video> getVideosByUser(User userid) {
        List<Video> values = new ArrayList<>();
        for (Video v : this.videomap.values()){
            if (v.getUploader().getId() == userid.getId()){
                values.add(v);
            }
        }
        return values;
    }

    @Override
    public void saveVideos(List<Video> videos) {
        this.videomap.clear();
        for (Video v : videos){
            this.videomap.put(v.getId(), v);
        }
    }
    
}
