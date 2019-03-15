package tvd.youtube.models;

import java.time.LocalDateTime;
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
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private LocalDateTime uploadTime;
    @OneToMany
    private ArrayList<Reaction> reactions;
    @ManyToOne
    private User uploader;

    public Video() {
    }
    
    

    public Video(String name, String description, LocalDateTime uploadTime, User uploader) {
        this.name = name;
        this.description = description;
        this.uploadTime = uploadTime;
        this.uploader = uploader;
        this.reactions = new ArrayList<>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }
    
    public void addReaction(Reaction r){
        this.getReactions().add(r);
    }
    
    
    
    
}
