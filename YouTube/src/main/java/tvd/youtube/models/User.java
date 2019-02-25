package tvd.youtube.models;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Laptop_Thomas
 */
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private LocalDate birthday;
    private String role;
    @Column(unique = true)
    private String url;
    
    @OneToMany
    private ArrayList<Video> videos;
    @OneToMany
    private ArrayList<Playlist> playlists;
    @OneToMany
    private ArrayList<Reaction> reactions;
    @ManyToMany(mappedBy = "subscribers", fetch = FetchType.LAZY)
    private ArrayList<User> subscribed;
    @ManyToMany
    private ArrayList<User> subscribers;

    public User() {
    }
    
    

    public User(String name, String email, String password, LocalDate birthday, String role) {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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

    public ArrayList<User> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(ArrayList<User> subscribed) {
        this.subscribed = subscribed;
    }

    public ArrayList<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<User> subscribers) {
        this.subscribers = subscribers;
    }
    
    public void update(User u){
        this.setName(u.getName());
    }
    
}
