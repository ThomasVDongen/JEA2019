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
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response getAll() {
        try {
            List<User> users = us.getAllUsers();
            return Response.status(Response.Status.OK).entity(users).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        try {
            User u = us.find(id);
            return Response.status(Response.Status.OK).entity(u).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @POST
    @Path("{username}/{password}/{email}/{birthday}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(@PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email, @PathParam("birthday") String birthday) {
        try {
            User u = new User(username, email, password, LocalDate.parse(birthday), "user");
            us.create(u);
            return Response.status(Response.Status.OK).entity("Succes").build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeUser(@PathParam("id") int id) {
        try {
            us.remove(us.find(id));
            return Response.status(Response.Status.OK).entity("Succes").build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }
}