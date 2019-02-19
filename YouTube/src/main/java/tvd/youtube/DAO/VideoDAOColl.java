/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import tvd.youtube.models.Video;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless @Default
public class VideoDAOColl implements VideoDAO{
    
    List<Video> videos;

    public VideoDAOColl() {
        this.videos = new ArrayList<>();
    }

    @Override
    public void create(Video v) {
        this.videos.add(v);
    }

    @Override
    public void remove(Video v) {
        this.videos.remove(v);
    }

    @Override
    public void edit(Video v) {
        this.find(v.getId()).update(v);
    }

    @Override
    public Video find(int id) {
        for (Video video : this.videos){
            if (id == video.getId()){
                return video;
            }
        }
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return this.videos;
    }

    @Override
    public List<Video> getVideosByUser(int userid) {
        List<Video> values = new ArrayList<>();
        for (Video v : this.videos){
            if (v.getUploader().getId() == userid){
                values.add(v);
            }
        }
        return values;
    }
    
}
