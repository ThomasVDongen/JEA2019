/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.RegisterDTO;
import DTO.UserDTO;
import com.nimbusds.jose.JOSEException;
import io.swagger.annotations.Api;
import java.util.ArrayList;
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
import jwt.SimpleKeyGenerator;
import tvd.youtube.models.User;
import tvd.youtube.services.UserService;
import java.net.URI;
import java.time.ZoneId;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import jwt.JWTStore;
import util.Role;

/**
 *
 * @author Laptop_Thomas
 */
@Api
@Path("user")
@RequestScoped
public class UserResource {

    @Inject
    JWTStore jwtStore;
    @Inject
    UserService us;

    SimpleKeyGenerator keyGenerator;

    public UserResource() {
        this.keyGenerator = new SimpleKeyGenerator();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        try {
            List<User> users = us.getAllUsers();
            List<UserDTO> dtos = new ArrayList<>();
            for (User u : users) {
                UserDTO dto = new UserDTO(u);
                dtos.add(dto);
            }
            return Response.status(Response.Status.OK).entity(dtos).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id, @Context UriInfo uriInfo) {
        try {
            UserDTO u = new UserDTO(us.find(Integer.parseInt(id)));
            System.out.println(u.getId());
            u.addLink(hateOSLink(uriInfo, "getUser", u.getId()), "getSelf");
            u.addLink(hateOSSubCount(uriInfo, "getSubCount", u.getId()), "getSubCount");
            return Response.status(Response.Status.OK).entity(u).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(RegisterDTO dto) {
        try {
            User u = new User(dto.getUser().getName(), dto.getUser().getEmail(), dto.getPassword(), dto.getUser().getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), Role.user);
            us.create(u);
            return Response.status(Response.Status.OK).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeUser(@PathParam("id") String id) {
        try {
            us.remove(us.find(Integer.parseInt(id)));
            return Response.status(Response.Status.OK).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response loginJWT(@FormParam("username") String username, @FormParam("password") String password, @Context UriInfo uriInfo) throws JOSEException {
        System.out.println(username);
        User u = this.us.authenticate(username, password);
        List<String> roles = new ArrayList<>();
        roles.add(Role.admin.toString());
        roles.add(Role.user.toString());
        String token = this.jwtStore.generateToken(username, roles);
        UserDTO dto = new UserDTO(u);
        dto.setToken(token);
        System.out.println(dto.getId());
        dto.addLink(hateOSLink(uriInfo, "getUser", dto.getId()), "getSelf");
        dto.addLink(hateOSSubCount(uriInfo, "getSubCount", dto.getId()), "getSubCount");
        return Response.ok(dto).build();

    }

    @POST
    @Path("/subscribe")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response subscribe(@FormParam("userId") String userId, @FormParam("currentUser") String currentUser) {
        try {
            User subscribeTo = us.find(Integer.parseInt(userId));
            User currentU = us.find(Integer.parseInt(currentUser));
            currentU.subscribeTo(subscribeTo);
            us.edit(currentU);
            return Response.status(Response.Status.OK).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @POST
    @Path("/unsubscribe")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response unsubscribe(@FormParam("userId") String userId, @FormParam("currentUser") String currentUser) {
        try {
            int user = Integer.parseInt(userId);
            int check = Integer.parseInt(currentUser);
            us.unsubscribe(user, check);
            return Response.status(Response.Status.OK).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @GET
    @Path("/subscribed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubscribed(@QueryParam("userId") String userId, @QueryParam("currentUser") String currentUser) {
        try {
            int user = Integer.parseInt(userId);
            int check = Integer.parseInt(currentUser);
            return Response.status(Response.Status.OK).entity(us.getSubscribed(user, check)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @GET
    @Path("/subcount")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubCount(@QueryParam("userId") String userId) {
        try {
            int user = Integer.parseInt(userId);
            return Response.status(Response.Status.OK).entity(us.getSubCount(user)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    private String hateOSLink(UriInfo uriInfo, String method, int id) {
        URI uri = uriInfo.getBaseUriBuilder()
                .path(UserResource.class)
                .path(UserResource.class, method)
                .resolveTemplate("id", id).build();
        return uri.toString();

    }
    
    private String hateOSSubCount(UriInfo uriInfo, String method, int id){
        URI uri = uriInfo.getBaseUriBuilder()
                .path(UserResource.class)
                .path(UserResource.class, method)
                .queryParam("userId", id)
                .build();
        return uri.toString();
    }

}
