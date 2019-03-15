/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.swagger.annotations.Api;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
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
import tvd.youtube.services.UserService;

/**
 *
 * @author Laptop_Thomas
 */
@Api
@Path("user")
@RequestScoped
public class UserResource {
    
    @Inject
    UserService us;
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(){
        return us.getAllUsers();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id){
        return us.find(id);
    }
    
    @POST
    @Path("{username}/{password}/{email}/{birthday}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerUser(@PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email, @PathParam("birthday") String birthday){      
        User u = new User(username, email, password, LocalDate.parse(birthday), "user");
        us.create(u);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeUser(@PathParam("id") int id){
        us.remove(us.find(id));
    }
}
