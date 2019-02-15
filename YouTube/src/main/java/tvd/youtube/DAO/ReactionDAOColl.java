/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
@ApplicationScoped
public class ReactionDAOColl implements ReactionDAO{
    
    private ArrayList<Reaction> reactions = new ArrayList<>();

    @Override
    public void react(Reaction reaction) {
        this.reactions.add(reaction);
    }

    @Override
    public List<Reaction> getAllReactions() {
        return this.reactions;
    }

    @Override
    public List<Reaction> getAllReactionsFromVideo(int videoId) {
        ArrayList<Reaction> values = new ArrayList<>();
        for (Reaction reaction : this.reactions){
            if (reaction.getVideo().getId() == videoId){
                values.add(reaction);
            }
        }
        return values;
    }
    
}
