/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.VideoDTO;
import Websocket.YoutubeSocket;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
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
import tvd.youtube.models.Video;
import tvd.youtube.services.UserService;
import tvd.youtube.services.VideoService;
import util.VideoStatus;

/**
 *
 * @author Laptop_Thomas
 */
@Api
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
    public Response getAll(@Context UriInfo uriInfo) {
        try {
            List<Video> videos = vs.getAllVideos();
            return Response.status(Response.Status.OK).entity(convertVideos(videos, uriInfo)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideo(@PathParam("id") int id, @Context UriInfo uriInfo) {
        try {
            VideoDTO v = new VideoDTO(vs.find(id));
            v.addLink(this.hateOSLink(uriInfo, "getVideo", v.getId()), "getVideo");
            v.addLink(this.HateOSOwner(uriInfo, "getUser", v.getUploaderId()), "getUser");
            return Response.status(Response.Status.OK).entity(v).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadVideo(VideoDTO v) {
        try {
            Video video = new Video();
            video.setName(v.getName());
            video.setDescription(v.getDescription());
            video.setStatus(VideoStatus.Public);
            video.setUploadTime(LocalDateTime.now());
            video.setUploader(us.find(v.getUploaderId()));
            vs.create(video);
            VideoDTO dto = new VideoDTO(video);
            Gson g = new Gson();
            String websocket = g.toJson(dto);
            YoutubeSocket.onMessage(websocket);
            return Response.status(Response.Status.OK).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeVideo(@PathParam("id") int id) {
        try {
            vs.remove(vs.find(id));
            return Response.status(Response.Status.OK).entity("Succes").build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    @GET
    @Path("/public")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPublic(@Context UriInfo uriInfo) {
        try {
            List<Video> videos = vs.getAllPublic();
            return Response.status(Response.Status.OK).entity(convertVideos(videos, uriInfo)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @POST
    @Path("/view")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response increaseview(@FormParam("videoId") String videoId, @Context UriInfo uriInfo) {
        Video v = vs.find(Integer.parseInt(videoId));
        v.addView();
        vs.edit(v);
        VideoDTO dto = new VideoDTO(vs.find(v.getId()));
        dto.addLink(this.hateOSLink(uriInfo, "getVideo", v.getId()), "getVideo");
        dto.addLink(this.HateOSOwner(uriInfo, "getUser", dto.getUploaderId()), "getUser");
        return Response.ok(dto).build();

    }

    @GET
    @Path("/trending")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrendingVideos(@Context UriInfo uriInfo) {
        try {
            List<Video> videos = vs.getTrending();
            return Response.status(Response.Status.OK).entity(convertVideos(videos, uriInfo)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @GET
    @Path("/sub")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubscriptionVideos(@QueryParam("userId") String userId, @Context UriInfo uriInfo) {
        try {
            List<Video> videos = vs.getSubscriptions(us.find(Integer.parseInt(userId)));
            return Response.status(Response.Status.OK).entity(convertVideos(videos, uriInfo)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideosFromUser(@QueryParam("userId") String userId, @Context UriInfo uriInfo) {
        try {
            List<Video> videos = vs.getVideosByUser(us.find(Integer.parseInt(userId)));
            return Response.status(Response.Status.OK).entity(convertVideos(videos, uriInfo)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("search") String search, @Context UriInfo uriInfo) {
        try {
            List<Video> videos = vs.search(search);
            return Response.status(Response.Status.OK).entity(convertVideos(videos, uriInfo)).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong").build();
        }

    }

    //method to convert videos to dtos
    private List<VideoDTO> convertVideos(List<Video> videos, UriInfo uriInfo) {
        List<VideoDTO> dtos = new ArrayList<>();
        for (Video v : videos) {
            VideoDTO dto = new VideoDTO(v);
            dto.addLink(this.hateOSLink(uriInfo, "getVideo", v.getId()), "getVideo");
            dto.addLink(this.HateOSOwner(uriInfo, "getUser", dto.getUploaderId()), "getUser");
            dtos.add(dto);
        }
        return dtos;
    }

    private String hateOSLink(UriInfo uriInfo, String method, int id) {
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
