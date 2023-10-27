import java.util.ArrayList;

public class Login {
 
    public Usuario loginUsuario(String email, String senha, ArrayList<Usuario> usuarios) {
        
        // Método usado para fazer login de um usuário
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }


    public Proprietario loginProprietario(String email, String senha, ArrayList<Proprietario> proprietarios) {
        
        // Método usado para fazer login de um proprietário
        for (Proprietario proprietario : proprietarios) {
            if (proprietario.getEmail().equals(email) && proprietario.getSenha().equals(senha)) {
                return proprietario;
            }
        }
        return null;
    }

}
