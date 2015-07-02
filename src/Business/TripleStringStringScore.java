package Business;


import java.util.Arrays;

/**
 * Trio Código/Quantidade/Faturação
 *
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class TripleStringStringScore {

    private String string;
    private String username;
    private int score;

    /**
     * Construtor Vazio
     */
    public TripleStringStringScore() {
        this.string = "";
        this.username="";
        this.score = 0;
    }

    public TripleStringStringScore(String string, String username, int score) {
        this.string = string;
        this.username = username;
        this.score = score;
    }

    /**
     * Construtor Parametrizado
     *
     * @param codigo Código de Produto
     * @param quantidade Quantidade vendida
     * @param faturacao Faturação registada
     */
    

    /**
     * Construtor de cópia
     *
     * @param tcqc Trio a ser copiado
     */
    public TripleStringStringScore(TripleStringStringScore tcqc) {
        this.string = tcqc.getString();
        this.username= tcqc.getUsername();
        this.score=tcqc.getScore();
    }

    public int getScore() {
        return score;
    }

    public String getString() {
        return string;
    }

    public String getUsername() {
        return username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
 
    /**
     *
     * @return Novo objecto como cópia da instância actual
     */
    public TripleStringStringScore clone() {
        return new TripleStringStringScore(this);
    }
    /**
     * Teste de igualdade
     * @param o Objecto a ser testado
     * @return True se this e o forem semanticamente iguais, False caso contrário
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            TripleStringStringScore trio = (TripleStringStringScore) o;
            return (this.string.equals(trio.getString())) && (this.username.equals(trio.getUsername())) && (this.score == trio.getScore());
        }
    }

    /**
     *
     * @return HashCode do Trio
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.string, this.score, this.username});
    }

    /**
     *
     * @return Representação textual da instância
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Genre ");
        sb.append(this.string);
        sb.append("; ");
        sb.append("Username ");
        sb.append(this.username);
        sb.append("; ");
        sb.append("Score ");
        sb.append(this.score);
        
        return sb.toString();
    }

}
