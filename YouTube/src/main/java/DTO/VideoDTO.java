/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import util.VideoStatus;
import javax.ws.rs.core.Link;
import tvd.youtube.models.Video;

/**
 *
 * @author Laptop_Thomas
 */
public class VideoDTO {
    
    private int id;
    private String name;
    private String description;
    private int views;
    private LocalDateTime uploadTime;
    private String uploaderName;
    private int uploaderId;
    private VideoStatus status;
    private List<Link> links;

    public VideoDTO(int id, String name, String description, int views, LocalDateTime uploadTime, String uploaderName, int uploaderId, VideoStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.views = views;
        this.uploadTime = uploadTime;
        this.uploaderName = uploaderName;
        this.uploaderId = uploaderId;
        this.status = status;
        this.links = new ArrayList<>();
    }

    public VideoDTO(Video v) {
        this(v.getId(), v.getName(),v.getDescription() , v.getViews(), v.getUploadTime(), v.getUploader().getName(), v.getUploader().getId(), v.getStatus());
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public int getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(int uploaderId) {
        this.uploaderId = uploaderId;
    }

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    
}
