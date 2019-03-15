/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.swagger.annotations.Api;
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
import tvd.youtube.models.Reaction;
import tvd.youtube.models.User;
import tvd.youtube.models.Video;
import tvd.youtube.services.ReactionService;
import tvd.youtube.services.UserService;
import tvd.youtube.services.VideoService;

/**
 *
 * @author Laptop_Thomas
 */
@Api
@Path("reaction")
@RequestScoped
public class ReactionResource {

    @Inject
    ReactionService rs;
    
    @Inject
    VideoService vs;
    
    @Inject
    UserService us;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reaction> getAll() {
        return rs.getAllReactions();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reaction getReaction(@PathParam("id") int id) {
        return rs.find(id);
    }
    
    @POST
    @Path("{videoid}/{text}/{userid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createReaction(@PathParam("videoid") int videoid, @PathParam("text") String text, @PathParam("userid") int userid){
        Video v = vs.find(videoid);
        User u = us.find(userid);
        Reaction r = new Reaction(text, u, v);
        v.addReaction(r);
        vs.edit(v);
    }

    @DELETE
    @Path("{id}")
    public void deleteReaction(@PathParam("id") int id) {
        rs.remove(rs.find(id));
    }
    
    
}
