/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped @Default
public class UserDAOColl implements UserDAO{
    
    Map<Integer, User> usermap;

    public UserDAOColl() {
        this.usermap = new HashMap<>();
    }
    
    @Override
    public void create(User u) {
        this.usermap.put(u.getId(), u);
    }

    @Override
    public User find(int id) {
        for (User u : this.usermap.values()){
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }

    @Override
    public void remove(User u) {
        this.usermap.remove(u.getId());
    }

    @Override
    public void edit(User user) {
        this.usermap.replace(user.getId(), user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List)this.usermap.values();
    }
    
    public User getUserByName(String name){
        for (User u : this.usermap.values()){
            if (u.getName() == name){
                return u;
            }
        }
        return null;
    }
    
}
