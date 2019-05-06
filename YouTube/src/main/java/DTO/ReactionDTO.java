/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Link;
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
    private LocalDateTime time;
    private List<Link> links;

    public ReactionDTO(int id, String text, String senderName, int senderId, int videoId, LocalDateTime time) {
        this.id = id;
        this.text = text;
        this.senderName = senderName;
        this.senderId = senderId;
        this.videoId = videoId;
        this.time = time;
        this.links = new ArrayList<>();       
    }

    public ReactionDTO(Reaction r) {
        this(r.getId(), r.getText(), r.getSender().getName(), r.getSender().getId(), r.getVideo().getId(), r.getTime());
    }
    
    
    
    
}
