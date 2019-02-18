package tvd.youtube.models;

import java.util.ArrayList;

/**
 *
 * @author Laptop_Thomas
 */

public class Playlist {
    private int id;
    private String name;
    private ArrayList<Video> videos;
    private User creator;

    public Playlist(String name, ArrayList<Video> videos, User creator) {
        this.name = name;
        this.videos = videos;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
    
    public void update(Playlist p){
        this.setName(p.getName());
        this.setVideos(p.getVideos());
    }
    
    
    
    
}
