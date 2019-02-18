/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.List;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
public interface UserDAO {
    
    void create(User u);
    
    User find(int id);
    
    void remove(User u);
    
    void edit(User u);
    
    List<User> getAllUsers();
}
