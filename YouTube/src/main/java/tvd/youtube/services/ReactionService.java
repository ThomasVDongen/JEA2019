package tvd.youtube.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tvd.youtube.DAO.JPA;
import tvd.youtube.DAO.ReactionDAO;
import tvd.youtube.models.Reaction;
import tvd.youtube.models.Video;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class ReactionService {
    
    @Inject @JPA
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
    
    public List<Reaction> getAllReactionsFromVideo(Video v){
        return reactionDAO.getAllReactionsFromVideo(v);
    }

    public ReactionService() {
    }
    
    public void setDAO(ReactionDAO dao) {
        if (dao == null){
            return;
        }
        this.reactionDAO = dao;
    }
    
}
