/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


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
    
    public void answerQuestion(String username,Question q, int option) throws InvalidRegisterException{
        if(q.isCorrect(option)){
            this.users.getUser(username).addScore(q.getGenre(), q.getScore());
        }
        else this.users.getUser(username).incQuestGenre(q.getGenre());
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
    public void toObjFile(String filename) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    
    public static BusinessFacade readObjFile(String filename)throws IOException,ClassNotFoundException{
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream(filename));
        BusinessFacade res=(BusinessFacade)ois.readObject();
        ois.close();
        return res;
    }

    
    public ArrayList<PairStringInteger> getGlobalRankings(){
        return new ArrayList<>(this.users.globalRank());
    }
    
    public ArrayList<TripleStringStringScore> getGenreRankings(String genre){
        return new ArrayList<>(this.users.genreRank(genre));
    }
    
    public ArrayList<String> getGenres(){
        return new ArrayList<>(this.questions.getGenres());
    }
    
    public User getUser(String username)throws InvalidRegisterException{
        return this.users.getUser(username);
    }
}
