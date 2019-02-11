package tvd.youtube.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Laptop_Thomas
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime birthday;
    private String role;
    
    private ArrayList<Video> videos;
    private ArrayList<Playlist> playlists;
    private ArrayList<Reaction> reactions;
    private ArrayList<User> subscribed;
    private ArrayList<User> subscribers;

    public User(String name, String email, String password, LocalDateTime birthday, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.role = role;
        this.videos = new ArrayList<>();
        this.playlists = new ArrayList<>();
        this.reactions = new ArrayList<>();
        this.subscribed = new ArrayList<>();
        this.subscribers = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }
    
    
    
    
    
    
    
    
    
}
