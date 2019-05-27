/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
public class ReactionDTO {

    private int id;
    private String text;
    private String senderName;
    private int senderId;
    private int videoId;
    private Date time;
    private List<Link> links;

    public ReactionDTO(int id, String text, String senderName, int senderId, int videoId, Date time) {
        this();
        this.id = id;
        this.text = text;
        this.senderName = senderName;
        this.senderId = senderId;
        this.videoId = videoId;
        this.time = time;

    }

    public ReactionDTO(Reaction r) {
        this(r.getId(), r.getText(), r.getSender().getName(), r.getSender().getId(), r.getVideo().getId(), Date.from(r.getTime().toInstant(ZoneOffset.UTC)));
    }

    public ReactionDTO() {
        this.links = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(String url, String rel) {
        links.add(new Link(url,rel));
    }

}
