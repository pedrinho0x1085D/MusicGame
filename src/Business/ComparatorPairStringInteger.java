package Business;


import java.io.Serializable;
import java.util.Comparator;




public class ComparatorPairStringInteger implements Comparator<PairStringInteger>,Serializable{

 
    public int compare(PairStringInteger pcq1,PairStringInteger pcq2){
        if(pcq1.getInteger()!=pcq2.getInteger()) return pcq2.getInteger()-pcq1.getInteger();
        else return pcq1.getString().compareTo(pcq2.getString());
    }
}
