import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cadastrar {


    public void cadastrarUsuario(ArrayList<Usuario> usuarios , String nome, String email, String senha) {
        // Método usado para cadastrar um usuário
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                System.out.println("Email já cadastrado!\n");
                return;
            }
        }
        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!\n");
    }

    
    public void cadastrarProprietario(ArrayList<Proprietario> proprietarios , String nome, String email, String senha) {
        
        // Método usado para cadastrar um proprietário
        for (Proprietario proprietario : proprietarios) {
            if (proprietario.getEmail().equals(email)) {
                System.out.println("Email já cadastrado!\n");
                return;
            }
        }
        Proprietario proprietario = new Proprietario(nome, email, senha);
        proprietarios.add(proprietario);
        System.out.println("Proprietário cadastrado com sucesso!\n");
    }
}
