package tvd.youtube.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import util.LocalDateConverter;

/**
 *
 * @author Laptop_Thomas
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate birthday;
    private String role;
    @Column(unique = true)
    private String url;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "UPLOADER_ID")
    private List<Video> videos;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CREATOR_ID")
    private List<Playlist> playlists;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonbTransient
    private List<User> subscribed;
    @ManyToMany(mappedBy = "subscribed", fetch = FetchType.LAZY)
    @JsonbTransient
    private List<User> subscribers;
    @OneToMany(targetEntity = Reaction.class, mappedBy = "sender", cascade = CascadeType.PERSIST)
    private List<Reaction> reactions;

    public User() {
        this.videos = new ArrayList<>();
        this.playlists = new ArrayList<>();
        this.subscribed = new ArrayList<>();
        this.subscribers = new ArrayList<>();
        this.reactions = new ArrayList<>();
    }

    public User(String name, String email, String password, LocalDate birthday, String role) {
        this();
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.role = role;

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

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<User> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(List<User> subscribed) {
        this.subscribed = subscribed;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    public void update(User u) {
        this.setName(u.getName());
    }

    public void subscribeTo(User u) {
        this.subscribed.add(u);
        u.getSubscribers().add(this);
    }
    
    public void postVideo(Video v){
        this.videos.add(v);
    }
    
    public void react(Reaction r, Video v){
        this.reactions.add(r);
        v.addReaction(r);
    }
    
    public void react(Reaction r, Reaction r2){
        this.reactions.add(r);
        r2.getReactions().add(r);
    }
    
    public void createPlaylist(Playlist p){
        this.playlists.add(p);
    }

}
