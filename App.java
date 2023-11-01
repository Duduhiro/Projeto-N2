import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private static int id = 0; // Variável usada pra manter controle sobre os ids das propriedades
    static Helpers helpers = new Helpers(); // Objeto usado com alguns métodos de auxilio
    
    // Caso na execução do programa os logos em ASCII ficarem distorcidos por dimensões do terminal
    static boolean logos = true; // Altere essa variável para false para não printar os logos
    
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Proprietario> proprietarios = new ArrayList<>();
        ArrayList<Propriedade> propriedades = new ArrayList<>();
        conteudoFalso(usuarios, propriedades, proprietarios); // Caso não queira usar os exemplos, comente essa linha
        helpers.clearScreen();
        app(usuarios, propriedades, proprietarios);
    }

    
    public static void conteudoFalso(ArrayList<Usuario> usuarios, ArrayList<Propriedade> propriedades, ArrayList<Proprietario> proprietarios) {
        
        // Método usado para adicionar alguns usuários, proprietários e propriedades para testar o programa
        Usuario usuario1 = new Usuario("João", "joao@gmail.com", "123");
        usuarios.add(usuario1);
        Usuario usuario2 = new Usuario("Maria", "maria@gmail.com", "456");
        usuarios.add(usuario2);
        
        Proprietario proprietario1 = new Proprietario("Paulo", "paulo@gmail.com", "abc");
        proprietarios.add(proprietario1);
        Proprietario proprietario2 = new Proprietario("Ana", "ana@gmail.com", "def");
        proprietarios.add(proprietario2);

        Propriedade propriedade1 = new Propriedade("Casa na praia", "Casa com 3 quartos, 2 banheiros, 1 cozinha e 1 sala", "Praia Grande", 6, 200, proprietario1, 0);
        propriedades.add(propriedade1);
        usuario1.getReservas().add(new Reserva(propriedade1, usuario1, 3));
        Propriedade propriedade2 = new Propriedade("Casa na montanha", "Casa com 2 quartos, 1 banheiro, 1 cozinha e 1 sala", "Monte Verde", 4, 150, proprietario2, 1);
        propriedades.add(propriedade2);
        Propriedade propriedade3 = new Propriedade("Casa na cidade", "Casa com 4 quartos, 3 banheiros, 1 cozinha e 1 sala", "São Paulo", 8, 300, proprietario1, 2);
        propriedades.add(propriedade3);
        id = 3;
    }


    public static void app(ArrayList<Usuario> usuarios, ArrayList<Propriedade> propriedades, ArrayList<Proprietario> proprietarios) {
        
        // Método principal do programa, onde o usuário escolhe se quer logar ou cadastrar um usuário ou proprietário
        Scanner sc = new Scanner(System.in);
        Cadastrar cad = new Cadastrar();
        Login log = new Login();
        int opcao = 0;
        while (opcao != 5) {
            helpers.printLogo(logos);
            System.out.println("1 - Login de usuário\n2 - Cadastro de usuário\n3 - Login de proprietário\n4 - Cadastro de proprietário\n5 - Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = helpers.getInt();
            
            String nome, email, senha;

            switch (opcao) {
            
                case 1:
                    helpers.clearScreen();
                    System.out.println("\n--= LOGIN DE USUÁRIO =--\n");
                    Usuario usuarioLogado = log.loginUsuario(usuarios);
                    if (usuarioLogado != null) {
                        menuUsuario(usuarioLogado, propriedades);
                    } else {
                        System.out.println("Email ou senha inválidos!\n");
                        System.out.print("Pressione ENTER para continuar...");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    helpers.clearScreen();
                    System.out.println("\n--= CADASTRO DE PROPRIETÁRIO =--\n");
                    cad.cadastrarUsuario(usuarios);
                    break;
                
                case 3:
                    helpers.clearScreen();
                    System.out.println("\n--= LOGIN DE PROPRIETÁRIO =--\n");
                    Proprietario propritarioLogado = log.loginProprietario(proprietarios);
                    if (propritarioLogado != null) {
                        menuProprietario(propritarioLogado, propriedades);
                    } else {
                        System.out.println("Email ou senha inválidos!\n");
                        System.out.print("Pressione ENTER para continuar...");
                        sc.nextLine();
                    }
                    break;

                case 4:
                    helpers.clearScreen();
                    System.out.println("\n--= CADASTRO DE PROPRIETÁRIO =--\n");
                    cad.cadastrarProprietario(proprietarios);
                    break;    

                case 5:
                    helpers.clearScreen();
                    helpers.printSeeYa(logos);
                    return;

                default:
                    helpers.clearScreen();
                    helpers.printError(logos);
                    System.out.print("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;
            }
            helpers.clearScreen();
        }
        sc.close();
    }

    
    public static void menuUsuario(Usuario usuario, ArrayList<Propriedade> propriedades) {
        
        // Método usado para exibir o menu do usuário
        Scanner sc = new Scanner(System.in);
        MenuUsuario menu = new MenuUsuario();
        int escolha = 0;
        while (escolha != 5) {
            helpers.clearScreen();
            helpers.printUser(logos);
            System.out.println("Bem-vindo, " + usuario.getNome() + "!\n");
            System.out.print("1- Consultar propriedades\n2- Criar reserva\n3- Exibir reservas\n4- Finalizar reserva\n5- Sair\nEscolha uma opção: ");
            escolha  = helpers.getInt();
            switch (escolha) {
                case 1:
                    helpers.clearScreen();
                    System.out.println("\n--= CONSULTAR PROPRIEDADES =--");
                    menu.consultarPropriedades(propriedades);
                    System.out.print("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;
                case 2:
                    helpers.clearScreen();
                    System.out.println("\n--= CRIAR RESERVA =--\n");
                    menu.criarReserva(usuario, propriedades);
                    System.out.print("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;
                case 3:
                    helpers.clearScreen();
                    System.out.println("\n--= EXIBIR RESERVAS =--\n");
                    menu.exibirReservas(usuario);
                    System.out.print("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;
                case 4:
                    helpers.clearScreen();
                    System.out.println("\n--= FINALIZAR RESERVA =--\n");
                    menu.finalizarReserva(usuario);
                    System.out.println("\nPressione ENTER para continuar...");
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Até mais!");
                    return;
                default:
                    helpers.clearScreen();
                    helpers.printError(logos);
                    System.out.println("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;
            }
        }
        sc.close();
    }


    public static void menuProprietario(Proprietario proprietario, ArrayList<Propriedade> propriedades) {
        
        // Método usado para exibir o menu do proprietário
        Scanner sc = new Scanner(System.in);
        MenuProprietario menu = new MenuProprietario();
        int escolha = 0;
        while (escolha != 4) {
            helpers.clearScreen();
            helpers.printProp(logos);
            System.out.println("Bem-vindo, " + proprietario.getNome() + "!\n");
            System.out.print("1- Cadastrar propriedades\n2- Exibir propriedades\n3- Exibir alugadas\n4- Sair\nEscolha uma opção: ");
            escolha  = helpers.getInt();
            switch (escolha) {
                case 1:
                    helpers.clearScreen();
                    System.out.println("\n--= CADASTRAR PROPRIEDADES =--\n");
                    boolean opStat = menu.cadastrarPropriedade(propriedades, proprietario, id);
                    if (opStat) {
                        id++;
                        System.out.println("Propriedade cadastrada com sucesso!\n");
                        System.out.print("Pressione ENTER para continuar...");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    helpers.clearScreen();
                    System.out.println("\n--= EXIBIR PROPRIEDADES =--\n");
                    menu.exibirPropriedades(propriedades, proprietario);
                    System.out.print("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;
                case 3:
                    helpers.clearScreen();
                    System.out.println("\n--= EXIBIR ALUGADAS =--\n");
                    menu.exibirAlugadas(propriedades, proprietario);
                    System.out.print("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Até mais!");
                    return;
                default:
                    helpers.clearScreen();
                    helpers.printError(logos);
                    System.out.println("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;
            }
        }
        sc.close();
    }


}