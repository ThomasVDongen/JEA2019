/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tvd.youtube.models.User;


/**
 *
 * @author Laptop_Thomas
 */
public class UserDTO{
    
    private int id;
    private String name;
    private String email;
    private Date birthday;
    private String role;
    private List<Link> links;
    private int videoCount;
    private int subscriberCount;
    private int subscribedCount;
    private String token;

    public UserDTO(int id, String name, String email, Date birthday, String role, int videoCount, int subscriberCount, int subscribedCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.role = role;
        this.links = new ArrayList<>();
        this.videoCount = videoCount;
        this.subscriberCount = subscriberCount;
        this.subscribedCount = subscribedCount;
    }

    public UserDTO(User u) {
        this(u.getId(), u.getName(), u.getEmail(), Date.from(u.getBirthday().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), u.getRole().toString(), u.getVideos().size(), u.getSubscribers().size(), u.getSubscribed().size());
        
    }
    
    public UserDTO(){
        this.links = new ArrayList<>();
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getSubscriberCount() {
        return subscriberCount;
    }

    public void setSubscriberCount(int subscriberCount) {
        this.subscriberCount = subscriberCount;
    }

    public int getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(int subscribedCount) {
        this.subscribedCount = subscribedCount;
    }
    
    public String getToken(){
        return this.token;
    }
    
    public void setToken(String token){
        this.token = token;
    }
    
     public void addLink(String url, String rel){
        links.add(new Link(url,rel));
    }
    
    
    
    
    
    
    
    
}
