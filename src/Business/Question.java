/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;

/**
 *
 * @author Pedro Cunha
 */
public class Question implements Serializable{
    private String text;
    private String opt1,opt2,opt3,opt4;
    private String genre;
    private String mp3File;
    private int correct;
    private int score;

    public Question(String text,String mp3File, String opt1, String opt2, String opt3, String opt4,String genre, int correct,int score) {
        this.text = text;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.mp3File=mp3File;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.genre=genre;
        this.correct = correct;
        this.score=score;
    }

    public Question(Question q){
        this.correct=q.getCorrect();
        this.genre=q.getGenre();
        this.mp3File=q.getMp3File();
        this.opt1=q.getOpt1();
        this.opt2=q.getOpt2();
        this.opt3=q.getOpt3();
        this.opt4=q.getOpt4();
        this.text=q.getText();
        this.score=q.getCorrect();
    }
    
    public int getCorrect() {
        return correct;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public String getGenre() {
        return genre;
    }

    public String getMp3File() {
        return mp3File;
    }
    
    public String getOpt1() {
        return opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public String getText() {
        return text;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMp3File(String mp3File) {
        this.mp3File = mp3File;
    }
    
    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        else if(!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))||o==null) return false;
        else{
           Question q=(Question) o;
           return((this.correct==q.getCorrect())&&(this.genre.equals(q.getGenre()))&&(this.opt1.equals(q.getOpt1()))&&(this.opt2.equals(q.getOpt2()))&&(this.opt3.equals(q.getOpt3()))&&(this.opt4.equals(q.getOpt4()))&&(this.text.equals(q.getText()))&&(this.mp3File.equals(q.getMp3File()))&&this.score==q.getScore());
        }
    }
    
    public Question clone(){
        return new Question(this);
    }
}
