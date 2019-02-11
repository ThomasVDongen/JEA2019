package tvd.youtube.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Laptop_Thomas
 */
public class Video {
    private int id;
    private String name;
    private String description;
    private LocalDateTime uploadTime;
    private ArrayList<Reaction> reactions;

    public Video(String name, String description, LocalDateTime uploadTime) {
        this.name = name;
        this.description = description;
        this.uploadTime = uploadTime;
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
    
    
    
    
}
