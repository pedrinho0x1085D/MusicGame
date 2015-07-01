/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Pedro Cunha
 */
public class BusinessFacade implements Serializable{
    private QuestionSet questions;
    private UserMap users;
    
    public BusinessFacade(){
        this.questions=new QuestionSet();
        this.users=new UserMap();
    }
    
    public ArrayList<Question> getQuestionsGenre(String genre){
        ArrayList auxil=new ArrayList<>(this.questions.getByGenre(genre));
        ArrayList auxiliary=new ArrayList<>();
        for(int i=0;i<10;i++){
            Random rng=new Random();
            int pos=rng.nextInt(auxil.size());
            while(auxiliary.contains(auxil.get(pos))){
                pos=rng.nextInt(auxil.size());
            }
            auxiliary.add(auxil.get(pos));
        }
        return auxiliary;
    }
    
    public ArrayList<Question> getQuestions(){
        ArrayList auxil=new ArrayList<>(this.questions.getQuestions());
        ArrayList auxiliary=new ArrayList<>();
        for(int i=0;i<10;i++){
            Random rng=new Random();
            int pos=rng.nextInt(auxil.size());
            while(auxiliary.contains(auxil.get(pos))){
                pos=rng.nextInt(auxil.size());
            }
            auxiliary.add(auxil.get(pos));
        }
        return auxiliary;
    }
    
    public void insertQuestion(Question q){
        this.questions.insertQuestion(q);
    }
    
    public void registerUser(String username, String password)throws InvalidRegisterException{
        this.users.register(username, password);
    }
    
    public void logIn(String username, String password)throws InvalidLoginException{
        this.users.logIn(username, password);
    }
    
    public void logOut(String username){
        this.users.logOut(username);
    }
}
