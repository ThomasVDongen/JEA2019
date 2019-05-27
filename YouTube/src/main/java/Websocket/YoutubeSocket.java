/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Websocket;

import DTO.VideoDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Laptop_Thomas
 */
@ServerEndpoint(value = "/api/socket/")
public class YoutubeSocket {

    private static final Set<Session> sessions = new HashSet<>();
    
    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);

    }

    @OnMessage
    public static void onMessage(String video) throws IOException, EncodeException {
        try {
            Gson g = new Gson();
            VideoDTO v = g.fromJson(video, VideoDTO.class);
            System.out.println("sending: " + v.toString() + "to all connections");
            for (Session s : sessions) {
                s.getBasicRemote().sendObject(g.toJson(v));
            }
        }catch(Exception e){
            System.out.println(e.getCause());
        }

    }

    @OnClose
    public static void closedConnection(Session session) {
        sessions.remove(session);
        System.out.println("connection closed");
    }
}
