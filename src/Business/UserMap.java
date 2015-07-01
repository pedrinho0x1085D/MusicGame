/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author Pedro Cunha
 */
public class UserMap implements Serializable{
    private Map<String, User> users;

    public UserMap() {
    this.users=new HashMap<>();
    }
    
    public void logIn(String username, String password) throws InvalidLoginException{
        if(!(this.users.containsKey(username))||(!this.users.get(username).getPassword().equals(password))) throw new InvalidLoginException(username, password);
        else this.users.get(username).logIn();
        
    }
    
    public void logOut(String username){
        this.users.get(username).logOut();
    }
    
    public void register(String username,String password) throws InvalidRegisterException{
        if(this.users.containsKey(username)) throw new InvalidRegisterException(username);
        else this.users.put(username,new User(username, password));
    }
    
    public User getUser(String username) throws InvalidRegisterException{
        if(!this.users.containsKey(username)) throw new InvalidRegisterException(username);
        else return this.users.get(username);
    }
    
    public void deleteUser(String username){
        this.users.remove(username);
    }
    
    public TreeSet<PairStringInteger> globalRank(){
        TreeSet<PairStringInteger> res=new TreeSet<>(new ComparatorPairStringInteger());
        for(User ut:this.users.values())
            res.add(new PairStringInteger(ut.getGlobalScore()));
        return res;
    }
    
    public TreeSet<TripleStringStringScore> genreRank(String genre){
        TreeSet<TripleStringStringScore> res=new TreeSet<>(new ComparatorTripleStringStringScore());
        for(User ut:this.users.values())
            res.add(new TripleStringStringScore(ut.getGenreScore(genre)));
        return res;
    }
}
