package tvd.youtube.models;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Laptop_Thomas
 */

@Entity
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    private ArrayList<Video> videos;
    @ManyToOne
    private User creator;

    public Playlist() {
    }
    
    

    public Playlist(String name, User creator) {
        this.name = name;
        this.videos = new ArrayList<>();
        this.creator = creator;
    }

    /**
     * Constructor for unit test
     * @param id
     * @param name
     * @param creator 
     */
    public Playlist(int id, String name, User creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.videos = new ArrayList<>();
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
    
    /***
     * Update name and videos from a playlist
     * @param p 
     */
    public void update(Playlist p){
        this.setName(p.getName());
        this.setVideos(p.getVideos());
    }
    
    public void addVideo(Video v){
        this.getVideos().add(v);
    }
    
    
    
    
}
