import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Cadastrar {


    public void cadastrarUsuario(ArrayList<Usuario> usuarios) {
        // Método usado para cadastrar um usuário
        
        Scanner sc = new Scanner(System.in);
        Helpers helpers = new Helpers();

        System.out.print("Digite seu nome (digite 'sair' para cancelar): ");
        String nome = sc.nextLine();
        if (nome.toLowerCase().equals("sair")) {
            helpers.opCancelada();
            return;
        }
        System.out.print("Digite seu email (digite 'sair para cancelar'): ");
        String email = sc.nextLine();
        if (email.toLowerCase().equals("sair")) {
            helpers.opCancelada();
            return;
        }
        if (!helpers.verificaEmail(email)) {
            System.out.print("Email inválido!\n");
            System.out.print("Pressione ENTER para continuar...");
            sc.nextLine();
            return;
        }
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();
        
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                System.out.println("Email já cadastrado!\n");
                return;
            }
        }
        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!\n");
        System.out.print("Pressione ENTER para continuar...");
        sc.nextLine();
    }

    
    public void cadastrarProprietario(ArrayList<Proprietario> proprietarios) {
        
        // Método usado para cadastrar um proprietário
        Scanner sc = new Scanner(System.in);
        Helpers helpers = new Helpers();

        System.out.print("Digite seu nome (digite 'sair' para cancelar): ");
        String nome = sc.nextLine();
        if (nome.toLowerCase().equals("sair")) {
            helpers.opCancelada();
            return;
        }
        System.out.print("Digite seu email (digite 'sair para cancelar'): ");
        String email = sc.nextLine();
        if (email.toLowerCase().equals("sair")) {
            helpers.opCancelada();
            return;
        }
        if (!helpers.verificaEmail(email)) {
            System.out.println("Email inválido!\n");
            System.out.print("Pressione ENTER para continuar...");
            sc.nextLine();
            return;
        }
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        for (Proprietario proprietario : proprietarios) {
            if (proprietario.getEmail().equals(email)) {
                System.out.println("Email já cadastrado!\n");
                return;
            }
        }
        Proprietario proprietario = new Proprietario(nome, email, senha);
        proprietarios.add(proprietario);
        System.out.println("Proprietário cadastrado com sucesso!\n");
        System.out.print("Pressione ENTER para continuar...");
        sc.nextLine();
    }
}
