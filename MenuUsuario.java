import java.util.ArrayList;
import java.util.Scanner;

public class MenuUsuario {
    
    public void consultarPropriedades(ArrayList<Propriedade> propriedades) {
        System.out.println("\nPropriedades disponíveis:\n");
        for (Propriedade propriedade : propriedades) {
            if (!propriedade.isAlugada()) {
                System.out.println("ID: " + propriedade.getId() + " | " + propriedade.getTitulo() + " | " + propriedade.getLocalizacao());
                System.out.println(propriedade.getDescricao() + " | " + propriedade.getCapacidade() + " pessoas");
                System.out.println("R$" + propriedade.getPrecoPorNoite() + " por noite");
                if (propriedade.getAvaliacoes().size() > 0) {
                    System.out.printf("Avaliação média: %.1f estrelas\n", propriedade.getAvaliacaoMedia());
                    System.out.println("Avaliações:");
                    for (Avaliacao avaliacao : propriedade.getAvaliacoes()) {
                        System.out.println(avaliacao.getAutor().getNome() + " | Nota: " + avaliacao.getPontuacao() + " | " + avaliacao.getComentario());
                    }
                }
                System.out.println();
            }
        }
        
        System.out.println();
    }


    public void criarReserva(Usuario usuario, ArrayList<Propriedade> propriedades) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID da propriedade: ");
        int id = sc.nextInt();
        sc.nextLine();
        int index = 0;
        boolean achado = false;
        for (Propriedade propriedade : propriedades) {
            if (propriedade.getId() == id && !propriedade.isAlugada()) {
                
                System.out.println("Propriedade encontrada!\n");
                System.out.println("Propriedade: " + propriedade.getTitulo() + " | " + propriedade.getLocalizacao());
                System.out.println("Preço por noite: R$" + propriedade.getPrecoPorNoite() + "\n");
                System.out.print("Deseja continuar com a reserva? (S/N): ");
                String opcao = sc.nextLine();
                if (!opcao.toLowerCase().equals("s")) {
                    System.out.println("Reserva cancelada!\n");
                    return;
                }
                propriedade.setAlugada(true);
                index = propriedades.indexOf(propriedade);
                achado = true;
                break;
            }
        }

        if (!achado) {
            System.out.println("Propriedade não encontrada ou já está alugada!\n");
            return;
        }
        
        System.out.print("Noites: ");
        int noites = sc.nextInt();
        sc.nextLine();

        Reserva reserva = new Reserva(propriedades.get(index), usuario, noites);
        System.out.println("Preço total: R$" + reserva.getPrecoTotal() + "\n");
        usuario.getReservas().add(reserva);
        System.out.println("Reserva criada com sucesso!\n");
    }


    public void exibirReservas(Usuario usuario) {
        if (usuario.getReservas().size() == 0) {
            System.out.println("Você não possui reservas!\n");
            return;
        }

        System.out.println("Suas reservas:\n");
        for (Reserva reserva : usuario.getReservas()) {
            System.out.println("ID: " + reserva.getPropriedade().getId() + " | Propriedade: " + reserva.getPropriedade().getTitulo() + " | " + reserva.getPropriedade().getLocalizacao());
            System.out.println("Noites: " + reserva.getNoites() + " | Preço por noite: R$" + reserva.getPropriedade().getPrecoPorNoite());
            System.out.println("Preço total: R$" + reserva.getPrecoTotal());
            System.out.println();
        }
    }

    public void avaliarPropriedades(Usuario usuario) {
        Scanner sc = new Scanner(System.in);

        if (usuario.getReservas().size() == 0) {
            System.out.println("Você não possui reservas!\n");
            return;
        }

        System.out.println("Propriedades disponíveis para avaliação:");
        exibirReservas(usuario);

        boolean achado = false;
        int id = 0;

        while (id != -1) {
            System.out.print("Digite o ID da propriedade que deseja avaliar ou digite \"-1\" para sair: ");
            id = sc.nextInt();
            sc.nextLine();
            if (id == -1) {
                break;
            }
            for (Reserva reserva : usuario.getReservas()) {
                if (reserva.getPropriedade().getId() == id) {
                    achado = true;
                    int index = usuario.getReservas().indexOf(reserva);
                    System.out.println("Propriedade encontrada!");
                    System.out.print("Digite a nota da propriedade (1-5): ");
                    int nota = 0;
                    while (nota < 1 || nota > 5) {
                        nota = sc.nextInt();
                        sc.nextLine();
                        if (nota < 1 || nota > 5) {
                            System.out.print("Nota inválida! Digite novamente: ");
                        }
                    }

                    System.out.print("Digite o comentário da propriedade: ");
                    String comentario = sc.nextLine();

                    Avaliacao avaliacao = new Avaliacao(usuario, nota, comentario);
                    reserva.getPropriedade().getAvaliacoes().add(avaliacao);
                    reserva.getPropriedade().setAlugada(false);
                    usuario.getReservas().remove(index);
                    System.out.println("Avaliação criada com sucesso!\n");
                    break;
                }
            }
            if (usuario.getReservas().size() == 0) {
                System.out.println("Você não possui reservas!\n");
                return;
            }
            if (achado == false) {
                System.out.println("Propriedade não encontrada!\n");
            }
            achado = false;
        }
    }
}
