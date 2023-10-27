import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cadastrar {

    public static boolean verificaEmail(String email) {

        // Verifica se o email é válido a partir do uso de REGEX
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        boolean match = matcher.find();
        return match;
    }


    public void cadastrarUsuario(ArrayList<Usuario> usuarios , String nome, String email, String senha) {
        // Método usado para cadastrar um usuário
        if (!verificaEmail(email)) {
            System.out.println("Email inválido!\n");
            return;
        }
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
        
        // Método usado para cadastrar um proprietário]
        if (!verificaEmail(email)) {
            System.out.println("Email inválido!\n");
            return;
        }
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
