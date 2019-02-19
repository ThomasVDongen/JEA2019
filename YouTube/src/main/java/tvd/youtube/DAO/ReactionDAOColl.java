/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvd.youtube.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import tvd.youtube.models.Reaction;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless @Default
public class ReactionDAOColl implements ReactionDAO{
    
    private ArrayList<Reaction> reactions = new ArrayList<>();

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

    @Override
    public void create(Reaction reaction) {
        this.reactions.add(reaction);
    }

    @Override
    public Reaction find(int id) {
        for (Reaction reaction : this.reactions){
            if (reaction.getId() == id){
                return reaction;
            }
        }
        return null;
    }
    
    @Override
    public void remove(Reaction reaction){
        this.reactions.remove(reaction);
    }

    @Override
    public void edit(Reaction reaction) {
        for (Reaction r : this.reactions){
            if (r.getId() == reaction.getId()){
                r.update(reaction);
            }
        }
    }
}
