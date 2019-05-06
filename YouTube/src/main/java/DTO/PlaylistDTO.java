/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Link;
import tvd.youtube.models.Playlist;

/**
 *
 * @author Laptop_Thomas
 */
public class PlaylistDTO {
    private int id;
    private String name;
    private int creatorId;
    private String creatorName;
    private List<Link> links;

    public PlaylistDTO(int id, String name, int creatorId, String creatorName) {
        this.id = id;
        this.name = name;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.links = new ArrayList<>();
    }

    public PlaylistDTO(Playlist p) {
        this(p.getId(), p.getName(), p.getCreator().getId(), p.getCreator().getName());
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

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    
    
    
    
    
    
}
