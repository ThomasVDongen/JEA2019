/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.List;
import tvd.youtube.models.Playlist;

/**
 *
 * @author Laptop_Thomas
 */
public interface PlaylistDAO {
    
    void create(Playlist p);
    
    void remove(Playlist p);
    
    void edit(Playlist p);
    
    Playlist find(int id);
    
    List<Playlist> getAllPlaylists();
    
    List<Playlist> getAllPLaylistsByUser(int userid);
}
