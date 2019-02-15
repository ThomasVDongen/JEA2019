package tvd.youtube.DAO;

import java.util.List;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
public interface ReactionDAO {
   
    void react(Reaction reaction);
    
    List<Reaction> getAllReactions();
    
    List<Reaction> getAllReactionsFromVideo(int videoId);
}