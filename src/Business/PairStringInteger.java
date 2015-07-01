/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Pedro Cunha
 */
public class PairStringInteger {
    private String string;
    private int integer;

    public PairStringInteger(String string, int integer) {
        this.string = string;
        this.integer = integer;
    }
    public PairStringInteger(PairStringInteger psi){
        this.string=psi.getString();
        this.integer=psi.getInteger();
    }

    public int getInteger() {
        return integer;
    }

    public String getString() {
        return string;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public void setString(String string) {
        this.string = string;
    }
    
    public boolean equals(Object ot){
        if(this==ot) return true;
        else if((!(this.getClass().getSimpleName().equals(ot.getClass().getSimpleName())))||ot==null) return false;
        else{
            PairStringInteger pcq=(PairStringInteger) ot;
            return (this.string.equals(pcq.getString()))&&(this.integer==pcq.getInteger());
        }
    }
}
