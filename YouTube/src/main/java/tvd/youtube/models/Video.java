package tvd.youtube.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import util.VideoStatus;

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
    private List<Reaction> reactions;
    @ManyToOne
    private User uploader;
    private VideoStatus status;

    public Video() {
    }
    
    

    public Video(String name, String description, LocalDateTime uploadTime, User uploader, VideoStatus status) {
        this.name = name;
        this.description = description;
        this.uploadTime = uploadTime;
        this.uploader = uploader;
        this.reactions = new ArrayList<>();
        this.status = status;
    }

    public Video(int id, String name, String description, LocalDateTime uploadtime, User uploader, VideoStatus status) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.uploadTime = uploadtime;
        this.uploader = uploader;
        this.status = status;
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

    public List<Reaction> getReactions() {
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

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }
    
    public void addReaction(Reaction r){
        this.getReactions().add(r);
    }
    
    public List<Reaction> getAllReactionsFromReactions(){
        
    }
    
    
    
}
