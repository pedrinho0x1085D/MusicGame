/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;
import java.util.HashSet;
import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
/**
 *
 * @author Pedro Cunha
 */
public class QuestionSet implements Serializable{
    private HashSet<Question> questions;

    public QuestionSet() {
        this.questions=new HashSet<>();
    }
    
    public void insertQuestion(Question q){
        this.questions.add(q.clone());
    }
    
    public HashSet<Question> getByGenre(String genre){
        HashSet<Question> res=new HashSet<>();
        for(Question q:this.questions)
            if(q.getGenre().equals(genre)) res.add(q.clone());
        return res;
    }
    
    public HashSet<Question> getQuestions(){
        HashSet<Question> res= new HashSet<>();
        for(Question q:this.questions)
            res.add(q.clone());
        return res;
    }
    
    public TreeSet<String> getGenres(){
        TreeSet<String> res=new TreeSet<>();
        for(Question q:this.questions)
            res.add(q.getGenre());
        return res;
    }
    
    public void removeQuestion(Question q){
        this.questions.remove(q);
    }
    
    //Carregar a partir de xml
}
