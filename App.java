import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static int id = 3; // Variável usada pra manter controle sobre os ids das propriedades
    static Helpers helpers = new Helpers(); // Objeto usado para imprimir os logos do programa
    
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Proprietario> proprietarios = new ArrayList<>();
        ArrayList<Propriedade> propriedades = new ArrayList<>();
        conteudoFalso(usuarios, propriedades, proprietarios); // Caso não queira usar os exemplos, comente essa linha
        app(usuarios, propriedades, proprietarios);
    }

    
    public static void conteudoFalso(ArrayList<Usuario> usuarios, ArrayList<Propriedade> propriedades, ArrayList<Proprietario> proprietarios) {
        
        // Método usado para adicionar alguns usuários, proprietários e propriedades para testar o programa
        Usuario usuario1 = new Usuario("João", "joao@gmail.com", "123");
        usuarios.add(usuario1);
        Usuario usuario2 = new Usuario("Maria", "maria@gmail.com", "456");
        usuarios.add(usuario2);

        Proprietario proprietario1 = new Proprietario("Paulo", "paulo@uol.com", "abc");
        proprietarios.add(proprietario1);
        Proprietario proprietario2 = new Proprietario("Ana", "ana@uol.com", "def");
        proprietarios.add(proprietario2);

        Propriedade propriedade1 = new Propriedade("Casa na praia", "Casa com 3 quartos, 2 banheiros, 1 cozinha e 1 sala", "Praia Grande", 6, 200, proprietario1, 0);
        propriedades.add(propriedade1);
        propriedade1.setAlugada(true);
        usuario1.getReservas().add(new Reserva(propriedade1, usuario1, 3));
        Propriedade propriedade2 = new Propriedade("Casa na montanha", "Casa com 2 quartos, 1 banheiro, 1 cozinha e 1 sala", "Monte Verde", 4, 150, proprietario2, 1);
        propriedades.add(propriedade2);
        Propriedade propriedade3 = new Propriedade("Casa na cidade", "Casa com 4 quartos, 3 banheiros, 1 cozinha e 1 sala", "São Paulo", 8, 300, proprietario1, 2);
        propriedades.add(propriedade3);
    }


    public static void app(ArrayList<Usuario> usuarios, ArrayList<Propriedade> propriedades, ArrayList<Proprietario> proprietarios) {
        
        // Método principal do programa, onde o usuário escolhe se quer logar ou cadastrar um usuário ou proprietário
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 5) {
            helpers.printLogo();
            System.out.println("1 - Login de usuário\n2 - Cadastro de usuário\n3 - Login de proprietário\n4 - Cadastro de proprietário\n5 - Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = helpers.getInt();
            
            String nome, email, senha;

            switch (opcao) {
            
                case 1:
                    System.out.print("Digite seu email: ");
                    email = sc.nextLine();
                    System.out.print("Digite sua senha: ");
                    senha = sc.nextLine();
                    Usuario usuarioLogado = loginUsuario(email, senha, usuarios);
                    if (usuarioLogado != null) {
                        menuUsuario(usuarioLogado, propriedades);
                    } else {
                        System.out.println("Email ou senha inválidos!\n");
                        wait(1500);
                    }
                    break;

                case 2:
                    System.out.print("Digite seu nome: ");
                    nome = sc.nextLine();

                    System.out.print("Digite seu email: ");
                    email = sc.nextLine();

                    System.out.print("Digite sua senha: ");
                    senha = sc.nextLine();
                    cadastrarUsuario(usuarios, nome, email, senha);
                    break;
                case 3:
                    System.out.print("Digite seu email: ");
                    email = sc.nextLine();
                    System.out.print("Digite sua senha: ");
                    senha = sc.nextLine();
                    Proprietario propritarioLogado = loginProprietario(email, senha, proprietarios);
                    if (propritarioLogado != null) {
                        menuProprietario(propritarioLogado, propriedades);
                    } else {
                        System.out.println("Email ou senha inválidos!\n");
                        wait(1500);
                    }
                    break;

                case 4:
                    System.out.print("Digite seu nome: ");
                    nome = sc.nextLine();

                    System.out.print("Digite seu email: ");
                    email = sc.nextLine();

                    System.out.print("Digite sua senha: ");
                    senha = sc.nextLine();
                    cadastrarProprietario(proprietarios, nome, email, senha);
                    break;    

                case 5:
                    System.out.println("Até mais!");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }


    public static void cadastrarUsuario(ArrayList<Usuario> usuarios , String nome, String email, String senha) {
        
        // Método usado para cadastrar um usuário
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                System.out.println("Email já cadastrado!\n");
                wait(1500);
                return;
            }
        }
        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!\n");
        wait(1500);
    }


    public static void cadastrarProprietario(ArrayList<Proprietario> proprietarios , String nome, String email, String senha) {
        
        // Método usado para cadastrar um proprietário
        for (Proprietario proprietario : proprietarios) {
            if (proprietario.getEmail().equals(email)) {
                System.out.println("Email já cadastrado!\n");
                wait(1500);
                return;
            }
        }
        Proprietario proprietario = new Proprietario(nome, email, senha);
        proprietarios.add(proprietario);
        System.out.println("Proprietário cadastrado com sucesso!\n");
        wait(1500);
    }


    public static Usuario loginUsuario(String email, String senha, ArrayList<Usuario> usuarios) {
        
        // Método usado para fazer login de um usuário
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }


    public static Proprietario loginProprietario(String email, String senha, ArrayList<Proprietario> proprietarios) {
        
        // Método usado para fazer login de um proprietário
        for (Proprietario proprietario : proprietarios) {
            if (proprietario.getEmail().equals(email) && proprietario.getSenha().equals(senha)) {
                return proprietario;
            }
        }
        return null;
    }

    
    public static void menuUsuario(Usuario usuario, ArrayList<Propriedade> propriedades) {
        
        // Método usado para exibir o menu do usuário
        Scanner sc = new Scanner(System.in);
        MenuUsuario menu = new MenuUsuario();
        int escolha = 0;
        while (escolha != 5) {
            helpers.printUser();
            System.out.println("Bem-vindo, " + usuario.getNome() + "!\n");
            System.out.print("1- Consultar propriedades\n2- Criar reserva\n3- Exibir reservas\n4- Avaliar propriedades\n5- Sair\nEscolha uma opção: ");
            escolha  = helpers.getInt();
            sc.nextLine();
            switch (escolha) {
                case 1:
                    menu.consultarPropriedades(propriedades);
                    System.out.println("Pressione enter para sair...");
                    sc.nextLine();
                    break;
                case 2:
                    menu.criarReserva(usuario, propriedades);
                    System.out.println("Pressione enter para continuar...");
                    sc.nextLine();
                    break;
                case 3:
                    menu.exibirReservas(usuario);
                    System.out.println("Pressione enter para sair...");
                    sc.nextLine();
                    break;
                case 4:
                    menu.avaliarPropriedades(usuario);
                    break;
                case 5:
                    System.out.println("Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida!");
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
            helpers.printProp();
            System.out.println("Bem-vindo, " + proprietario.getNome() + "!\n");
            System.out.print("1- Cadastrar propriedades\n2- Exibir propriedades\n3- Sair\nEscolha uma opção: ");
            escolha  = helpers.getInt();
            sc.nextLine();
            switch (escolha) {
                case 1:
                    System.out.print("Título da propriedade: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição da propriedade: ");
                    String descricao = sc.nextLine();
                    System.out.print("Localização da propriedade: ");
                    String localizacao = sc.nextLine();
                    System.out.print("Capacidade da propriedade: ");
                    int capacidade = helpers.getInt();
                    sc.nextLine();
                    while (capacidade <= 0) {
                        System.out.print("Capacidade inválida! Digite novamente: ");
                        capacidade = helpers.getInt();
                        sc.nextLine();
                    }
                    System.out.print("Preço por noite da propriedade: ");
                    double precoPorNoite = helpers.getDouble();
                    sc.nextLine();
                    while (precoPorNoite <= 0) {
                        System.out.print("Preço inválido! Digite novamente: ");
                        precoPorNoite = helpers.getDouble();
                        sc.nextLine();
                    }
                    menu.cadastrarPropriedade(propriedades, titulo, descricao, localizacao, capacidade, precoPorNoite, proprietario, id);
                    id++;
                    System.out.println("Propriedade cadastrada com sucesso!\n");
                    System.out.println("Pressione enter para continuar...");
                    sc.nextLine();
                    break;
                case 2:
                    menu.exibirPropriedades(propriedades, proprietario);
                    System.out.println("Pressione enter para sair...");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }


    public static void wait(int ms) {
        
        // Método usado para fazer o programa esperar um tempo em milissegundos
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}