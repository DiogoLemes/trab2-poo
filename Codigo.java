import java.util.LinkedHashSet;
import java.util.Set;

public class Codigo {
    public String classe, pacote;
    Set<Atributos> atributos = new LinkedHashSet<>();

    public Codigo(){
    }

    public Codigo(String nomeClasse, String nomePacote, Set<Atributos> atributos){
        this.classe = nomeClasse;
        this.pacote = nomePacote;
        this.atributos = atributos;
    }

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getPacote() {
        return this.pacote;
    }

    public void setPacote(String pacote) {
        this.pacote = pacote;
    }

    public Set<Atributos> getAtributos() {
        return this.atributos;
    }

    public void setAtributos(Set<Atributos> atributos) {
        this.atributos = atributos;
    }

    public void addAtributos(Atributos atributo){
        atributos.add(atributo);
    }
}
