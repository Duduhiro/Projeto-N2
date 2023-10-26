import java.util.ArrayList;

public class MenuProprietario {

    public void cadastrarPropriedade(ArrayList<Propriedade> propriedades, String titulo, String descricao, String localizacao, int capacidade, double precoPorNoite, Proprietario proprietario, int id) {
        
        // Método que cadastra uma propriedade
        Propriedade propriedade = new Propriedade(titulo, descricao, localizacao, capacidade, precoPorNoite, proprietario, id);
        propriedades.add(propriedade);
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
