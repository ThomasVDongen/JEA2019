/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.List;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;

/**
 *
 * @author Laptop_Thomas
 */
public interface VideoDAO {
    void create(Video v);
    
    void remove(Video v);
    
    void edit(Video v);
    
    Video find(int id);
    
    List<Video> getAllVideos();
    
    List<Video> getVideosByUser(User user);

    public void saveVideos(List<Video> videos);
}
