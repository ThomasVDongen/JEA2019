/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
@RequestScoped @Default
public class ReactionDAOColl implements ReactionDAO{
    
    Map<Integer,Reaction> reactionmap;

    public ReactionDAOColl() {
        reactionmap = new HashMap<>();
    }
    
    @Override
    public List<Reaction> getAllReactions() {
        return (List)this.reactionmap.values();
    }
    
    @Override
    public List<Reaction> getAllReactionsFromVideo(int videoId) {
        ArrayList<Reaction> values = new ArrayList<>();
        for (Reaction reaction : this.reactionmap.values()){
            if (reaction.getVideo().getId() == videoId){
                values.add(reaction);
            }
        }
        return values;
    }

    @Override
    public void create(Reaction reaction) {
        this.reactionmap.put(reaction.getId(), reaction);
    }

    @Override
    public Reaction find(int id) {
        for (Reaction reaction : this.reactionmap.values()){
            if (reaction.getId() == id){
                return reaction;
            }
        }
        return null;
    }
    
    @Override
    public void remove(Reaction reaction){
        this.reactionmap.remove(reaction.getId());
    }

    @Override
    public void edit(Reaction reaction) {
        reactionmap.replace(reaction.getId(), reaction);
    }
}
