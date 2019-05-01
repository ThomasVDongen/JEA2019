/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import tvd.youtube.models.Playlist;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped @Default
public class PlaylistDAOColl implements PlaylistDAO{
    
    Map<Integer, Playlist> playlistmap;

    public PlaylistDAOColl() {
        this.playlistmap = new HashMap<>();
    }

    @Override
    public void create(Playlist p) {
        this.playlistmap.put(p.getId(), p);
    }

    @Override
    public void remove(Playlist p) {
        this.playlistmap.remove(p.getId());
    }

    @Override
    public void edit(Playlist p) {
       this.playlistmap.replace(p.getId(), p);
    }

    @Override
    public Playlist find(int id) {
        for (Playlist p : this.playlistmap.values()){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return (List)this.playlistmap.values();
    }

    @Override
    public List<Playlist> getAllPlaylistsByUser(User u) {
        List<Playlist> lists = new ArrayList<>();
        for (Playlist p : this.playlistmap.values()){
            if (p.getCreator().getId() == u.getId()){
                lists.add(p);
            }
        }
        return lists;
    }   
}
