/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.services;

//import Filter.JWTTokenNeeded;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
//import jwt.UserType;
import tvd.youtube.DAO.JPA;
import tvd.youtube.DAO.PlaylistDAO;
import tvd.youtube.models.Playlist;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class PlaylistService {

    @Inject
    @JPA
    PlaylistDAO playlistDAO;

    public PlaylistService() {
    }

    //@JWTTokenNeeded(UserType.USER)
    public void create(Playlist play) {
        playlistDAO.create(play);
    }

    //@JWTTokenNeeded(UserType.USER)
    public void edit(Playlist play) {
        playlistDAO.edit(play);
    }

    //@JWTTokenNeeded(UserType.USER)
    public void remove(Playlist play) {
        playlistDAO.remove(play);
    }

   // @JWTTokenNeeded(UserType.USER)
    public Playlist find(int id) {
        return playlistDAO.find(id);
    }

    //@JWTTokenNeeded(UserType.USER)
    public List<Playlist> getAllPlaylists() {
        return playlistDAO.getAllPlaylists();
    }

    //@JWTTokenNeeded(UserType.USER)
    public List<Playlist> getPlaylistsbyUser(User u) {
        return playlistDAO.getAllPlaylistsByUser(u);
    }

    
    public void setDAO(PlaylistDAO playlistDao) {
        this.playlistDAO = playlistDao;
    }

}
