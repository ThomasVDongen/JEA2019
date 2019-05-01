package tvd.youtube.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Laptop_Thomas
 */
@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "playlist_id")
    private List<Video> videos;
    @ManyToOne
    private User creator;

    public Playlist() {
        this.videos = new ArrayList<>();
    }

    public Playlist(String name, User creator) {
        this();
        this.name = name;
        this.creator = creator;
    }

    /**
     * Constructor for unit test
     *
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

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * *
     * Update name and videos from a playlist
     *
     * @param p
     */
    public void update(Playlist p) {
        this.setName(p.getName());
        this.setVideos(p.getVideos());
    }

    public void addVideo(Video v) {
        this.getVideos().add(v);
    }

}
