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
import tvd.youtube.models.User;
import tvd.youtube.services.UserService;

/**
 *
 * @author Laptop_Thomas
 */
@Path("user")
@Stateless
public class UserResource {
    
    @Inject
    UserService us;
    
    @GET
    public List<User> getAll(){
        return us.getAllUsers();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id){
        return us.find(id);
    }
    
}
