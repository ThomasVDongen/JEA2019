/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.UserDTO;
import io.swagger.annotations.Api;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
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
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.ZoneId;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

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

    @Inject
    SimpleKeyGenerator keyGenerator;

    @Context
    private UriInfo uriInfo;

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
    public Response getUser(@PathParam("id") int id) {
        try {
            UserDTO u = new UserDTO(us.find(id));
            return Response.status(Response.Status.OK).entity(u).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(User u) {
        try {
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
    
    public Response loginJWT(@QueryParam("username") String username, @QueryParam("password") String password) {
            String token = this.issueToken(this.us.authenticate(username, password));
            return Response.status(Response.Status.NO_CONTENT).header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();

    }

    private String issueToken(User user) {
        if (user != null) {
            Key key = keyGenerator.generateKey();
            String jwtToken = Jwts.builder()
                    .claim("groups", user.getRole())
                    .setSubject(user.getName())
                    .setIssuedAt(new Date())
                    .setExpiration(this.toDate(LocalDateTime.now().plusMinutes(15L)))
                    .setIssuer(this.uriInfo.getAbsolutePath().toString())
                    .signWith(SignatureAlgorithm.HS256, key).compact();
            FacesContext fc = FacesContext.getCurrentInstance();
            if (fc != null) {
                fc.getExternalContext().getSessionMap().put("jwt", jwtToken);
            }
            return jwtToken;
        }
        return null;
    }

    private Date toDate(LocalDateTime date) {
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }
}
