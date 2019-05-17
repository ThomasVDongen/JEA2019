/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.services;

import Filter.JWTTokenNeeded;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import jwt.UserType;
import tvd.youtube.DAO.JPA;
import tvd.youtube.DAO.UserDAO;
import tvd.youtube.models.User;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class UserService {

    @Inject
    @JPA
    UserDAO userdao;

    public void create(User u) {
        userdao.create(u);
    }

    @JWTTokenNeeded(UserType.USER)
    public void edit(User u) {
        userdao.edit(u);
    }

    @JWTTokenNeeded(UserType.USER)
    public void remove(User u) {
        userdao.remove(u);
    }

    @JWTTokenNeeded(UserType.USER)
    public User find(int id) {
        return userdao.find(id);
    }

    @JWTTokenNeeded(UserType.USER)
    public List<User> getAllUsers() {
        return userdao.getAllUsers();
    }

    @JWTTokenNeeded(UserType.USER)
    public User getUserByName(String name) {
        return userdao.getUserByName(name);
    }

    public void setDAO(UserDAO dao) {
        if (dao == null) {
            return;
        }
        this.userdao = dao;
    }

    public User authenticate(String username, String password) {
        if (username != null && password != null) {
            String hashedpassword = DigestUtils.sha256Hex(password);
            System.out.println(hashedpassword);
            return this.userdao.authenticate(username, hashedpassword);
        }
        return null;
    }

}
