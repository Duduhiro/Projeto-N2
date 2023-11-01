import java.util.ArrayList;
import java.util.Scanner;

public class Login {
 
    public Usuario loginUsuario(ArrayList<Usuario> usuarios) {
        
        // Método usado para fazer login de um usuário

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }


    public Proprietario loginProprietario(ArrayList<Proprietario> proprietarios) {
        
        // Método usado para fazer login de um proprietário

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        for (Proprietario proprietario : proprietarios) {
            if (proprietario.getEmail().equals(email) && proprietario.getSenha().equals(senha)) {
                return proprietario;
            }
        }
        return null;
    }

}
