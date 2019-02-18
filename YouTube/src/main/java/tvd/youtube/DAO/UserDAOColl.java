/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@ApplicationScoped
public class UserDAOColl implements UserDAO{
    
    List<User> users = new ArrayList<>();

    @Override
    public void create(User u) {
        this.users.add(u);
    }

    @Override
    public User find(int id) {
        for (User u : this.users){
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }

    @Override
    public void remove(User u) {
        this.users.remove(u);
    }

    @Override
    public void edit(User user) {
        for (User u : this.users){
            if (u.getId() == user.getId() ){
                u.update(user);
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }
    
}
