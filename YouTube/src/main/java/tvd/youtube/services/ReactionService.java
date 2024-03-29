package tvd.youtube.services;

//import Filter.JWTTokenNeeded;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
//import jwt.UserType;
import tvd.youtube.DAO.JPA;
import tvd.youtube.DAO.ReactionDAO;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class ReactionService {

    @Inject
    @JPA
    private ReactionDAO reactionDAO;
    
    @Inject
    private VideoService videoService;

    //@JWTTokenNeeded(UserType.USER)
    public void create(Reaction react) {
        reactionDAO.create(react);
    }

    //@JWTTokenNeeded(UserType.USER)
    public void edit(Reaction react) {
        reactionDAO.edit(react);
    }

    //@JWTTokenNeeded(UserType.USER)
    public void remove(Reaction react) {
        reactionDAO.remove(react);
    }

    //@JWTTokenNeeded(UserType.USER)
    public Reaction find(int id) {
        return reactionDAO.find(id);
    }

    //@JWTTokenNeeded(UserType.USER)
    public List<Reaction> getAllReactions() {
        return reactionDAO.getAllReactions();
    }

    //@JWTTokenNeeded(UserType.USER)
    public List<Reaction> getAllReactionsFromVideo(int videoid) {
        return reactionDAO.getAllReactionsFromVideo(videoService.find(videoid));
    }

    public ReactionService() {
    }

    public void setDAO(ReactionDAO dao) {
        if (dao == null) {
            return;
        }
        this.reactionDAO = dao;
    }
    
    public void setVideoService(VideoService vs){
        if (vs == null){
            return;
        }
        this.videoService = vs;
    }

}
