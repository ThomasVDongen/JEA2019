package tvd.youtube.DAO;

import java.util.ArrayList;
import tvd.youtube.models.Reaction;
import tvd.youtube.models.User;

/**
 *
 * @author Laptop_Thomas
 */
public interface ReactionDAO {
   
    void react(Reaction reaction);
    
    ArrayList<Reaction> getAllReactions();
    
    ArrayList<Reaction> getAllReactionsFromVideo(int videoId);
}