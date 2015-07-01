package Business;


import java.io.Serializable;
import java.util.Comparator;


/**
 * Classe que permitirá a ordenação de Trios Código Quantidade Faturação utilizando o seguinte algoritmo:
 * <p>->Deverá estar ordenado por quantidade,</p>
 * <p>->Para quantidades iguais ordenar alfabeticamente os códigos</p>
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class ComparatorTripleStringStringScore implements Comparator<TripleStringStringScore>,Serializable{
    /**
     * Método de comparação que cumpre os requisitos pedidos. Por questão de Complexão também foi realizada
     * a comparação de Faturações, caso todos os outros campos forem iguais
     * @param tcqf1 TrioCodQuantFat a ser comparado
     * @param tcqf2 TrioCodQuantFat a ser comparado
     * @return Valor comparativo entre tcqf1 e tcqf2
     */
    public int compare(TripleStringStringScore tcqf1,TripleStringStringScore tcqf2){
        if(tcqf1.getScore()!=tcqf2.getScore()) return tcqf2.getScore()-tcqf1.getScore();
        else if(!(tcqf1.getUsername().equals(tcqf2.getUsername()))) return tcqf1.getUsername().compareTo(tcqf2.getUsername());
        else return tcqf1.getString().compareTo(tcqf2.getString());
    }
}
