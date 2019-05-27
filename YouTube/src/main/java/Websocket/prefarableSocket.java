/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Websocket;

import DTO.VideoDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.ws.rs.PathParam;
import tvd.youtube.models.User;
import tvd.youtube.services.UserService;

/**
 *
 * @author Laptop_Thomas
 */
public class prefarableSocket {

    @Inject
    UserService us;

    private static final Map<Long, List<Session>> sessions = new HashMap<>();

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        Long userid = new Long(userId);
        List<Session> userSessions = sessions.get(userid);
        if (userSessions != null) {
            sessions.put(userid, userSessions);
        } else {
            userSessions = new ArrayList<>();
            userSessions.add(session);
            sessions.put(userid, userSessions);
        }

    }

    @OnMessage
    public void onMessage(String video) throws IOException, EncodeException {
        try {
            Gson g = new Gson();
            VideoDTO v = g.fromJson(video, VideoDTO.class);
            User u = us.find(v.getUploaderId());
            for (User user : u.getSubscribers()) {
                Long userId = new Long(user.getId());
                for (Session s : sessions.get(userId)) {
                    s.getBasicRemote().sendObject(g.toJson(v));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
        }

    }

    @OnClose
    public static void closedConnection(@PathParam("userId") String userId, Session session) {
        Long userid = new Long(userId);
        List<Session> userSessions = sessions.get(userid);
        for (Session s: userSessions){
            if (s == session){
                userSessions.remove(s);
            }
        }
        sessions.put(userid, userSessions);
        System.out.println("connection closed");
    }

}
