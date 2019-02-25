/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tvd.youtube.models.Reaction;
import tvd.youtube.services.ReactionService;

/**
 *
 * @author Laptop_Thomas
 */
@Path("reaction")
@Stateless
public class ReactionResource {
    
    @Inject
    ReactionService rs;
    
    @GET
    public List<Reaction> getAll(){
        return rs.getAllReactions();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reaction getReaction(@PathParam("id") int id){
        return rs.find(id);
    }
}
