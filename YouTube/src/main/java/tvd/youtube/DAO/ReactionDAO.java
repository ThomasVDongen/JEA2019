package tvd.youtube.DAO;

import java.util.List;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
public interface ReactionDAO {
    
    void create(Reaction reaction);
    
    Reaction find(int id);
    
    void remove(Reaction reaction);
    
    void edit(Reaction reaction);
    
    List<Reaction> getAllReactions();
    
    List<Reaction> getAllReactionsFromVideo(int videoId);
}