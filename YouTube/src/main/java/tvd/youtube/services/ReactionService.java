package tvd.youtube.services;

import java.util.List;
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
    
    public void create(Reaction react){
        reactionDAO.create(react);
    }
    public void edit(Reaction react){
        reactionDAO.edit(react);
    }
    
    public void remove(Reaction react){
        reactionDAO.remove(react);
    }
    
    public Reaction find(int id){
        return reactionDAO.find(id);
    }
    
    public List<Reaction> getAllReactions(){
        return reactionDAO.getAllReactions();
    }
    
    public List<Reaction> getAllReactionsFromVideo(int video){
        return reactionDAO.getAllReactionsFromVideo(video);
    }
    
}
