/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Link;
import tvd.youtube.models.User;


/**
 *
 * @author Laptop_Thomas
 */
public class UserDTO {
    
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
    private String role;
    private String url;
    private List<Link> links;
    private int videoCount;
    private int subscriberCount;
    private int subscribedCount;

    public UserDTO(int id, String name, String email, String password, LocalDate birthday, String role, String url, int videoCount, int subscriberCount, int subscribedCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.role = role;
        this.url = url;
        this.links = new ArrayList<>();
        this.videoCount = videoCount;
        this.subscriberCount = subscriberCount;
        this.subscribedCount = subscribedCount;
    }



    public UserDTO(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getBirthday(), u.getRole() u.getVideos().size(), u.getSubscribers().size(), u.getSubscribed().size())
    }
    
    
    
    
    
    
}
