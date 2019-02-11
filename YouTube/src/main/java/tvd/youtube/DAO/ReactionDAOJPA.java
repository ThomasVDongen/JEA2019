/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import tvd.youtube.models.Reaction;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
public class ReactionDAOJPA implements ReactionDAO{

    @Override
    public void react(Reaction reaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Reaction> getAllReactions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Reaction> getAllReactionsFromVideo(int videoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
