import java.util.ArrayList;

public class Proprietario extends Usuario {

    private ArrayList<Propriedade> propriedades;

    public Proprietario(String nome, String email, String senha) {
        super(nome, email, senha);
        propriedades = new ArrayList<>();
    }

    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }
    
}
