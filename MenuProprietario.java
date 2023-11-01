import java.util.ArrayList;
import java.util.Scanner;

public class MenuProprietario {

    public boolean cadastrarPropriedade(ArrayList<Propriedade> propriedades, Proprietario proprietario, int id) {
        
        // Método que cadastra uma propriedade

        Scanner sc = new Scanner(System.in);
        Helpers helpers = new Helpers();

        System.out.print("Título da propriedade (digite 'sair' para cancelar): ");
        String titulo = sc.nextLine();
        if (titulo.toLowerCase().equals("sair")) {
            helpers.opCancelada();
            return false;
        }
        System.out.print("Descrição da propriedade (digite 'sair' para cancelar): ");
        String descricao = sc.nextLine();
        if (descricao.toLowerCase().equals("sair")) {
            helpers.opCancelada();
            return false;
        }
        System.out.print("Localização da propriedade: ");
        String localizacao = sc.nextLine();
        if (localizacao.toLowerCase().equals("sair")) {
            helpers.opCancelada();
            return false;
        }
        System.out.print("Capacidade da propriedade (digite -1 para sair): ");
        int capacidade = helpers.getInt();
        while (capacidade <= 0) {
            if (capacidade == -1) {
                helpers.opCancelada();
                return false;
            }
            System.out.print("Capacidade inválida! Digite novamente: ");
            capacidade = helpers.getInt();
        }
        System.out.print("Preço por noite da propriedade (digite -1 para sair): ");
        double precoPorNoite = helpers.getDouble();
        while (precoPorNoite <= 0) {
            if (precoPorNoite == -1) {
                helpers.opCancelada();
                return false;
            }
            System.out.print("Preço inválido! Digite novamente: ");
            precoPorNoite = helpers.getDouble();
        }

        Propriedade propriedade = new Propriedade(titulo, descricao, localizacao, capacidade, precoPorNoite, proprietario, id);
        propriedades.add(propriedade);
        return true;
    }

    public void exibirPropriedades(ArrayList<Propriedade> propriedades, Proprietario proprietario) {
        
        // Método que exibe todas as propriedades do proprietário
        System.out.println("\nPropriedades cadastradas:\n");
        for (Propriedade propriedade : propriedades) {
            if (propriedade.getProprietario().getNome().equals(proprietario.getNome())) {
                System.out.println("ID: " + propriedade.getId() + " | " + propriedade.getTitulo() + " | " + propriedade.getLocalizacao());
                System.out.println(propriedade.getDescricao() + " | " + propriedade.getCapacidade() + " pessoas");
                System.out.println("R$" + propriedade.getPrecoPorNoite() + " por noite");
                if (propriedade.isAlugada()) {
                    System.out.println("Status: Alugada");
                } else {
                    System.out.println("Status: Disponível");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public void exibirAlugadas(ArrayList<Propriedade> propriedades, Proprietario proprietario) {
        
        // Método que exibe as propriedades do proprietário que estão alugadas
        System.out.println("\nPropriedades alugadas:\n");
        for (Propriedade propriedade : propriedades) {
            if (propriedade.getProprietario().getNome().equals(proprietario.getNome()) && propriedade.isAlugada()) {
                System.out.println("ID: " + propriedade.getId() + " | " + propriedade.getTitulo() + " | " + propriedade.getLocalizacao());
                System.out.println(propriedade.getDescricao() + " | " + propriedade.getCapacidade() + " pessoas");
                System.out.println("R$" + propriedade.getPrecoPorNoite() + " por noite");
                System.out.println();
            }
        }
        System.out.println();

    }

}
