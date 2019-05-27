/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import util.LocalDateTimeConverter;

/**
 *
 * @author Laptop_Thomas
 */
@Entity
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    @ManyToOne
    @JsonIgnore
    private User sender;
    @ManyToOne
    @JsonIgnore
    private Video video;
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime time;
    ///Allows reactions to have reactions
    @OneToMany
    private List<Reaction> reactions;

    public Reaction() {
        this.reactions = new ArrayList<>();
    }

    public Reaction(String text, User sender, Video video) {
        this();
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

    public void update(Reaction r) {
        this.text = r.getText();
        this.time = LocalDateTime.now();
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    public void react(Reaction r) {
        this.getReactions().add(r);
    }

}
