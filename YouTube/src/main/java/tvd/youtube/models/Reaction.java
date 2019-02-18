/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.models;

import java.time.LocalDateTime;

/**
 *
 * @author Laptop_Thomas
 */
public class Reaction {
    private int id;
    private String text;
    private User sender;
    private Video video;
    private LocalDateTime time;

    public Reaction(String text, User sender, Video video) {
        this.text = text;
        this.sender = sender;
        this.video = video;
        this.time = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    public void update(Reaction r){
        this.text = r.getText();
        this.time = LocalDateTime.now();
    }
    
    
    
    
    
    
    
}
