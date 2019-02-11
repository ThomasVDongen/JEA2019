package tvd.youtube.services;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tvd.youtube.DAO.ReactionDAO;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class ReactionService {
    @Inject
    private ReactionDAO reactionDAO;
    
    public void react(Reaction react){
        reactionDAO.react(react);
    }
    
    public ArrayList<Reaction> getAllReactions(){
        return reactionDAO.getAllReactions();
    }
    
    public ArrayList<Reaction> getAllReactionsFromVideo(int video){
        return reactionDAO.getAllReactionsFromVideo(video);
    }
    
}
