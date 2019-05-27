/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.ReactionDTO;
import io.swagger.annotations.Api;
import java.net.URI;
import java.time.LocalDateTime;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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
    public Response getAll() {
        try {
            List<Reaction> reactions = rs.getAllReactions();
            List<ReactionDTO> dtos = new ArrayList<>();
            for (Reaction r : reactions) {
                ReactionDTO dto = new ReactionDTO(r);
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
    public Response getReaction(@PathParam("id") int id, @Context UriInfo uriInfo) {
        try {
            ReactionDTO r = new ReactionDTO(rs.find(id));
            r.addLink(this.hateOSLink(uriInfo, "getReaction", r.getId()), "getReaction");
            r.addLink(this.HateOSOwner(uriInfo, "getUser", r.getSenderId()), "getUser");
            r.addLink(this.hateOSVideo(uriInfo, "getVideo", r.getVideoId()), "getVideo");
            return Response.status(Response.Status.OK).entity(r).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReaction(ReactionDTO r, @Context UriInfo uriInfo) {
        try {
            User u = us.find(r.getSenderId());
            Video v = vs.find(r.getVideoId());
            Reaction react = new Reaction();
            react.setSender(u);
            react.setText(r.getText());
            react.setTime(LocalDateTime.now());
            react.setVideo(v);
            u.react(react, v);
            us.edit(u);
            List<Reaction> reactions = rs.getAllReactionsFromVideo(r.getVideoId());
            return Response.status(Response.Status.OK).entity(convertReactions(reactions, uriInfo)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    @DELETE
    @Path("{id}")
    public Response deleteReaction(@PathParam("id") int id) {
        try {
            rs.remove(rs.find(id));
            return Response.status(Response.Status.OK).entity("Succes").build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    @GET
    @Path("/video")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReactionsByVideo(@QueryParam("videoId") String videoId, @Context UriInfo uriInfo) {
        try {
            List<Reaction> reactions = rs.getAllReactionsFromVideo(Integer.parseInt(videoId));
            return Response.status(Response.Status.OK).entity(convertReactions(reactions, uriInfo)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    private List<ReactionDTO> convertReactions(List<Reaction> reactions, UriInfo uriInfo) {
        List<ReactionDTO> dtos = new ArrayList<>();
        for (Reaction r : reactions) {
            ReactionDTO dto = new ReactionDTO(r);
            dto.addLink(this.hateOSLink(uriInfo, "getReaction", dto.getId()), "getReaction");
            dto.addLink(this.HateOSOwner(uriInfo, "getUser", dto.getSenderId()), "getUser");
            dto.addLink(this.hateOSVideo(uriInfo, "getVideo", dto.getVideoId()), "getVideo");
            dtos.add(dto);
        }
        return dtos;
    }

    private String hateOSLink(UriInfo uriInfo, String method, int id) {
        URI uri = uriInfo.getBaseUriBuilder()
                .path(ReactionResource.class)
                .path(ReactionResource.class, method)
                .resolveTemplate("id", id).build();
        return uri.toString();
    }

    private String hateOSVideo(UriInfo uriInfo, String method, int id) {
        URI uri = uriInfo.getBaseUriBuilder()
                .path(VideoResource.class)
                .path(VideoResource.class, method)
                .resolveTemplate("id", id).build();
        return uri.toString();
    }

    private String HateOSOwner(UriInfo uriInfo, String method, int id) {
        URI uri = uriInfo.getBaseUriBuilder()
                .path(UserResource.class)
                .path(UserResource.class, method)
                .resolveTemplate("id", id).build();
        return uri.toString();
    }

}
