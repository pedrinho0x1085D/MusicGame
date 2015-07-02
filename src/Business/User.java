/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pedro Cunha
 */
public class User implements Serializable{
    private String username;
    private String password;
    private Map<String,Integer> genresScore;//Genero e sua pontuação
    private Map<String,Integer> genresQuestions;
    private int score;
    private boolean logged;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.genresScore = new HashMap<>();
        this.genresQuestions = new HashMap<>();
        this.score = 0;
        this.logged = false;
    }
    
    public User(User other){
        
    }

    private Map<String, Integer> getGenresQuestions() {
        return genresQuestions;
    }

    private Map<String, Integer> getGenresScore() {
        return new HashMap<>(this.genresScore);
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

    public String getUsername() {
        return username;
    }

    public void setGenresQuestions(Map<String, Integer> genresQuestions) {
        this.genresQuestions = new HashMap<>(genresQuestions);
    }

    public boolean isLogged() {
        return logged;
    }

    public void setGenresScore(Map<String, Integer> genresScore) {
        this.genresScore = new HashMap<>(genresScore);
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void addScore(String genre, int score){
        this.score+=score;
        if(this.genresQuestions.containsKey(genre)){
            int quests=this.genresQuestions.get(genre);
            quests++;
            this.genresQuestions.put(genre,quests);
        }
        else{
            this.genresQuestions.put(genre, 1);
        }
        if(this.genresScore.containsKey(genre)){
            int scoreCurr=this.genresScore.get(genre);
            scoreCurr+=score;
            this.genresScore.put(genre, scoreCurr);
        }
        else{
            this.genresQuestions.put(genre, score);
        }
        
    }
    
    public TripleStringStringScore getGenreScore(String genre){
        return new TripleStringStringScore(genre,this.username, this.genresScore.get(genre));

    }
    
    public PairStringInteger getGlobalScore(){
        return new PairStringInteger(this.username,this.score);
    }
    public void incQuestGenre(String genre){
        int sc=this.genresQuestions.get(genre);
        sc++;
        this.genresQuestions.put(genre, sc);
    }
    public void logIn(){
        this.logged=true;
    }
    public void logOut(){
        this.logged=false;
    }
            
}
