/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tvd.youtube.DAO.JPA;
import tvd.youtube.DAO.UserDAO;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class UserService {
    
    @Inject @JPA
    UserDAO userdao;
    
    public void create(User u){
        userdao.create(u);
    }
    
    public void edit(User u){
        userdao.edit(u);               
    }
    
    public void remove(User u){
        userdao.remove(u);
    }
    
    public User find(int id){
        return userdao.find(id);
    }
    
    public List<User> getAllUsers(){
        return userdao.getAllUsers();
    }
    
}
