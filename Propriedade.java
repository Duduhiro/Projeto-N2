import java.util.ArrayList;

public class Propriedade {

    private int id;
    private String titulo;
    private String descricao;
    private String localizacao; 
    private int capacidade;
    private double precoPorNoite;
    private Proprietario proprietario;
    private boolean alugada = false;
    private ArrayList<Avaliacao> avaliacoes;

    public Propriedade (String titulo, String descricao, String localizacao, int capacidade, double precoPorNoite, Proprietario proprietario, int id) {
        avaliacoes = new ArrayList<>();
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.precoPorNoite = precoPorNoite;
        this.proprietario = proprietario;
        this.id = id;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public double getPrecoPorNoite() {
        return precoPorNoite;
    }
    public Proprietario getProprietario() {
        return proprietario;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAlugada(boolean alugada) {
        this.alugada = alugada;
    }
    public boolean isAlugada() {
        return alugada;
    }
    public int getId() {
        return id;
    }
    public double getAvaliacaoMedia() {
        double media = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            media += avaliacao.getPontuacao();
        }
        return media / avaliacoes.size();
    }

}