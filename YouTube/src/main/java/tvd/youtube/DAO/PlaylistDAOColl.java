/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tvd.youtube.models.Playlist;

/**
 *
 * @author Laptop_Thomas
 */
@ApplicationScoped
public class PlaylistDAOColl implements PlaylistDAO{
    
    private List<Playlist> playlists = new ArrayList<>();

    @Override
    public void create(Playlist p) {
        this.playlists.add(p);
    }

    @Override
    public void remove(Playlist p) {
        this.playlists.remove(p);
    }

    @Override
    public void edit(Playlist p) {
        for (Playlist playlist : this.playlists){
            if (playlist.getId() == p.getId()){
                playlist.update(p);
            }
        }
    }

    @Override
    public Playlist find(int id) {
        for (Playlist p : this.playlists){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return this.playlists;
    }

    @Override
    public List<Playlist> getAllPLaylistsByUser(int userid) {
        List<Playlist> lists = new ArrayList<>();
        for (Playlist p : this.playlists){
            if (p.getCreator().getId() == userid){
                lists.add(p);
            }
        }
        return lists;
    }   
}
