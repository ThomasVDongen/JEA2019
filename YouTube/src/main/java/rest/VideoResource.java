/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.swagger.annotations.Api;
import java.time.LocalDateTime;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import tvd.youtube.services.UserService;
import tvd.youtube.services.VideoService;
import util.VideoStatus;

/**
 *
 * @author Laptop_Thomas
 */
//////@Api
@Path("video")
@RequestScoped
public class VideoResource {
    
    @Inject
    VideoService vs;
    
    @Inject
    UserService us;
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getAll(){
        return vs.getAllVideos();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Video getVideo(@PathParam("id") int id){
        return vs.find(id);
    }
    
    @POST
    @Path("{name}/{description}/{status}/{userid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void uploadVideo(@PathParam("name") String name, @PathParam("description") String description, @PathParam("status") String status, @PathParam("userid") int userid){
        User u = us.find(userid);       
        Video v = new Video(name, description, LocalDateTime.now(), u, VideoStatus.valueOf(status));
        vs.create(v);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeVideo(@PathParam("id") int id){
        vs.remove(vs.find(id));
    }
}
